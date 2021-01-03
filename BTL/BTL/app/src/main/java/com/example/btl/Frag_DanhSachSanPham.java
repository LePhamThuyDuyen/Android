package com.example.btl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Frag_DanhSachSanPham extends Fragment {
    Button btnSearch,btnAll,btnTira,btnChee,btnLam,btnOther;
    EditText etSearch;
    RecyclerView recyclerView;
    DatabaseHelper db;
    ArrayList<Product> arrayListPros;
    AdapterRecPros adapterCus;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frag = inflater.inflate(R.layout.fragment_ds_sp,container,false);
        etSearch = frag.findViewById(R.id.editTextSearch_LPs);
        btnSearch = frag.findViewById(R.id.buttonSearch_LPs);
        recyclerView = frag.findViewById(R.id.recy_LPs);

        btnAll = frag.findViewById(R.id.btnAll_LPs);
        btnChee = frag.findViewById(R.id.btnCheese_LPs);
        btnLam = frag.findViewById(R.id.btnLami_LPs);
        btnTira = frag.findViewById(R.id.btnTira_LPs);
        btnOther = frag.findViewById(R.id.btnother_LPs);

        btnTira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListPros = new ArrayList<>();
                arrayListPros = db.getProByText("Tiramisu");
                adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                //recyclerView.setLayoutManager(new );
                recyclerView.setAdapter(adapterCus);
            }
        });
        btnLam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListPros = new ArrayList<>();
                arrayListPros = db.getProByText("lamington");
                if(arrayListPros.size()<1){
                    Toast.makeText(getContext(),"Không tìm thấy bánh nào",Toast.LENGTH_LONG).show();
                    arrayListPros = new ArrayList<>();
                    arrayListPros = db.GetALLPro();
                    adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                    //recyclerView.setLayoutManager(new );
                    recyclerView.setAdapter(adapterCus);
                    return;
                }
                adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                //recyclerView.setLayoutManager(new );
                recyclerView.setAdapter(adapterCus);
            }
        });

        btnChee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListPros = new ArrayList<>();
                arrayListPros = db.getProByText("cheesecake");
                if(arrayListPros.size()<1){
                    Toast.makeText(getContext(),"Không tìm thấy bánh nào",Toast.LENGTH_LONG).show();
                    arrayListPros = new ArrayList<>();
                    arrayListPros = db.GetALLPro();
                    adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                    //recyclerView.setLayoutManager(new );
                    recyclerView.setAdapter(adapterCus);
                    return;
                }
                adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                //recyclerView.setLayoutManager(new );
                recyclerView.setAdapter(adapterCus);
            }
        });

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListPros = new ArrayList<>();
                arrayListPros = db.GetALLPro();
                adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                //recyclerView.setLayoutManager(new );
                recyclerView.setAdapter(adapterCus);
            }
        });

        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListPros = new ArrayList<>();
                arrayListPros = db.getProOther();
                if(arrayListPros.size()<1){
                    Toast.makeText(getContext(),"Không tìm thấy bánh nào",Toast.LENGTH_LONG).show();
                    arrayListPros = new ArrayList<>();
                    arrayListPros = db.GetALLPro();
                    adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                    //recyclerView.setLayoutManager(new );
                    recyclerView.setAdapter(adapterCus);
                    return;
                }
                adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                //recyclerView.setLayoutManager(new );
                recyclerView.setAdapter(adapterCus);
            }
        });
        db = new DatabaseHelper(getContext());
        arrayListPros = new ArrayList<>();
        arrayListPros = db.GetALLPro();
        adapterCus = new AdapterRecPros(getContext(),arrayListPros);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
        //recyclerView.setLayoutManager(new );
        recyclerView.setAdapter(adapterCus);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListPros = new ArrayList<>();
                arrayListPros = db.getProByText(etSearch.getText().toString());
                if(arrayListPros.size()<1){
                    Toast.makeText(getContext(),"Không tìm thấy bánh nào",Toast.LENGTH_LONG).show();
                    arrayListPros = new ArrayList<>();
                    arrayListPros = db.GetALLPro();
                    adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                    //recyclerView.setLayoutManager(new );
                    recyclerView.setAdapter(adapterCus);
                    return;
                }
                adapterCus = new AdapterRecPros(getContext(),arrayListPros);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,GridLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapterCus);
            }
        });

        return frag;
    }


}
