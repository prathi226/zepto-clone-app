package com.example.zepto;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyOrdersActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_my_orders);
        RecyclerView rv = findViewById(R.id.ordersRecycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order("Fortune Oil 1L", "₹150", "Ordered", 1));
        orders.add(new Order("Lays Chips", "₹30", "Shipped", 3));
        orders.add(new Order("Coca Cola 300ml", "₹40", "Out for Delivery", 4));
        orders.add(new Order("Amul Milk", "₹28", "Delivered", 5));
        rv.setAdapter(new OrdersAdapter(orders));
    }
    public static class Order {
        String name, price, status; int step;
        public Order(String n, String p, String s, int st){ name=n; price=p; status=s; step=st; }
    }
}