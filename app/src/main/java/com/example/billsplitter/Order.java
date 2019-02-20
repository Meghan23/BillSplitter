package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Order extends AppCompatActivity {

    private EditText ia, ib, pa, pb, ba, bb;
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
        ba = findViewById(R.id.person1);
        bb = findViewById(R.id.person2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String i1 = ia.getText().toString();
                final String i2 = ib.getText().toString();
                final double p1 = Double.parseDouble(pa.getText().toString());
                final double p2 = Double.parseDouble(pb.getText().toString());
                final String b1 = ba.getText().toString();
                final String b2 = bb.getText().toString();
                Intent i = new Intent(Order.this, Details.class);
                i.putExtra("pa",p1);
                i.putExtra("pb",p2);
                i.putExtra("ia",i1);
                i.putExtra("ib",i2);
                i.putExtra("ba",b1);
                i.putExtra("bb",b2);
                startActivity(i);
            }
        });

    }
}
