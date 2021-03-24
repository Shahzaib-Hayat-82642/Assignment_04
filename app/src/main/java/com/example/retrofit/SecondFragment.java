package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.retrofit.models.Models;
import com.example.retrofit.models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondFragment extends Fragment {
    /*ImageView imageView2;
    TextView name,city;*/
    private RecyclerView rvUserList;
    private ProgressBar progressBar;


    public SecondFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
/*
        imageView2 = view.findViewById(R.id.imageView2);
        name = view.findViewById(R.id.name);
        city = view.findViewById(R.id.city);


        Intent intent = getIntent();
        imageView2.setImageResource(intent.getIntExtra("image",0));
        name.setText(intent.getStringExtra("name"));
        city.setText(intent.getStringExtra("city"));

*/

        rvUserList = view.findViewById(R.id.rvUserList);
        progressBar = view.findViewById(R.id.progressBar);

        final UserAdapter adapter = new UserAdapter();
        rvUserList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvUserList.setAdapter(adapter);

        RetrofitInterface client = RetrofitClient.getClient().create(RetrofitInterface.class);
        client.fetchUsers(1).enqueue(new Callback<Models>() {
            @Override
            public void onResponse(Call<Models> call, Response<Models> response) {
                List<Result> mlist = response.body().getResults();
                progressBar.setVisibility(View.INVISIBLE);
                adapter.setData(mlist);
            }

            @Override
            public void onFailure(Call<Models> call, Throwable t) {
                Log.e("Main", t.toString());
            }
        });





        return view;
    }
}