package com.example.billsplitter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity implements input_dialog.input_dialogListener {

    private TextView item1, item2;
    final Context c = this;
    final int[][] det = new int[2][2] ;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
        final String pa = i.getStringExtra("ba");
        final String pb = i.getStringExtra("bb");
        String ia = i.getStringExtra("i1");
        String ib = i.getStringExtra("i2");
        item1 = findViewById(R.id.i1);
        item2 = findViewById(R.id.i2);
        item1.setText(ia);
        item2.setText(ib);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = 0;
                openDialog();
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = 1;
                openDialog();
            }
        });
    }

    public void openDialog(){
        input_dialog in = new input_dialog();
        in.show(getSupportFragmentManager(),"checks");
    }

    @Override
    public void applyChanges(int a, int b) {
        det[x][0] = a;
        det[x][1] = b;
    }
}
