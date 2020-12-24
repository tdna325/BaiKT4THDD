package com.example.baitapth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    Button drop_menu;
    public static View view_end_animation;
    public static ImageView view_animation;
    ProductCategoryAdapter productCategoryAdapter;
    Menu mMenu;
    boolean isExpanded =true;
    SQLiteDatabase database;
    String DATABASE_NAME="CoffeeHouse.db";
    LinearLayoutManager linearLayoutManager;
    CoordinatorLayout coordinatorLayout;
    public static ArrayList<Product> GioHang=new ArrayList<>();
    public static RelativeLayout thanh_gio_hang;
    public static TextView soluong;
    public static TextView thanhTien;
    public static Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drop_menu = findViewById(R.id.drop_menu);
        appBarLayout = findViewById(R.id.appBarLayout);
        toolbar = findViewById(R.id.toolbar);
        view_animation =findViewById(R.id.view_animation);
        view_end_animation = findViewById(R.id.view_end_animation);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.recyclerView);
        thanh_gio_hang = findViewById(R.id.thanh_gio_hang);
        thanh_gio_hang.setVisibility(View.GONE);
        soluong= findViewById(R.id.soluong);
        thanhTien = findViewById(R.id.thanhtien);
        database = Database.initDatabase(this,DATABASE_NAME);
        thanh_gio_hang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.setContentView(R.layout.dialog_danhsachmuahang);
                Window window =dialog.getWindow();
                if (window == null)
                {
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
                WindowManager.LayoutParams layoutParams =window.getAttributes();
                layoutParams.gravity = Gravity.CENTER ;
                window.setAttributes(layoutParams);
                ListView listView = dialog.findViewById(R.id.danhsach_mua);
                listView.setAdapter(new GioHangAdapter(MainActivity.this,R.layout.item_giohang,GioHang));
                dialog.show();
            }
        });
        intitoolBar();
        initRecyclerview();
        initToolbarAnimation();
        onClickButtonGioHang();
        drop_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.setContentView(R.layout.dialog_filter_product);
                Window window =dialog.getWindow();
                if (window == null)
                {
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
                WindowManager.LayoutParams layoutParams =window.getAttributes();
                layoutParams.gravity = Gravity.BOTTOM | Gravity.LEFT;
                window.setAttributes(layoutParams);
                ListView listView = dialog.findViewById(R.id.danhmuc_sanpham);
                Cursor cursor= database.rawQuery("Select * from LoaiSanPham where ID <> 7",null);
                List<String> danhmuc = new ArrayList<>();
                while (cursor.moveToNext())
                {

                    danhmuc.add(cursor.getString(1));
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(dialog.getContext(), android.R.layout.simple_list_item_1,danhmuc);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        RecyclerView.SmoothScroller smoothScroller = new
                                LinearSmoothScroller(MainActivity.this) {
                                    @Override
                                    protected int getVerticalSnapPreference() {
                                        return LinearSmoothScroller.SNAP_TO_START;
                                    }
                                };
                        switch (position)
                        {
                            case 0:
                                smoothScroller.setTargetPosition(0);
                                linearLayoutManager.startSmoothScroll(smoothScroller);
                                dialog.dismiss();
                                break;
                            case 1:
                                smoothScroller.setTargetPosition(1);
                                linearLayoutManager.startSmoothScroll(smoothScroller);
                                dialog.dismiss();
                                break;
                            case 2:
                                smoothScroller.setTargetPosition(2);
                                linearLayoutManager.startSmoothScroll(smoothScroller);
                                dialog.dismiss();
                                break;
                            case 3:
                                smoothScroller.setTargetPosition(3);
                                linearLayoutManager.startSmoothScroll(smoothScroller);
                                dialog.dismiss();
                                break;
                            case 4:
                                smoothScroller.setTargetPosition(4);
                                linearLayoutManager.startSmoothScroll(smoothScroller);
                                dialog.dismiss();
                                break;
                            case 5:
                                smoothScroller.setTargetPosition(5);
                                linearLayoutManager.startSmoothScroll(smoothScroller);
                                dialog.dismiss();
                                break;
                            case 6:
                                smoothScroller.setTargetPosition(6);
                                linearLayoutManager.startSmoothScroll(smoothScroller);
                                dialog.dismiss();
                                break;
                        }
                    }
                });
                dialog.show();
            }
        });
    }
    private void intitoolBar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    private void initRecyclerview(){
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this);
        productCategoryAdapter.setData(getList());
        recyclerView.setAdapter(productCategoryAdapter);
    }


    private ArrayList<ProductCategory> getList() {
        ArrayList<ProductCategory> list = new ArrayList<>();

        list.add(AnhXa(1,1));
        list.add(AnhXa(2,1));
        list.add(AnhXa(3,1));
        list.add(AnhXa(4,1));
        list.add(AnhXa(5,1));
        list.add(AnhXa(6,1));
        return list;
    }
    private ProductCategory AnhXa(int LoaiSP,int Phanloai){
        ArrayList<Product> productList;
        Cursor cursor = database.rawQuery("Select * from SanPham where ID_LoaiSP="+LoaiSP+" and PhanLoai = "+Phanloai+";",null);
        productList = new ArrayList<>();
        while (cursor.moveToNext())
        {
            Product product = new Product(cursor.getInt(0),(byte[]) cursor.getBlob(5),cursor.getString(1),cursor.getInt(2));
            productList.add(product);
        }
        Cursor title = database.rawQuery("Select * from LoaiSanPham where ID="+LoaiSP,null);
        title.moveToFirst();
        ProductCategory productCategory = new ProductCategory(title.getString(1),productList);
        return productCategory;
    }
    private void initToolbarAnimation(){
        collapsingToolbarLayout.setTitle("The Coffee House");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bgmain);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int mColor = palette.getVibrantColor(getResources().getColor(R.color.color_toolbar));
                collapsingToolbarLayout.setContentScrimColor(mColor);
                collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.black_trans));
            }
        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset)>200){
                    isExpanded =false;
                }
                else {
                    isExpanded=true;
                }
                invalidateOptionsMenu();
            }
        });
    }
    private void onClickButtonGioHang() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hello World",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        mMenu = menu;
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mMenu!=null && (!isExpanded ||mMenu.size()!= 1)){
            mMenu.add("Add").setIcon(R.drawable.ic_add_2).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        }
        else {

        }
        return super.onPrepareOptionsMenu(mMenu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.more:
                return true;

        }
        if (item.getTitle()=="Add") {
            Toast.makeText(this,"Hello you!",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public static View getView_end_animation() {
        return view_end_animation;
    }

    public static ImageView getView_animation() {
        return view_animation;
    }
    public static void setThanhGioHang(){
        int soluongtinh=0;
        int thanhtienTinh=0;
        for (int i =0;i<MainActivity.GioHang.size();i++)
        {
            soluongtinh+=MainActivity.GioHang.get(i).getSoluong();
            thanhtienTinh+=MainActivity.GioHang.get(i).getThanhTien();
        }

        MainActivity.soluong.setText(soluongtinh+"");
        MainActivity.thanhTien.setText(thanhtienTinh+",000đ");
        MainActivity.thanh_gio_hang.setVisibility(View.VISIBLE);
        ProductCategoryAdapter.productAdapter.notifyDataSetChanged();
        if (GioHang.size()==0)
        {
            thanh_gio_hang.setVisibility(View.GONE);
        }
    }
}