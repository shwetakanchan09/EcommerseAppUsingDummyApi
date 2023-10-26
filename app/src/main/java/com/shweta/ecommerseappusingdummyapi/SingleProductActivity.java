package com.shweta.ecommerseappusingdummyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SingleProductActivity extends AppCompatActivity {

    TextView title, desc, price, discount_percentage, rating, stock, brand, category, txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);
        title = findViewById(R.id.txtTitle);
        desc = findViewById(R.id.txtDesc);
        price = findViewById(R.id.txtPrice);
        discount_percentage = findViewById(R.id.txtDiscount);
        rating = findViewById(R.id.txtRating);
        stock = findViewById(R.id.txtStock);
        brand = findViewById(R.id.txtBrand);
        category = findViewById(R.id.txtCat);
        txt = findViewById(R.id.txt);

        Call<SingleProduct> call = ApiClient.getEcommerceApp().getSingleProduct();
        call.enqueue(new Callback<SingleProduct>() {
            @Override
            public void onResponse(Call<SingleProduct> call, Response<SingleProduct> response) {

                if (response.code() == 200 && response.body() != null) {
                   // txt.setText("Check the Connection");
                    Toast.makeText(SingleProductActivity.this, "Success", Toast.LENGTH_SHORT).show();


                }
                title.setText(response.body().getTitle());
                desc.setText(response.body().getDescription());
                price.setText(response.body().getPrice());
               // discount_percentage.setText((int) response.body().getDiscountPercentage());
                //rating.setText((int) response.body().getRating());
                stock.setText(response.body().getStock());
                brand.setText(response.body().getBrand());
                category.setText(response.body().getCategory());

                }


            @Override
            public void onFailure(Call<SingleProduct> call, Throwable t) {
                Toast.makeText(SingleProductActivity.this, "onFailure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}