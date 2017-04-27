package com.example.qudqj_000.a2017_04_27;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by qudqj_000 on 2017-04-27.
 */

public class GridItem extends LinearLayout {
    ImageView iv1;
    TextView tv1, tv2;
    public GridItem(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.item, this);
        iv1 = (ImageView)findViewById(R.id.img1);
        tv1 = (TextView)findViewById(R.id.name);
        tv2 = (TextView)findViewById(R.id.price);
    }

    public void setData(Fruit one){
        tv1.setText(one.getName());
        tv2.setText(one.getPrice());
        iv1.setImageResource(one.getImgno());
    }
}
