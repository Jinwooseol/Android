package com.example.ch18_mobileshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<Product> cartItems = MainActivity.cartItems;

    public CartAdapter(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 장바구니 아이템을 표시하는 View Holder 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Product product = cartItems.get(position);
        // View Holder에 제품 정보를 binding하고 "삭제" 버튼 클릭 이벤트 처리

        holder.bind(product);
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productName;
        private TextView productPrice;
        private Button removeButton;
        private ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.cartItemName);
            productPrice = itemView.findViewById(R.id.cartItemPrice);
            productImage = itemView.findViewById(R.id.cartItemProductImage);
            removeButton = itemView.findViewById(R.id.removeFromCartButton);
        }

        public void bind(Product product) {
            // 제품 정보를 View Holde의 각 View 요소에 설정
            productName.setText(product.getName());
            productPrice.setText("" + product.getPrice() + "원");
            productImage.setImageResource(product.getImageResId());
        }
    }
    public void removeItem(int position) {
        // 장바구니에서 아이템을 제거하고 이를 RecyclerView에 알림
        if (position >= 0 && position < cartItems.size()) {
            cartItems.remove(position);
            notifyItemRemoved(position);
        }
    }
}
