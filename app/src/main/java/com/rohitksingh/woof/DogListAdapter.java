package com.rohitksingh.woof;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rohitksingh.woof.callbacks.ItemClickCallBack;
import com.rohitksingh.woof.callbacks.PaginationCallBack;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.DogViewHolder> {

    private Context context;
    private List<DogModel> dogList;
    private PaginationCallBack paginationCallBack;
    private ItemClickCallBack itemClickCallBack;

    public DogListAdapter(Context context, List<DogModel> dogList, PaginationCallBack paginationCallBack) {
        this.context = context;
        this.dogList = dogList;
        this.paginationCallBack = paginationCallBack;
        this.itemClickCallBack = (ItemClickCallBack)context;
    }

    public void updateDataSet(List<DogModel> newResult){
        if(newResult!=null){
            dogList = newResult;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dog, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {

        final DogModel dogModel = dogList.get(position);

        Glide.with(context)
                .load(dogModel.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(holder.dogImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickCallBack.onItemClicked(dogModel);
            }
        });

        if(position+1==dogList.size()){
            paginationCallBack.loadMore();
        }
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
