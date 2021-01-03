package com.example.appsanpham;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {
    private List<SanPham> listView;
    private LayoutInflater layoutInflater;
    private Context context;

    public SanPhamAdapter(List<SanPham> listView, Context context) {
        this.listView = listView;
        this.context = context;
        layoutInflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listView.size();
    }

    @Override
    public Object getItem(int i) {

        return listView.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder holder;

            convertView = layoutInflater.inflate(R.layout.frag_sanpham, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imgHinh);
            holder.ten = (TextView) convertView.findViewById(R.id.txt_Tensp);
            holder.gia = (TextView) convertView.findViewById(R.id.txt_Gia);
            convertView.setTag(holder);

            holder = (ViewHolder) convertView.getTag();


        SanPham SP = listView.get(i);
        holder.ten.setText(SP.getTenSP());
        holder.gia.setText("Gia: " + SP.getGia());

        int imageId = this.getMipmapResIdByName(SP.getTenSP());

        holder.imageView.setImageResource(imageId);

        return null;
    }

    public int getMipmapResIdByName(String Name){
        String name = context.getPackageName();
        int resID = context.getResources().getIdentifier(Name , "mipmap", name);
        Log.i("CustomListView", "Name: "+ Name+"==> Res ID = "+ resID);
        return resID;
    }


    static  class ViewHolder{
        ImageView imageView;
        TextView ten;
        TextView gia;
    }
}
