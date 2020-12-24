package com.example.baitapth;

public class Product {
    private int ID;
    private byte[] mImage;
    private String mName;
    private int mPrice;
    private boolean isAddToCard;
    private int soluong=0;
    private int thanhTien;

    public int getThanhTien() {
        return soluong*mPrice;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public boolean isAddToCard() {
        return isAddToCard;
    }

    public void setAddToCard(boolean addToCard) {
        isAddToCard = addToCard;
    }

    public Product(int ID, byte[] mImage, String mName, int mPrice) {
        this.ID = ID;
        this.mImage = mImage;
        this.mName = mName;
        this.mPrice = mPrice;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public byte[] getmImage() {
        return mImage;
    }

    public void setmImage(byte[] mImage) {
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }
}
