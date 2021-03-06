package com.rohitksingh.woof.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rohitksingh.woof.DogListAdapter;
import com.rohitksingh.woof.DogModel;
import com.rohitksingh.woof.R;
import com.rohitksingh.woof.callbacks.PaginationCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class DogListFragment extends Fragment implements PaginationCallBack {

    private RecyclerView rv;
    private StaggeredGridLayoutManager llm;
    private DogListAdapter adapter;
    private ArrayList<DogModel> dogList;
    private Context context;

    public static DogListFragment getInstance(){
        return new DogListFragment();
    }

    //Saves list content
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("STATE_COUNTER", dogList);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){
            dogList = new ArrayList<>();
        }else {
            dogList = (ArrayList<DogModel>) savedInstanceState.getSerializable("STATE_COUNTER");
        }
        adapter = new DogListAdapter(context, dogList, this);
        if(savedInstanceState==null){
            getListFromServer();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_dog_list, parent, false);
        rv = view.findViewById(R.id.rv);
        llm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
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
        String url = "https://dog.ceo/api/breed/hound/images/random/20";
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray array = jsonObject.getJSONArray("message");

                            for(int i=0;i<array.length();i++){
                                String imageUrl = array.getString(i);
                                dogList.add(new DogModel(imageUrl));
                            }
                            adapter.updateDataSet(dogList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(request);
    }

    @Override
    public void loadMore() {
        getListFromServer();
    }
}
