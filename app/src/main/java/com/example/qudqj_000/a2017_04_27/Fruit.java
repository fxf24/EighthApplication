package com.example.qudqj_000.a2017_04_27;

import java.util.ArrayList;

/**
 * Created by qudqj_000 on 2017-04-27.
 */

public class Fruit {
    private String name;
    private int imgno;
    private int price;
    private int index;

    final static int imglist[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry, R.drawable.cranberry
            , R.drawable.grape, R.drawable.orange, R.drawable.watermelon, R.drawable.kiwi};
    final static int pricelist[] = {10000, 5000, 1000, 4000, 3000, 2000, 8000, 9000};


    public Fruit(String name, int imgno, int price, int index){
        this.name = name;
        this.imgno = imgno;
        this.price = price;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgno() {
        return imgno;
    }

    public void setImgno(int imgno) {
        this.imgno = imgno;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIndex(){return index;}
}
