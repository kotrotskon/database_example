package com.example.database_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

        EditText edTxt_title = findViewById(R.id.edTxt_title);
        EditText edTxt_description = findViewById(R.id.edTxt_description);
        EditText edTxt_price = findViewById(R.id.edTxt_price);
        Button btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product(
                        edTxt_title.getText().toString(),
                        edTxt_description.getText().toString(),
                        Double.valueOf(edTxt_price.getText().toString())
                );
                long id = product.save(CreateProductActivity.this);

                Toast.makeText(CreateProductActivity.this, "Product save successfully!", Toast.LENGTH_LONG).show();

                CreateProductActivity.this.finish();
            }
        });



    }
}