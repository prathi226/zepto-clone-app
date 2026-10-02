package com.example.zepto;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    ArrayList<String> list;
    SettingsActivity activity;
    public AddressAdapter(ArrayList<String> list, SettingsActivity activity) {
        this.list = list; this.activity = activity;
    }
    @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup p, int v) {
        return new ViewHolder(LayoutInflater.from(p.getContext()).inflate(android.R.layout.simple_list_item_1, p, false));
    }
    @Override public void onBindViewHolder(@NonNull ViewHolder h, int p) {
        h.text.setText(list.get(p));
        h.itemView.setOnClickListener(v -> activity.showAddressDialog(p));
    }
    @Override public int getItemCount() { return list.size(); }
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text; public ViewHolder(@NonNull View v){ super(v); text = v.findViewById(android.R.id.text1); }
    }
}