package com.example.baitapth;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    ArrayList<Product> arrayList;
    private IClickAddToCardListener iClickAddToCardListener;
    public interface IClickAddToCardListener {
        void onClickAddToCard(ImageView img_add, Product product);
    }
    public void setData(ArrayList<Product> arrayList,IClickAddToCardListener iClickAddToCardListener) {
        this.arrayList = arrayList;
        this.iClickAddToCardListener = iClickAddToCardListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = arrayList.get(position);
        holder.imageView.setImageBitmap(BitmapFactory.decodeByteArray(product.getmImage(),0,product.getmImage().length));
        holder.mName.setText(product.getmName());
        holder.mGia.setText(product.getmPrice()+",000đ");
        holder.add_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!product.isAddToCard()){
                    iClickAddToCardListener.onClickAddToCard(holder.add_pr,product);
                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView mName;
        private TextView mGia;
        private ImageView add_pr;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_sp);
            mName = itemView.findViewById(R.id.name_sp);
            mGia = itemView.findViewById(R.id.gia_sp);
            add_pr = itemView.findViewById(R.id.ig_themsp);


        }
    }
}
