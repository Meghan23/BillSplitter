package com.example.billsplitter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class AssignAdapter extends RecyclerView.Adapter<AssignAdapter.AssignViewHolder> implements input_dialog.input_dialogListener {

    private Context mCtx;
    private ArrayList<OrderModel> orderList;
    private ArrayList<Person> perData;
    private int[][] map;
    int pos;

    public AssignAdapter(Context mCtx, ArrayList<OrderModel> orderList, ArrayList<Person> perData) {
        this.mCtx = mCtx;
        this.orderList = orderList;
        this.perData = perData;
        map = new int[orderList.size()][perData.size()];
    }

    @Override
    public AssignViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.assign_inflate, null);
        return new AssignViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AssignViewHolder holder, int position) {
        pos = position;
        OrderModel ord = orderList.get(position);
        holder.ordName.setText(ord.getName());
        holder.ordName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInputDialog();
            }
        });
    }

    public int[][] getMapping() {
        return map;
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public void showInputDialog() {
        Bundle b = new Bundle();
        b.putSerializable("PerData", perData);
        input_dialog in = new input_dialog();
        in.setArguments(b);
        in.show(((AppCompatActivity) mCtx).getSupportFragmentManager(), "checks");
    }

    public void applyChanges(ArrayList<Integer> a) {

        for (int j = 0; j < perData.size(); j++) {
            if (a.contains(j)) {
                map[pos][j] = 1;
            }
        }
    }

    class AssignViewHolder extends RecyclerView.ViewHolder {

        TextView ordName;

        public AssignViewHolder(View itemView) {
            super(itemView);
            ordName = itemView.findViewById(R.id.itemName);
        }
    }
}
