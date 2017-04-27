package com.example.qudqj_000.a2017_04_27;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by qudqj_000 on 2017-04-27.
 */

public class SpinnerAdapter extends BaseAdapter{
    Context context;
    ArrayList<String> data = new ArrayList<>();

    public SpinnerAdapter(Context context, ArrayList<String> data){
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner, null);

        final TextView tv = (TextView)convertView.findViewById(R.id.name);
        final CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkbox1);
        tv.setText(data.get(position));
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(context, data.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;
    }
}
