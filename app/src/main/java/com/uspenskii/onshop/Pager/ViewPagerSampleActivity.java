package com.uspenskii.onshop.Pager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.uspenskii.onshop.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        LayoutInflater inflater = LayoutInflater.from(this);
//        List<View> pages = new ArrayList<View>();
//
//        View page = inflater.inflate(R.layout.fragment_home, null);
//        TextView textView = (TextView) page.findViewById(R.id.text_view);
//        textView.setText("Страница 1");
//        pages.add(page);
//
//        page = inflater.inflate(R.layout.fragment_home, null);
//        textView = (TextView) page.findViewById(R.id.text_view);
//        textView.setText("Страница 2");
//        pages.add(page);
//
//        page = inflater.inflate(R.layout.fragment_home, null);
//        textView = (TextView) page.findViewById(R.id.text_view);
//        textView.setText("Страница 3");
//        pages.add(page);
//
//        SamplePagerAdapter pagerAdapter = new SamplePagerAdapter(pages);
//        ViewPager viewPager = new ViewPager(this);
//        viewPager.setAdapter(pagerAdapter);
//        viewPager.setCurrentItem(1);
//
//        setContentView(viewPager);
    }
}