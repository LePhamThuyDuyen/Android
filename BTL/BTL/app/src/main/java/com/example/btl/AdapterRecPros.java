package com.example.btl;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecPros extends RecyclerView.Adapter<WordViewHolder>{

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Product> arrayList;

    public AdapterRecPros(Context context, ArrayList<Product> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItem = layoutInflater.inflate(R.layout.layout_products,parent,false);
        return new WordViewHolder(mItem,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Product product = arrayList.get(position);
        if(product.getSol()>0)
            holder.tvNote.setText("Hiện có: "+product.getSol());
        else
            holder.tvNote.setText("Tạm hết hàng");
        holder.tvGia.setText(String.valueOf(product.getGia()));
        holder.tvName.setText(product.getName());
        holder.img.setImageResource(product.getAnh());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,FragDetail.newInstance(String.valueOf(product.getId()))).commit();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", String.valueOf(product.getId()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
class WordViewHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView tvName,tvGia,tvNote;
    AdapterRecPros adapterRecPros;
    ConstraintLayout item;
    public WordViewHolder(@NonNull View itemView,AdapterRecPros adap) {
        super(itemView);
        img = itemView.findViewById(R.id.imageView_Ps);
        tvName = itemView.findViewById(R.id.textViewName_Ps);
        tvGia = itemView.findViewById(R.id.textViewGia_Ps);
        tvNote = itemView.findViewById(R.id.textViewNote_Ps);
        item = itemView.findViewById(R.id.layoutItem);
        adapterRecPros = adap;z
    }
}
