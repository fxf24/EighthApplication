package com.example.qudqj_000.a2017_04_27;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by qudqj_000 on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<Fruit> data = new ArrayList<>();
    ArrayList<String> cart = new ArrayList<>();
    boolean visible = false;

    public GridAdapter(Context context, ArrayList<Fruit> data){
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if(convertView==null)
//            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
//        final ImageView iv1 = (ImageView)convertView.findViewById(R.id.img1);
//        final TextView tv1 = (TextView)convertView.findViewById(R.id.name);
//
//        tv1.setText(data.get(position).getName());
//        iv1.setImageResource(data.get(position).getImgno());
        if(convertView == null)
            convertView = new GridItem(context);
        ((GridItem)convertView).setData(data.get(position), visible);
        return convertView;
    }

    void addFruit(Fruit fruit){
        data.add(fruit);
        this.notifyDataSetChanged();
    }

    void addToCart(String name){
        cart.add(name);
    }

    void setVisibility(boolean visible){
        this.visible = visible;
        this.notifyDataSetChanged();
    }

    void changeFruit(Fruit fruit, int position){
        data.set(position, fruit);
        this.notifyDataSetChanged();
    }

}
