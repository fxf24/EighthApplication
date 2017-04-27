package com.example.qudqj_000.a2017_04_27;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by qudqj_000 on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener{
    int imgno = 0;
    AutoCompleteTextView actv1;
    Button b_next, b_add;
    ImageView img;

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
    }

    @Override
    public void onClick(View v) {
        if(v==b_add){
            onAddListener.onAdd(actv1.getText().toString(), Fruit.imglist[imgno], Fruit.pricelist[imgno]);
        }
        else if(v == b_next){
            if(imgno == Fruit.imglist.length -1) imgno = -1;
            img.setImageResource(Fruit.imglist[++imgno]);
        }
    }

    interface OnAddListener {
        void onAdd(String name, int imgno, int price);
    }
    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }
}
