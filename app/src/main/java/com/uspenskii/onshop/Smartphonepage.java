package com.uspenskii.onshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Smartphonepage extends AppCompatActivity {
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smartphone);


//        final ListView listView = (ListView) findViewById(R.id.listView);



        Thread thread = new Thread() {
            @Override
            public void run() {
                try {

                    String sURL;
                    if(getIntent().getStringExtra("type") != null)
                        sURL = "http://192.168.0.106:5000/api?action=getGoods&type="+  getIntent().getStringExtra("type");
                    else{
                        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
                        sURL = "http://192.168.0.106:5000/api?action=searchRequest&search="+  getIntent().getStringExtra("search_request");
                    }

                    URL url = new URL(sURL);
                    HttpURLConnection request = (HttpURLConnection) url.openConnection();
                    request.connect();


                    JsonParser jp = new JsonParser(); //from gson
                    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
                    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.


                    final JsonArray jsonArray = rootobj.get("list").getAsJsonArray();

                    final ArrayList<Drawable> images = new ArrayList<>();
                    final ArrayList<String> names = new ArrayList<>();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        images.add(new BitmapDrawable(getResources(), LoadImageFromWebOperations(String.valueOf(jsonArray.get(i).getAsJsonObject().get("image").getAsString()))));
                        names.add( jsonArray.get(i).getAsJsonObject().get("text").getAsString());
                    }



                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {


                            GridView gridview = (GridView) findViewById(R.id.gridview);
                            gridview.setAdapter(new CustomAdapter(context, names,images));

//                                    textView.setText(String.valueOf(jsonArray.get(1).getAsJsonObject().get("text").getAsString()));
//                                    imageView.setImageDrawable(drawable);
//                                    button.setText(String.valueOf(jsonArray.get(1).getAsJsonObject().get("type")));
//                                    listView.setAdapter(new CustomAdapter(context, names,images));
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;

            }
        };
        thread.start();


    }

    public static Bitmap LoadImageFromWebOperations(final String url) {

        try {
            InputStream in = new URL(url).openStream();
            return BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("log" ,e.getLocalizedMessage());
        }
        return null;
    }



}