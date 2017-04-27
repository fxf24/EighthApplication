package com.example.qudqj_000.a2017_04_27;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

//
//R.drawable.abocado, R.drawable.banana, R.drawable.cherry, R.drawable.cranberry
//        , R.drawable.grape, R.drawable.orange, R.drawable.watermelon, R.drawable.kiwi};
/**
 * Created by qudqj_000 on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener{
    int imgno = 0;
    AutoCompleteTextView actv1;
    Button b_next, b_add;
    ImageView img;
    int position =0;
    static final String[] list = {"abocado", "banana","cherry","cranberry","grape","orange","watermelon","kiwi"};
    ArrayAdapter<String> autoSearch;
    public AddFruit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.fruit_add, this);
        b_add = (Button)findViewById(R.id.b_add);
        b_next = (Button)findViewById(R.id.b_next);
        actv1 = (AutoCompleteTextView)findViewById(R.id.f_name);
        img = (ImageView)findViewById(R.id.image1);

        b_add.setOnClickListener(this);
        b_next.setOnClickListener(this);

        autoSearch = new ArrayAdapter<String>(context,android.R.layout.simple_dropdown_item_1line,list);
        actv1.setAdapter(autoSearch);
    }


    public void editData(String s, int position){
        actv1.setText(s);
        b_add.setText("M");
        this.position = position;
    }
    @Override
    public void onClick(View v) {
        if(v==b_add){
            if(b_add.getText().toString().equals("ADD")) {
                onAddListener.onAdd(actv1.getText().toString(), Fruit.imglist[imgno], Fruit.pricelist[imgno]);
            }
            else{
                onAddListener.onEdit(actv1.getText().toString(), Fruit.imglist[imgno], Fruit.pricelist[imgno], position);
                b_add.setText("ADD");
            }
        }
        else if(v == b_next){
            if(imgno == Fruit.imglist.length -1) imgno = -1;
            img.setImageResource(Fruit.imglist[++imgno]);
        }
    }

    interface OnAddListener {
        void onAdd(String name, int imgno, int price);
        void onEdit(String name, int imgno, int price, int position);
    }
    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }
}
