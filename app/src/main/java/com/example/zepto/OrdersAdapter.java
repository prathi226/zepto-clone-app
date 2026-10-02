package com.example.zepto;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.VH> {
    ArrayList<MyOrdersActivity.Order> list;
    public OrdersAdapter(ArrayList<MyOrdersActivity.Order> l){ list=l; }
    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup p,int v){ return new VH(LayoutInflater.from(p.getContext()).inflate(R.layout.item_order, p, false)); }
    @Override public void onBindViewHolder(@NonNull VH h,int p){
        MyOrdersActivity.Order o = list.get(p);
        h.name.setText(o.name); h.price.setText(o.price); h.status.setText("Status: "+o.status);
        String track = o.step>=1?"✓ Ordered":"○ Ordered";
        track+= o.step>=2?" → ✓ Packed":" → ○ Packed";
        track+= o.step>=3?" → ✓ Shipped":" → ○ Shipped";
        track+= o.step>=4?" → ✓ Out for Delivery":" → ○ Out for Delivery";
        track+= o.step>=5?" → ✓ Delivered":" → ○ Delivered";
        h.track.setText(track);
    }
    @Override public int getItemCount(){ return list.size(); }
    static class VH extends RecyclerView.ViewHolder{
        TextView name,price,status,track;
        public VH(@NonNull View v){ super(v); name=v.findViewById(R.id.orderName); price=v.findViewById(R.id.orderPrice); status=v.findViewById(R.id.orderStatus); track=v.findViewById(R.id.orderTrack); }
    }
}