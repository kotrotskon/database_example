package com.example.database_example;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private SQLiteMyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myHelper = new SQLiteMyHelper(MainActivity.this);
        database = myHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM products", null);

        cursor.moveToFirst();
        int count = cursor.getInt(0);

        Log.d("SQLITE", database.toString()+ " # "+count);
    }
}