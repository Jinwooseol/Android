package com.example.ch18_mobileshop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> products;
    private List<Product> cartItems = MainActivity.cartItems;
    private Context context;

    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // XML 레이아웃 파일을 가져와서 ViewHolder를 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,
                parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.bind(product);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("product", product);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productName;
        private TextView productPrice;
        private ImageView productImage;

        public ViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);
        }

        public void bind(Product product) {
            // 제품 정보를 ViewHolder에 연결한다.
            productName.setText(product.getName());
            productPrice.setText("" + product.getPrice() + "원");
            productImage.setImageResource(product.getImageResId());
        }
    }
}
