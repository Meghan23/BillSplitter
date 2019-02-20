package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Order extends AppCompatActivity {

    private EditText ia, ib, pa, pb;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ia = findViewById(R.id.itema);
        pa = findViewById(R.id.price1);
        ib = findViewById(R.id.item2);
        pb = findViewById(R.id.price2);
        next = findViewById(R.id.next);
        final String i1 = ia.getText().toString();
        final String i2 = ib.getText().toString();
        final int p1 = Integer.parseInt(pa.getText().toString());
        final int p2 = Integer.parseInt(pb.getText().toString());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Order.this, People.class);
                i.putExtra("pa",p1);
                i.putExtra("pb",p2);
                i.putExtra("ia",i1);
                i.putExtra("ib",i2);
                startActivity(i);
            }
        });

    }
}
