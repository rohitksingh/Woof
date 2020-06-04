package com.rohitksingh.woof;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DogListFragment extends Fragment {

    private RecyclerView rv;
    private LinearLayoutManager llm;
    private DogListAdapter adapter;

    public static DogListFragment getInstance(){
        return new DogListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_dog_list, parent, false);
        rv = view.findViewById(R.id.rv);
        return view;
    }
}
