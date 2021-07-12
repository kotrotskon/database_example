package com.example.database_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteMyHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "products_db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_PRODUCTS = "products";

    public static final String[] COLUMS = {"id", "title", "description", "price"};

    public SQLiteMyHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_PRODUCTS+" (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, description TEXT NOT NULL, price REAL DEFAULT 0)");

        ContentValues values = new ContentValues();
        values.put(COLUMS[1], "Dell Vostro 3500 Laptop (Core i3 1115G4/4 GB/256 GB/UHD Graphics)");
        values.put(COLUMS[2], "Φορητός υπολογιστής 15,6 ιντσών με στενό περιθώριο στις δύο πλευρές, μπαταρία ExpressCharge™ και επεξεργαστές Intel® Core™ 11ης γενιάς.");
        values.put(COLUMS[3], 549.00);
        sqLiteDatabase.insert(SQLiteMyHelper.TABLE_PRODUCTS, null, values);

        values = new ContentValues();
        values.put(COLUMS[1], "Dell Vostro 3500 + Zone Alarm For Institutions Laptop (Core i3 1115G4/4 GB/256 GB");
        values.put(COLUMS[2], "Φορητός υπολογιστής με FHD οθόνη 15,6” και στενό περιθώριο στις δύο πλευρές, 11ης γενιάς επεξεργαστή Intel® Core™ i3-1115G4 και μπαταρία τεχνολογίας ExpressCharge™ για γρήγορη φόρτιση!");
        values.put(COLUMS[3], 559.00);
        sqLiteDatabase.insert(SQLiteMyHelper.TABLE_PRODUCTS, null, values);

        values = new ContentValues();
        values.put(COLUMS[1], "HP 15s - eq0020nv Laptop (Ryzen 5 3450U/8 GB/256 GB/Radeon Vega 8)");
        values.put(COLUMS[2], "Iδανικό για εργασία και διασκέδαση, με επεξεργαστή AMD Ryzen™ 5 3450U, 8GB DDR4 RAM, οθόνη 15,6” FHD IPS, NVMe M.2 SSD 256GB, Windows 10 (S) και βάρος μόλις 1,74 κιλά για να το έχεις πάντα μαζί σου!");
        values.put(COLUMS[3], 569.00);
        sqLiteDatabase.insert(SQLiteMyHelper.TABLE_PRODUCTS, null, values);

        values = new ContentValues();
        values.put(COLUMS[1], "HP 15 - dw2000nv Laptop (Core i5 1035G1/8 GB/256 GB/GeForce MX130 2 GB)");
        values.put(COLUMS[2], "Ολοκλήρωσε με σιγουριά τις εργασίες σου με 10ης γενιάς επεξεργαστή Intel® Core™ i5-1035G1, 8GB RAM DDR4, PCIe NVMe M.2 SSD 256GB, NVIDIA® GeForce® MX130 και Windows 10 σε S mode!");
        values.put(COLUMS[3], 649.00);
        sqLiteDatabase.insert(SQLiteMyHelper.TABLE_PRODUCTS, null, values);

        values = new ContentValues();
        values.put(COLUMS[1], "Apple MacBook Air Retina MGN63GR/A (Late 2020) S.G. (M1/8 GB/256 GB)");
        values.put(COLUMS[2], "Σχεδιασμένος αποκλειστικά για τον Mac, ο πανίσχυρος 8πύρηνος επεξεργαστής M1 προσφέρει εντυπωσιακές επιδόσεις και γραφικά, χαμηλότερη κατανάλωση και πρόσβαση σε ένα τεράστιο οικοσύστημα εφαρμογών!");
        values.put(COLUMS[3], 1179.00);
        sqLiteDatabase.insert(SQLiteMyHelper.TABLE_PRODUCTS, null, values);

        values = new ContentValues();
        values.put(COLUMS[1], "HP ProBook 650 G8 Laptop (Core i5 1135G7/8 GB/256 GB/Iris Xe Graphics)");
        values.put(COLUMS[2], "Επαγγελματικό και ανθεκτικό φορητό σύστημα 15” με επεξεργαστή Intel® Core™ i5 11th Gen 1135G7, 8GB RAM DDR4-3200, αποθ. μονάδα NVMe M.2 SSD 256GB και Windows 10 Pro.");
        values.put(COLUMS[3], 849.00);
        sqLiteDatabase.insert(SQLiteMyHelper.TABLE_PRODUCTS, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
