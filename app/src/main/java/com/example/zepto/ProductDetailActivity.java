package com.example.zepto;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class ProductDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ImageView image = findViewById(R.id.detail_image);
        TextView name = findViewById(R.id.detail_name);
        TextView price = findViewById(R.id.detail_price);
        TextView mrp = findViewById(R.id.detail_mrp);
        TextView qty = findViewById(R.id.detail_qty);
        Button btn = findViewById(R.id.btn_add_to_cart_detail);
        String pName = getIntent().getStringExtra("name");
        String pPrice = getIntent().getStringExtra("price");
        String pMrp = getIntent().getStringExtra("mrp");
        String pQty = getIntent().getStringExtra("qty");
        int pImage = getIntent().getIntExtra("image", R.drawable.fortune);
        name.setText(pName);
        price.setText(pPrice);
        mrp.setText(pMrp);
        qty.setText(pQty);
        image.setImageResource(pImage);
        Product cur = new Product(pName, pImage, pPrice, pMrp, pQty);
        btn.setOnClickListener(v -> {
            CartManager.getInstance().addToCart(cur);
            Toast.makeText(this, pName+" added to cart", Toast.LENGTH_SHORT).show();
        });
    }
}