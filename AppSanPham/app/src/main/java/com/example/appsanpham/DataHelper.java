package com.example.appsanpham;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataHelper extends SQLiteOpenHelper {
    public DataHelper(@Nullable Context context){super(context, "db.sqlite", null, 1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SanPham("+"maS text primary key,"+"tenSp text,"+"moTa text,"+"anh  Interger, "+"gia  Interger, "+"soL  Interger)");
        db.execSQL("CREATE TABLE Acount("+"mk text primary key,"+"hoTen text,"+"sdt text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS SanPham");
        db.execSQL("DROP TABLE IF EXISTS Acount");
        onCreate(db);
    }

    public ArrayList<SanPham> getAllSP(){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from SanPham", null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        if(cursor.getCount()==0) {
            cursor.close();
            DB.close();
            return null;
        }
        ArrayList<SanPham>arrayList= new ArrayList<>();
        while (cursor.isAfterLast()==false) {
            arrayList.add(new SanPham(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
            cursor.moveToNext();
        }
        cursor.close();
        DB.close();
        return arrayList;
    }
    public int InsertSP(SanPham pro,int ma){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maS",ma);
        contentValues.put("tenSp",pro.getTenSP());
        contentValues.put("gia",pro.getGia());
        contentValues.put("soL",pro.getSoLuong());
        contentValues.put("anh",pro.getAnh());
        contentValues.put("moTa",pro.getMoTa());
        return (int)db.insert("SanPham",null,contentValues);
    }

    public  Acount GetAcc(String mk){
        return null;
    }
}
