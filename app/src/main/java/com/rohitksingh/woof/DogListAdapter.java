package com.rohitksingh.woof;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.DogViewHolder> {

    private Context context;
    private List<DogModel> dogList;

    public DogListAdapter(Context context, List<DogModel> dogList) {
        this.context = context;
        this.dogList = dogList;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dog, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        DogModel dogModel = dogList.get(position);
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder{

        ImageView dogImage;

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
            dogImage = itemView.findViewById(R.id.dogImage);
        }
    }
}
