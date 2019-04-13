package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class Order extends AppCompatActivity {

    private EditText ia, pa;
    private OrderAdapter ordAdap;
    private ArrayList<OrderModel> ordData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Button next, add;
        RecyclerView ordRecyc;
        add = findViewById(R.id.add);
        ia = findViewById(R.id.itema);
        pa = findViewById(R.id.price1);
        next = findViewById(R.id.next);
        ordRecyc = findViewById(R.id.orderRecycler);
        ordRecyc.setHasFixedSize(true);
        ordRecyc.setLayoutManager(new LinearLayoutManager(this));
        ordAdap = new OrderAdapter(this, ordData);
        ordRecyc.setAdapter(ordAdap);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = ia.getText().toString();
                String p = pa.getText().toString();
                OrderModel temp = new OrderModel(n, p);
                ordAdap.addItem(temp);
                ordAdap.notifyDataSetChanged();
                ia.setText("");
                pa.setText("");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ordData = ordAdap.getOrderList();
                Intent i = new Intent(Order.this, Details.class);
                i.putExtra("OrdData", ordData);
                startActivity(i);
            }
        });

    }
}
