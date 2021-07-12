package com.example.database_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {

    TextView txtVw_title;
    TextView txtVw_description;
    TextView txtVw_price;

    int id;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        id = getIntent().getExtras().getInt("product_id");

        txtVw_title = findViewById(R.id.txtVw_title);
        txtVw_description = findViewById(R.id.txtVw_description);
        txtVw_price = findViewById(R.id.txtVw_price);

        Button btn_edit = findViewById(R.id.btn_edit);
        Button btn_delete = findViewById(R.id.btn_delete);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this, EditProductActivity.class);
                intent.putExtra("product_id", product.getId());
                startActivity(intent);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.delete(ProductActivity.this);

                ProductActivity.this.finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        product = new Product(id, ProductActivity.this);

        txtVw_title.setText(product.getTitle());
        txtVw_description.setText(product.getDescription());
        txtVw_price.setText(String.valueOf(product.getPrice()));
    }
}