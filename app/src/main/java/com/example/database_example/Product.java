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

    public Product(int id, Context context){
        SQLiteMyHelper myHelper = new SQLiteMyHelper(context);
        SQLiteDatabase database = myHelper.getWritableDatabase();

        String[] args = {String.valueOf(id)};

//        String sql = "SELECT * FROM products WHERE id = ?";
        Cursor cursor = database.query(SQLiteMyHelper.TABLE_PRODUCTS, SQLiteMyHelper.COLUMS, "id = ?", args, null, null, null);

        cursor.moveToFirst();

        this.id = cursor.getInt(0);
        this.title = cursor.getString(1);
        this.description = cursor.getString(2);
        this.price = cursor.getDouble(3);

        database.close();

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

        database.close();

        return database.insert(SQLiteMyHelper.TABLE_PRODUCTS, null, values);
    }

    public void update(String title, String description, double price, Context context){
        SQLiteMyHelper myHelper = new SQLiteMyHelper(context);
        SQLiteDatabase database = myHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SQLiteMyHelper.COLUMS[1], title);
        values.put(SQLiteMyHelper.COLUMS[2], description);
        values.put(SQLiteMyHelper.COLUMS[3], price);

        String[] args = {String.valueOf(this.id)};

//        "UPDATE products SET title = '', description='', price=0 WHERE id = ?
        database.update(SQLiteMyHelper.TABLE_PRODUCTS, values, "id = ?", args);

        database.close();
    }

    public void delete(Context context){
        SQLiteMyHelper myHelper = new SQLiteMyHelper(context);
        SQLiteDatabase database = myHelper.getWritableDatabase();

        String[] args = {String.valueOf(this.id)};

        database.delete(SQLiteMyHelper.TABLE_PRODUCTS, "id = ?", args);

        database.close();
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

        database.close();

        return products;
    }
}
