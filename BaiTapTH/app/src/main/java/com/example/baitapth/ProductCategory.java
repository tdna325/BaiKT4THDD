package com.example.baitapth;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    private String mTitle;
    private ArrayList<Product> mList;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public ArrayList<Product> getmList() {
        return mList;
    }

    public void setmList(ArrayList<Product> mList) {
        this.mList = mList;
    }

    public ProductCategory(String mTitle, ArrayList<Product> mList) {
        this.mTitle = mTitle;
        this.mList = mList;
    }
}
