package com.example.demolaco;

import android.content.Context;
import android.print.PrinterId;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Country> countryList;
    private LayoutInflater layoutInflaterl;
    private Context context;

    public CustomListAdapter(Context context, List<Country> countryList) {
        this.countryList = countryList;
        this.layoutInflaterl = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int i) {
        return countryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolser holder;
        if (view == null) {
            view = LayoutInflater.inflate(R.layout.mylist, null);
            holder = new viewHolser();
            holder.flagView = (ImageView) view.findViewById(R.id.image_flag);
            holder.nameView = (TextView) view.findViewById(R.id.TextView_name);
            holder.populationView = (TextView) view.findViewById(R.id.TextView_population);
            view.setTag(holder);

        } else {
            holder = (viewHolder) view.getTag();
            {

                Country country = this.countryList.get();
                holder.nameView.setText(country.getName());
                holder.populationView.setText("population" + country.getPopulation());
                 int imgID = this.getMipmapResId(country.getFlag());
                holder.flagView.setImageResource(imgID);
                return view;

                return null;
            }
            public int getMipmapResId (String resName){
                String pkName = context.getPackageName();
                int resId = context.getResources().getIdentifier(resName, "mlpmap", pkName);
                Log.i("customListView", "Res Name:" + resName + "=> Res IDv =" + resId);
                return resId;
            }

            static class viewHolder {

            }
        }
    }
}


