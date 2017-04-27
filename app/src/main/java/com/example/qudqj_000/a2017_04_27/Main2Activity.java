package com.example.qudqj_000.a2017_04_27;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.qudqj_000.a2017_04_27.Fruit.imglist;
import static com.example.qudqj_000.a2017_04_27.Fruit.pricelist;

public class Main2Activity extends AppCompatActivity {
    ArrayList<Fruit> fruit = new ArrayList<>();

    GridAdapter adapter;
    GridView gridView;
    AddFruit addFruit;
    CheckBox c1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        program();
    }
    void program(){
        c1 = (CheckBox)findViewById(R.id.checkbox1);
        b1 = (Button)findViewById(R.id.watchCart);
        gridView = (GridView)findViewById(R.id.grid);
        fruit.add(new Fruit("아보카도", imglist[0], pricelist[0]));
        fruit.add(new Fruit("바나나", imglist[1], pricelist[1]));
        fruit.add(new Fruit("체리", imglist[2], pricelist[2]));
        fruit.add(new Fruit("크랜베리", imglist[3], pricelist[3]));
        fruit.add(new Fruit("포도", imglist[4], pricelist[4]));

        adapter = new GridAdapter(this, fruit);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        addFruit = (AddFruit)findViewById(R.id.addfruit);
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int imgno, int price) {
                Toast.makeText(getApplicationContext(), name+ "추가", Toast.LENGTH_SHORT).show();
                adapter.addFruit(new Fruit(name,imgno, price));
                adapter.notifyDataSetChanged();
            }
        });

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }
            }
        });
    }
}
