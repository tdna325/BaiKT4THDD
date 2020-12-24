package com.example.baitapth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder>{
    private Context context;
    private ArrayList<ProductCategory> productCategoryList;
   public static ProductAdapter productAdapter;

    public ProductCategoryAdapter(Context context) {
        this.context =context;
    }
    public  void  setData(ArrayList<ProductCategory> list)
    {
        this.productCategoryList = list;
    }
    @NonNull
    @Override
    public ProductCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_category,parent,false);
        return new ProductCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryViewHolder holder, int position) {
        ProductCategory productCategory = productCategoryList.get(position);
        holder.title_product_355.setText(productCategory.getmTitle());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        holder.recyclerView_product_355.setLayoutManager(linearLayoutManager);
        holder.recyclerView_product_355.setFocusable(false);
        holder.recyclerView_product_355.setNestedScrollingEnabled(false);

        productAdapter=new ProductAdapter();
        productAdapter.setData(productCategory.getmList(), new ProductAdapter.IClickAddToCardListener() {
            @Override
            public void onClickAddToCard(ImageView img_add, Product product) {
                AnimationUtil.translateAnimation(MainActivity.getView_animation(), img_add, MainActivity.getView_end_animation(), new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        int dem=0;
                        for (int i =0;i<MainActivity.GioHang.size();i++)
                        {
                            if (MainActivity.GioHang.get(i).getID()==product.getID())
                            {
                                MainActivity.GioHang.get(i).setSoluong(MainActivity.GioHang.get(i).getSoluong()+1);
                                dem++;
                            }
                        }
                        if(dem==0)
                        {
                            product.setSoluong(1);
                            MainActivity.GioHang.add(product);
                        }


                    }


                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MainActivity.setThanhGioHang();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        holder.recyclerView_product_355.setAdapter(productAdapter);
    }

    @Override
    public int getItemCount() {
        return productCategoryList.size();
    }

    public class ProductCategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView title_product_355;
        private RecyclerView recyclerView_product_355;
        public ProductCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            title_product_355 = itemView.findViewById(R.id.title_product_355);
            recyclerView_product_355 = itemView.findViewById(R.id.rcv_product_355);
        }
    }

}
