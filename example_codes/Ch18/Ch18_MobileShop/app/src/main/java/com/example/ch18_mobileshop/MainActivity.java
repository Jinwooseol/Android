package com.example.ch18_mobileshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    static List<Product> products;
    static List<Product> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 제품 및 장바구니 리스트 초기화
        products = new ArrayList<>();
        cartItems = new ArrayList<>();

        // RecyclerView 설정
        recyclerView = findViewById(R.id.productRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductAdapter(products, this));

        // Products 리스트에 제품 추가
        products.add(new Product(1, "EYE SERUM", 35000,
                "이 제품은 EYE SERUM 샘플입니다.",
                R.drawable.product1));
        products.add(new Product(2, "Doff Earbugs", 70000,
                "무선 이어폰",
                R.drawable.product2));
        products.add(new Product(3, "Red Sneaker", 70000,
                "Borcelle Fashion Sneaker",
                R.drawable.product3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 옵션 메뉴를 생성하고 메뉴 아이템을 추가
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void show_cart(MenuItem item) {
        // "장바구니 보기" 메뉴 항목을 클릭한 경우, 장바구니 화면으로 이동
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
}