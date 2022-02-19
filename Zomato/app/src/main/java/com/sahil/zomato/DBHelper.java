package com.sahil.zomato;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.sahil.zomato.Modals.OrderModal;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context , DBNAME , null , DBVERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders(" +
                        "id integer primary key autoincrement," +
                        "Name text," +
                        "Phone text," +
                        "Price int," +
                        "Image int," +
                        "Description text," +
                        "FoodName text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase , int i , int i1) {
        //When Our Database Upgrade He Change The Row Of Table Add New Data
        sqLiteDatabase.execSQL("DROP table if exists orders");
        //For Creating New Row
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String Name , String Phone , int Price , int Image , String Description , String FoodName) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name" , Name);
        values.put("Phone" , Phone);
        values.put("Price" , Price);
        values.put("Image" , Image);
        values.put("Description" , Description);
        values.put("FoodName" , FoodName);
        long id = database.insert("orders" , null , values);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<OrderModal> getOrder() {
        ArrayList<OrderModal> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select id,FoodName,Image,Price from orders" , null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OrderModal modal = new OrderModal();
                modal.setOrderNumber(cursor.getInt(0) + "");
                modal.setOrderName(cursor.getString(1));
                modal.setOrderImage(cursor.getInt(2));
                modal.setOrderPrice(cursor.getInt(3) + "");
                orders.add(modal);

            }
        }
        cursor.close();
        database.close();
        return orders;
    }

    public Cursor getOrderById(int id) {
        ArrayList<OrderModal> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from orders where id=" + id , null);
        if (cursor != null)
            cursor.moveToFirst();


        return cursor;

    }

    public boolean updateOrder(String Name , String Phone , int Price , int Image , String Description , String FoodName , int id) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name" , Name);
        values.put("Phone" , Phone);
        values.put("Price" , Price);
        values.put("Image" , Image);
        values.put("Description" , Description);
        values.put("FoodName" , FoodName);
        long row = database.update("orders" , values , "id=" + id , null);
        if (row <= 0) {
            return false;
        } else {
            return true;
        }

    }
    public int Delete(String id){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        return sqLiteDatabase.delete("orders","id="+id,null);
    }
}
