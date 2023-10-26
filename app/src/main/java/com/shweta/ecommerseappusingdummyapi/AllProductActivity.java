package com.shweta.ecommerseappusingdummyapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AllProductActivity extends AppCompatActivity {

    AllProductAdapter adapter;
    RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);

        recyclerView = findViewById(R.id.rv_products);
        progressDoalog = new ProgressDialog(AllProductActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        Call<ArrayList<AllProductModel>> call = ApiClient.getEcommerceApp().getAllCategories();
        call.enqueue(new Callback<ArrayList<AllProductModel>>() {
            @Override
            public void onResponse(Call<ArrayList<AllProductModel>> call, Response<ArrayList<AllProductModel>> response) {
                progressDoalog.dismiss();
                if (response.code()==200 && response.body()!=null){
                   // Toast.makeText(AllProductActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    adapter = new AllProductAdapter(AllProductActivity.this,response.body());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AllProductModel>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(AllProductActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}