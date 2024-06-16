package com.example.ch18_mobileshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ch18_mobileshop.MainActivity;
import com.example.ch18_mobileshop.Product;
import com.example.ch18_mobileshop.R;
import com.example.ch18_mobileshop.CartAdapter;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<Product> cartItems = MainActivity.cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cartRecyclerView);
        cartAdapter = new CartAdapter(cartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);

        // "결제" 버튼 클릭 이벤트 처리
        Button checkoutButton = findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 결제 처리 또는 주문 요약 화면을 이동
            }
        });
    }
}
