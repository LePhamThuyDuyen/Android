package com.example.btl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "db.sqlite", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table Accounts("+"SDT text primary key,"+" MK text,"+" DiaChi text)");
        sqLiteDatabase.execSQL("Create table Products("+"id int primary key,"
                                                        +" Ten text,"+" gia int,"+" sl int,"+" anh int,"+"mota text,"+" ghichu text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Accounts");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Products");
        onCreate(sqLiteDatabase);
    }

    public int InsertPro(Product pro,int id){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("Ten",pro.getName());
        contentValues.put("gia",pro.getGia());
        contentValues.put("sl",pro.getSol());
        contentValues.put("anh",pro.getAnh());
        contentValues.put("mota",pro.getMoTa());
        contentValues.put("ghichu",pro.getGhiChu());
        return (int)db.insert("Products",null,contentValues);
    }
    public ArrayList<Product> GetALLPro(){
        SQLiteDatabase db = this.getReadableDatabase();
       // String tmp = "'"+SDT+"'";
        Cursor cursor = db.rawQuery("select * from Products" ,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        if(cursor.getCount()==0) {
            cursor.close();
            db.close();
            return null;
        }
        ArrayList<Product> lst = new ArrayList<>();
        while (cursor.isAfterLast()==false){
            lst.add(new Product(cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6),cursor.getInt(0)));
                cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return lst;
    }
    ///////////////////
    public Product getProDetail(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Products where id = " + id,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        if(cursor.getCount()==0) {
            cursor.close();
            db.close();
            return null;
        }
        Product product = new Product(cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6));
        cursor.close();
        db.close();
        return product;
    }
    public ArrayList<Product> getProByText(String text){
        String tmp = "'%"+text+"%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Products where Ten like " + tmp,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        if(cursor.getCount()==0) {
            cursor.close();
            db.close();
            return null;
        }
        ArrayList<Product> lst = new ArrayList<>();
        while (cursor.isAfterLast()==false){
            lst.add(new Product(cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return lst;
    }
    public ArrayList<Product> getProOther(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Products where Ten not like '%lamington%' " +
                "or Ten not like '%cheesecake%' " +
                "or Ten not like '%Tiramisu%'",null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        if(cursor.getCount()==0) {
            cursor.close();
            db.close();
            return null;
        }
        ArrayList<Product> lst = new ArrayList<>();
        while (cursor.isAfterLast()==false){
            lst.add(new Product(cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return lst;
    }

    public int InsertAcc(Account account){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SDT",account.getSDT());
        contentValues.put("MK",account.getMK());
        contentValues.put("DiaChi",account.getDiaChi());
        return (int)db.insert("Accounts",null,contentValues);
    }
    public Account GetAcc(String SDT){
        SQLiteDatabase db = this.getReadableDatabase();
        String tmp = "'"+SDT+"'";
        Cursor cursor = db.rawQuery("select * from Accounts where SDT = " + tmp,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        if(cursor.getCount()==0) {
            cursor.close();
            db.close();
            return null;
        }
        Account account = new Account(cursor.getString(0),cursor.getString(1),cursor.getString(2));
        cursor.close();
        db.close();
        return account;
    }
    public int UpDateAcc(Account account){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SDT",account.getSDT());
        contentValues.put("MK",account.getMK());
        contentValues.put("DiaChi",account.getDiaChi());
        return db.update("Accounts",contentValues,"SDT = ?",new String[]{account.getSDT()});
    }
}
