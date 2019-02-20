package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity implements input_dialog.input_dialogListener {

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
        TextView item1 = findViewById(R.id.itemone);
        TextView item2 = findViewById(R.id.itemtwo);
        item1.setText(ia);
        item2.setText(ib);
        Log.d("FIRSTI",item1.getText().toString());
        Log.d("SECONDI",item2.getText().toString());

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
