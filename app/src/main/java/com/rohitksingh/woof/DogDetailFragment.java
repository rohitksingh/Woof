package com.rohitksingh.woof;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class DogDetailFragment extends Fragment {

    private ImageView dogImage;

    public static DogDetailFragment getInstance(){
        return new DogDetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_dog_detail, parent, false);
        dogImage = view.findViewById(R.id.dogImage);
        return view;
    }
}
