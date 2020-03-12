package com.flege.gumukrejo.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.flege.gumukrejo.R;
import com.flege.gumukrejo.SmartArthesisActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class BerandaFragment extends Fragment {
    private CarouselView carouselView;
    private RelativeLayout smartarthesis, smartwarung, museumdigital, polling, digitalsociety, lapor, usulan, survey, nomorpenting, admin, administrasi, lainnya;

    ArrayList<Integer> slide_image = new ArrayList<>();

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_beranda, container, false);
        slide_image.add(R.drawable.logo_landscape_round);
        slide_image.add(R.drawable.gambar1);
        slide_image.add(R.drawable.gambar2);

        carouselView = v.findViewById(R.id.carouselView);
        carouselView.setPageCount(slide_image.size());
        carouselView.setImageListener(imageListener);

        smartarthesis = v.findViewById(R.id.smartarthesis);
        smartwarung = v.findViewById(R.id.smartwarung);
        museumdigital = v.findViewById(R.id.museumdigital);
        polling = v.findViewById(R.id.polling);
        digitalsociety = v.findViewById(R.id.digitalsociety);
        lapor = v.findViewById(R.id.lapor);
        usulan = v.findViewById(R.id.usulan);
        survey = v.findViewById(R.id.survey);
        nomorpenting = v.findViewById(R.id.nomorpenting);
        admin = v.findViewById(R.id.admin);
        administrasi = v.findViewById(R.id.administrasi);
        lainnya = v.findViewById(R.id.lainnya);

        smartarthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SmartArthesisActivity.class);
                startActivity(intent);
            }
        });
        smartwarung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        museumdigital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        polling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),PollingActivity.class);
                startActivity(intent);
            }
        });
        digitalsociety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        lapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        usulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        nomorpenting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        administrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        lainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Under Maintenance",Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    private ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(slide_image.get(position));
        }
    };

}
