package com.example.database_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rclrVw_products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_newProduct = findViewById(R.id.btn_newProduct);
        rclrVw_products = findViewById(R.id.rclrVw_products);

        btn_newProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateProductActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Product> products = Product.getAllProducts(MainActivity.this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rclrVw_products.setLayoutManager(layoutManager);

        ProductAdapter productAdapter = new ProductAdapter(MainActivity.this, products);
        rclrVw_products.setAdapter(productAdapter);
    }
}