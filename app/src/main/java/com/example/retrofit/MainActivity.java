package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.retrofit.models.Models;
import com.example.retrofit.models.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /*private RecyclerView rvUserList;
    private ProgressBar progressBar;*/
    LinearLayout linearLayout;
    Button picture, details;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*TextView tvFirstName;



        rvUserList = findViewById(R.id.rvUserList);
        progressBar = findViewById(R.id.progressBar);
        tvFirstName = findViewById(R.id.tvFirstName);


        final UserAdapter adapter = new UserAdapter();
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        rvUserList.setAdapter(adapter);

        RetrofitInterface client = RetrofitClient.getClient().create(RetrofitInterface.class);
        client.fetchUsers(15).enqueue(new Callback<Models>() {
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



        });*/



        picture = findViewById(R.id.picture);
        details = findViewById(R.id.details);
        linearLayout = findViewById(R.id.linearLayout);







        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment firstFragment = new FirstFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, firstFragment);
                transaction.commit();

            }
        });


        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, secondFragment);
                transaction.commit();
            }
        });


    }

}