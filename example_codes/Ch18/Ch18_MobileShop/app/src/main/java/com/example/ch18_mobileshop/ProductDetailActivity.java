package com.example.ch18_mobileshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {
    private Button addToCartButton;
    private List<Product> cartItems = MainActivity.cartItems;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // 인텐트로 선택한 제품 정보를 가져온다.
        Intent intent = getIntent();
        if (intent != null) {
            product = (Product) intent.getSerializableExtra("product");
            if (product != null) {
                // Layout 요소 초기화 및 선택한 제품 정보 표시
                TextView productName = findViewById(R.id.productDetailName);
                TextView productPrice = findViewById(R.id.productDetailPrice);
                TextView productDescription = findViewById(R.id.productDetailDescription);
                ImageView productImage = findViewById(R.id.productDetailImage);

                productName.setText(product.getName());
                productPrice.setText("" + product.getPrice() + "원");
                productDescription.setText(product.getDescription());
                productImage.setImageResource(product.getImageResId());
            }
        }
        // "장바구니 담기" 버튼 클릭 이번트 처리
        addToCartButton = findViewById(R.id.addToCartButton);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 제품을 장바구니에 추가
                cartItems.add(product);
                Toast.makeText(ProductDetailActivity.this, "장바구니에 추가되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 옵션 메뉴를 생성하고 메뉴 아이템을 추가
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);
        return true;
    }
    public void show_cart(MenuItem item) {
        // "장바구니 보기" 메뉴 항목을 클릭한 경우, 장바구니 화면으로 이동
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
}
