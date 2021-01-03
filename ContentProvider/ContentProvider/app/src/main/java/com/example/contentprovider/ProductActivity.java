package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    static final String uri="content://com.example.contentprovider";
    EditText et_id,et_name,et_unit,et_madein;
    Button bt_exit,bt_select,bt_delete,bt_save,bt_update;
    GridView gr_list;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        et_id=findViewById(R.id.id);
        et_name=findViewById(R.id.name);
        et_unit=findViewById(R.id.unit);
        et_madein=findViewById(R.id.madein);

        bt_exit=findViewById(R.id.exit);
        bt_select=findViewById(R.id.select);
        bt_delete=findViewById(R.id.delete);
        bt_save=findViewById(R.id.save);
        bt_update=findViewById(R.id.update);

        gr_list=findViewById(R.id.grid);
        dbHelper=new DatabaseHelper(this);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values=new ContentValues();
                values.put("id",et_id.getText().toString());
                values.put("name",et_name.getText().toString());
                values.put("unit",et_unit.getText().toString());
                values.put("madein",et_madein.getText().toString());
                Uri product=Uri.parse(uri);
                Uri insert_uri=getContentResolver().insert(product,values);
                Toast.makeText(getApplicationContext(),"Luu thanh cong",Toast.LENGTH_LONG).show();
            }
        });

        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list=new ArrayList<>();
                Uri product=Uri.parse(uri);
                Cursor cursor =getContentResolver().query(product,null,null,null,"name");
                if(cursor!=null){
                    cursor.moveToFirst();
                    do{
                        list.add(cursor.getInt(0)+"");
                        list.add(cursor.getString(1));
                        list.add(cursor.getString(2));
                        list.add(cursor.getString(3));
                    }while(cursor.moveToNext());
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(ProductActivity.this,android.R.layout.simple_list_item_1,list);
                    gr_list.setAdapter(adapter);
                }
                else
                    Toast.makeText(getApplicationContext(),"Khong co ket qua",Toast.LENGTH_LONG).show();
            }
        });

    }
}