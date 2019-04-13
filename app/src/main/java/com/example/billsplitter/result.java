package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int[][] map;
        RecyclerView resRecyc;
        ResultAdapter resAdapt;
        Button b;
        map = (int[][]) getIntent().getSerializableExtra("mapping");
        ArrayList<Person> perData = (ArrayList<Person>) getIntent().getSerializableExtra("PerData");
        ArrayList<OrderModel> ordData = (ArrayList<OrderModel>) getIntent().getSerializableExtra("OrdData");
        double[] fin = (double[]) getIntent().getSerializableExtra("FinalSplit");
        resRecyc = findViewById(R.id.resultRecycler);
        resRecyc.setHasFixedSize(true);
        resRecyc.setLayoutManager(new LinearLayoutManager(this));
        resAdapt = new ResultAdapter(this, perData, ordData, map, fin);
        resRecyc.setAdapter(resAdapt);
        b = findViewById(R.id.home);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(result.this, Home.class);
                startActivity(i);
            }
        });
    }
}
