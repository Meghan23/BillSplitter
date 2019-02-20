package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bu = getIntent().getExtras();
        int[][] data = (int[][]) bu.getSerializable("data");
        String b1 = bu.getString("ba");
        String b2 = bu.getString("bb");
        double p1 = bu.getDouble("pa");
        double p2 = bu.getDouble("pb");
        double[] p = new double[]{p1, p2};
        int[] fin = new int[2];
        int n;

        for(int i = 0; i < 2; i++){
            n = 0;
            for(int j = 0; j < 2; j++){
                if(data[i][j] == 1)
                    n++;
            }
            for(int j = 0; j < 2; j++){
                if(data[i][j] == 1)
                    fin[j]+=(p[j]/n);
            }
        }

        TextView pa, pb, c1, c2;
        Button b = findViewById(R.id.home);
        pa = findViewById(R.id.pone);
        pb = findViewById(R.id.ptwo);
        c1 = findViewById(R.id.cone);
        c2 = findViewById(R.id.ctwo);

        pa.setText(b1);
        pb.setText(b2);
        c1.setText(Integer.toString(fin[0]));
        c2.setText(Integer.toString(fin[1]));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(result.this, Home.class);
                startActivity(i);
            }
        });
    }
}
