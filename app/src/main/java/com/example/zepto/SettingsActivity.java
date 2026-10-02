package com.example.zepto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AddressAdapter adapter;
    ArrayList<String> addressList = new ArrayList<>();
    Button addAddressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        recyclerView = findViewById(R.id.addressRecycler);
        addAddressBtn = findViewById(R.id.addAddressBtn);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AddressAdapter(addressList, this);
        recyclerView.setAdapter(adapter);

        addressList.add("Home - Mysore, Karnataka 570001");
        adapter.notifyDataSetChanged();

        addAddressBtn.setOnClickListener(v -> showAddressDialog(-1));

        findViewById(R.id.ordersSection).setOnClickListener(v -> {
            startActivity(new Intent(this, MyOrdersActivity.class));
        });
    }

    public void showAddressDialog(int position) {
        EditText editText = new EditText(this);
        if (position != -1) editText.setText(addressList.get(position));

        new AlertDialog.Builder(this)
                .setTitle(position == -1 ? "Add Address" : "Edit Address")
                .setView(editText)
                .setPositiveButton("Save", (d, w) -> {
                    String addr = editText.getText().toString();
                    if (!addr.isEmpty()) {
                        if (position == -1) addressList.add(addr);
                        else addressList.set(position, addr);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(this, "Address Saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setNeutralButton(position != -1 ? "Delete" : null, (d, w) -> {
                    if (position != -1) {
                        addressList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                })
                .show();
    }
}