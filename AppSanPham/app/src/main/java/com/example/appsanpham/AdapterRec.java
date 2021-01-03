package com.example.appsanpham;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRec extends RecyclerView.Adapter<WordViewHolder> {
    private ArrayList<SanPham> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterRec(ArrayList<SanPham> listView, Context context) {
        this.list = listView;
        this.context = context;
        layoutInflater= LayoutInflater.from(context);
}

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItem = layoutInflater.inflate(R.layout.frag_sanpham,parent,false);
        return new WordViewHolder(mItem,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        SanPham sp = list.get(position);
        holder.gia.setText(String.valueOf(sp.getGia()));
        holder.ten.setText(sp.getTenSP());
        holder.imageView.setImageResource(sp.getAnh());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class WordViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView ten;
    TextView gia;
    AdapterRec ar;
    public WordViewHolder(@NonNull View itemView,AdapterRec adap) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imgHinh);
        ten= itemView.findViewById(R.id.txt_Tensp);
        gia = itemView.findViewById(R.id.txt_Gia);
        ar = adap;
    }
}
