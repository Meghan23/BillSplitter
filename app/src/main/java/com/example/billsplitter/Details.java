package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity implements input_dialog.input_dialogListener {

    String pa, pb;
    final int[][] det = new int[2][2] ;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final Bundle extras = getIntent().getExtras();
        String ia = extras.getString("ia");
        String ib = extras.getString("ib");
        pa = extras.getString("ba");
        pb = extras.getString("bb");
        TextView item1 = findViewById(R.id.itemone);
        TextView item2 = findViewById(R.id.itemtwo);
        Button save = findViewById(R.id.save);
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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bu = new Bundle(extras);
                Intent i = new Intent(Details.this, result.class);
                bu.putSerializable("data",det);
                i.putExtras(bu);
                startActivity(i);
            }
        });
    }

    public void openDialog(){
        Bundle b = new Bundle();
        b.putString("pa",pa);
        b.putString("pb",pb);
        input_dialog in = new input_dialog();
        in.setArguments(b);
        in.show(getSupportFragmentManager(),"checks");
    }

    @Override
    public void applyChanges(int a, int b) {
        det[x][0] = a;
        det[x][1] = b;
    }
}
