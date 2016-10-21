package com.uspenskii.onshop.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.uspenskii.onshop.LoginActivity;
import com.uspenskii.onshop.R;
import com.uspenskii.onshop.Smartphonepage;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentHome.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Context context;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }

    public FragmentHome() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        context = container.getContext();


        rootView.findViewById(R.id.RelativeLayout1).setOnClickListener(this);
        rootView.findViewById(R.id.RelativeLayout2).setOnClickListener(this);
        rootView.findViewById(R.id.RelativeLayout3).setOnClickListener(this);
        rootView.findViewById(R.id.RelativeLayout4).setOnClickListener(this);
        rootView.findViewById(R.id.RelativeLayout5).setOnClickListener(this);
        rootView.findViewById(R.id.RelativeLayout6).setOnClickListener(this);
        rootView.findViewById(R.id.RelativeLayout7).setOnClickListener(this);
        rootView.findViewById(R.id.RelativeLayout8).setOnClickListener(this);
        rootView.findViewById(R.id.RelativeLayout9).setOnClickListener(this);


        final EditText editText = (EditText) rootView.findViewById(R.id.editText);
        rootView.findViewById(R.id.editText);
        rootView.findViewById(R.id.imageButtonSeach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(context, Smartphonepage.class).putExtra("search_request", String.valueOf(editText.getText()) ));
            }
        });



        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.RelativeLayout1:
                startActivity(new Intent(context, Smartphonepage.class).putExtra("type","CellPhone"));
                break;
            case R.id.RelativeLayout2:
                startActivity(new Intent(context, Smartphonepage.class).putExtra("type","Tablet"));
                break;
            case R.id.RelativeLayout3:
                startActivity(new Intent(context, Smartphonepage.class).putExtra("type","param2"));
                break;
            case R.id.RelativeLayout4:
                startActivity(new Intent(context, Smartphonepage.class).putExtra("type","param3"));
                break;
            case R.id.RelativeLayout5:
                startActivity(new Intent(context, Smartphonepage.class).putExtra("type","param4"));
                break;
            case R.id.RelativeLayout6:
                startActivity(new Intent(context, Smartphonepage.class).putExtra("type","param5"));
                break;
            case R.id.RelativeLayout7:
                startActivity(new Intent(context, Smartphonepage.class).putExtra("type","param6"));
                break;
            case R.id.RelativeLayout8:
                startActivity(new Intent(context, Smartphonepage.class).putExtra("type","param7"));
                break;
            case R.id.RelativeLayout9:
                startActivity(new Intent(context, LoginActivity.class).putExtra("type","param8"));
                break;

        }

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);


    }

}