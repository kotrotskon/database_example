package com.example.database_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class Product {
    private int id;
    private String title;
    private String description;
    private double price;

    public Product() {
    }

    public Product(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long save(Context context){
        SQLiteMyHelper myHelper = new SQLiteMyHelper(context);
        SQLiteDatabase database = myHelper.getWritableDatabase();

//        String sql = "INSERT INTO products (title, description, price) VALUES ('"+this.title+"', '"+this.description+"', "+this.price+")";

        ContentValues values = new ContentValues();
        values.put(SQLiteMyHelper.COLUMS[1], this.title);
        values.put(SQLiteMyHelper.COLUMS[2], this.description);
        values.put(SQLiteMyHelper.COLUMS[3], this.price);

        return database.insert(SQLiteMyHelper.TABLE_PRODUCTS, null, values);
    }

    public static ArrayList<Product> getAllProducts(Context context){
        ArrayList<Product> products = new ArrayList<>();

        SQLiteMyHelper myHelper = new SQLiteMyHelper(context);
        SQLiteDatabase database = myHelper.getWritableDatabase();

//        String sql = "SELECT * FROM products";
        Cursor cursor = database.query(SQLiteMyHelper.TABLE_PRODUCTS, SQLiteMyHelper.COLUMS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Product product = new Product();
            product.id = cursor.getInt(0);
            product.title = cursor.getString(1);
            product.description = cursor.getString(2);
            product.price = cursor.getDouble(3);

            products.add(product);

            cursor.moveToNext();
        }

        return products;
    }
}
