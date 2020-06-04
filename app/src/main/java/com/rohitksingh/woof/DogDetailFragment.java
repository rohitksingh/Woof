package com.rohitksingh.woof;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import androidx.fragment.app.Fragment;

public class DogDetailFragment extends Fragment {

    private ImageView dogImage;
    private DogModel dogModel;
    private Context context;

    public static DogDetailFragment getInstance(DogModel dogModel){
        Bundle bundle = new Bundle();
        bundle.putSerializable("DOG_DETAIL", dogModel);
        DogDetailFragment fragment = new DogDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_dog_detail, parent, false);
        dogImage = view.findViewById(R.id.dogImage);
        dogModel = (DogModel) getArguments().getSerializable("DOG_DETAIL");
        Glide.with(context)
                .load(dogModel.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(dogImage);
        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.context = context;
    }
}
