package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class Assign extends AppCompatActivity implements input_dialog.input_dialogListener {

    private AssignAdapter ordAdap;
    private ArrayList<OrderModel> ordData = new ArrayList<>();
    private ArrayList<Person> perData = new ArrayList<>();
    private int[][] map;
    private double[] fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign);
        Button next;
        next = findViewById(R.id.Next);
        ordData = (ArrayList<OrderModel>) getIntent().getSerializableExtra("OrdData");
        perData = (ArrayList<Person>) getIntent().getSerializableExtra("PerData");
        map = new int[ordData.size()][perData.size()];
        RecyclerView ordRecyc;
        ordRecyc = findViewById(R.id.assignRecycler);
        ordRecyc.setHasFixedSize(true);
        ordRecyc.setLayoutManager(new LinearLayoutManager(this));
        ordAdap = new AssignAdapter(this, ordData, perData);
        ordRecyc.setAdapter(ordAdap);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map = ordAdap.getMapping();
                fin = new double[perData.size()];
                int n;
                double p;
                for (int i = 0; i < ordData.size(); i++) {
                    p = (Double.parseDouble(ordData.get(i).getPrice()));
                    n = 0;
                    for (int j = 0; j < perData.size(); j++) {
                        if (map[i][j] == 1)
                            n++;
                    }
                    for (int j = 0; j < perData.size(); j++) {
                        if (map[i][j] == 1)
                            fin[j] += (p / n);
                    }
                }
                Intent i = new Intent(Assign.this, result.class);
                i.putExtra("mapping",map);
                i.putExtra("OrdData", ordData);
                i.putExtra("PerData", perData);
                i.putExtra("FinalSplit",fin);
                startActivity(i);
            }
        });
    }

    @Override
    public void applyChanges(ArrayList<Integer> assigned) {

    }
}
