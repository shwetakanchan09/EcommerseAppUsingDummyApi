package com.shweta.ecommerseappusingdummyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtAllProduct,singleProduct,category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAllProduct = findViewById(R.id.txtAllProduct);
        singleProduct = findViewById(R.id.txtSingleProduct);

        txtAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AllProductActivity.class);
                startActivity(i);
            }
        });
        singleProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SingleProductActivity.class);
                startActivity(i);
            }
        });
    }
}