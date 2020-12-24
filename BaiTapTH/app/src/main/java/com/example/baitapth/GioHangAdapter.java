package com.example.baitapth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GioHangAdapter extends ArrayAdapter<Product> {
    ArrayList<Product> arrayList;
    Context context ;
    int resource;
    public GioHangAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> objects) {
        super(context, resource, objects);
        this.arrayList =objects;
        this.resource= resource;
        this.context= context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource,parent,false);
        TextView soluong = convertView.findViewById(R.id.soluong_giohang);
        TextView name = convertView.findViewById(R.id.name_sp_giohang_355);
        TextView gia =convertView.findViewById(R.id.tongtien_giohang_355);
        RelativeLayout dong_sanpham= convertView.findViewById(R.id.motsanpham);
        Product product = arrayList.get(position);
        dong_sanpham.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Cảnh Báo!!!");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i =0;i<MainActivity.GioHang.size();i++)
                        {
                            if (MainActivity.GioHang.get(i).getID()==product.getID())
                            {
                                MainActivity.GioHang.remove(i);
                            }
                        }
                        notifyDataSetChanged();
                        MainActivity.setThanhGioHang();
                        if (MainActivity.GioHang.size()==0)
                        {
                            MainActivity.dialog.cancel();
                        }

                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

                return true;
            }
        });

        soluong.setText(product.getSoluong()+"");
        name.setText(product.getmName());
        gia.setText(product.getmPrice()+",000đ");
        return convertView;
    }
}
