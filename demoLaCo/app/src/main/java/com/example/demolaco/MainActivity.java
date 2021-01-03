package com.example.demolaco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Country> myList = new ArrayList<>();
        Country hinh1 = new Country("VietNam","vn",113);
        Country hinh2 = new Country("VietNam","vn",113);
        Country hinh3 = new Country("VietNam","vn",113);
        Country hinh4 = new Country("VietNam","vn",113);
        Country hinh5 = new Country("VietNam","vn",113);
        Country hinh6 = new Country("VietNam","vn",113);

        myList.add(hinh1);
        myList.add(hinh2);
        myList.add(hinh3);
        myList.add(hinh4)
        myList.add(hinh5);
        myList.add(hinh6);

        final ListView listView  =(ListView) findViewById(R.id.);
        listView.setAdapter(new CustomListAdapter(this,myList));



    }
}