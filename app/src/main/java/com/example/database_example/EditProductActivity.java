package com.example.database_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        Product product = new Product(getIntent().getExtras().getInt("product_id"), EditProductActivity.this);

        EditText edTxt_title = findViewById(R.id.edTxt_title);
        EditText edTxt_description = findViewById(R.id.edTxt_description);
        EditText edTxt_price = findViewById(R.id.edTxt_price);

        edTxt_title.setText(product.getTitle());
        edTxt_description.setText(product.getDescription());
        edTxt_price.setText(String.valueOf(product.getPrice()));

        Button btn_update = findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.update(edTxt_title.getText().toString(), edTxt_description.getText().toString(), Double.valueOf(edTxt_price.getText().toString()), EditProductActivity.this);

                EditProductActivity.this.finish();
            }
        });

    }
}