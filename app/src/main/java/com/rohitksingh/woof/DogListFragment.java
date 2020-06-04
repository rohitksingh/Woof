package com.rohitksingh.woof;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DogListFragment extends Fragment {

    private RecyclerView rv;
    private LinearLayoutManager llm;
    private DogListAdapter adapter;
    private List<DogModel> dogList;
    private Context context;

    public static DogListFragment getInstance(){
        return new DogListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        dogList = new ArrayList<>();
        adapter = new DogListAdapter(context, dogList);
        llm = new LinearLayoutManager(context);
        getListFromServer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_dog_list, parent, false);
        rv = view.findViewById(R.id.rv);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.context = context;
    }

    public void getListFromServer(){

    }
}
