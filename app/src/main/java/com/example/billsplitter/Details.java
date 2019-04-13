package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class Details extends AppCompatActivity {

    private PersonAdapter perAdap;
    private ArrayList<Person> perData = new ArrayList<>();
    private ArrayList<OrderModel> ordData;
    private EditText ia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        RecyclerView perRecyc;
        ordData = (ArrayList<OrderModel>) getIntent().getSerializableExtra("OrdData");
        perRecyc = findViewById(R.id.peopleRecycler);
        perRecyc.setHasFixedSize(true);
        perRecyc.setLayoutManager(new LinearLayoutManager(this));
        perAdap = new PersonAdapter(this, perData);
        perRecyc.setAdapter(perAdap);
        Button save = findViewById(R.id.save);
        Button add = findViewById(R.id.add);
        ia = findViewById(R.id.personName);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = ia.getText().toString();
                if (n.equals("")) {
                    Toast.makeText(Details.this, "Input Text Is Empty.. Please Enter Some Text", Toast.LENGTH_SHORT).show();
                } else {
                    Person temp = new Person(n);
                    perAdap.addItem(temp);
                    perAdap.notifyDataSetChanged();
                    ia.setText("");
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perData = perAdap.getPerList();
                if (perData.size() != 0) {
                    Intent i = new Intent(Details.this, Assign.class);
                    i.putExtra("OrdData", ordData);
                    i.putExtra("PerData", perData);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Details.this, "0 persons", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
