package com.is2all.as2ila_jawab;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andr on 16/08/2017.
 */

public class databaseClass extends SQLiteOpenHelper {

    public static final String DBNAME = "databaseList.db";
    public static final String DBLOCATION = "/data/data/com.is2all.as2ila_jawab/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public databaseClass (Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }

    public List<item> getListProduct() {
        item product = null;
        List<item> productList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM tablo", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            product = new item(cursor.getInt(0),
                               cursor.getString(1),
                               cursor.getString(2),
                               cursor.getString(3),
                               cursor.getString(4),
                               cursor.getString(5),
                               cursor.getInt(6));
            productList.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return productList;
    }

}
