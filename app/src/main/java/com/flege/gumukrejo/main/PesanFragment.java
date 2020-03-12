package com.flege.gumukrejo.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.flege.gumukrejo.R;

import java.util.ArrayList;

public class PesanFragment extends Fragment {
    ListView list_pesan;
    ArrayList<String> l_pesan = new ArrayList<>();

    TextView notification_text;

    public PesanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pesan, container, false);
//        list_pesan = v.findViewById(R.id.list_pesan);
        notification_text = v.findViewById(R.id.notification_text);

//        if(l_pesan.isEmpty()){
//            notification_text.setVisibility(View.VISIBLE);
//        }else{
//            notification_text.setVisibility(View.GONE);
//        }

        return v;
    }

}
