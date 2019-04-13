package com.example.billsplitter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;


public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {

    private Context mCtx;
    private ArrayList<Person> ResultList;
    private ArrayList<OrderModel> OrdList;
    private double[] fin;
    int pos;

    public ResultAdapter(Context mCtx, ArrayList<Person> ResultList, ArrayList<OrderModel> OrdList, int[][] map, double[] fin) {
        this.mCtx = mCtx;
        this.ResultList = ResultList;
        this.OrdList = OrdList;
        this.fin = fin;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.result_inflate, null);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        pos = position;
        Person ord = ResultList.get(position);
        holder.ordName.setText(ord.getName());
        holder.ordPrice.setText(NumberFormat.getNumberInstance().format(fin[position]));
    }

    @Override
    public int getItemCount() {
        return ResultList.size();
    }

    class ResultViewHolder extends RecyclerView.ViewHolder {

        TextView ordName, ordPrice;
        ;

        public ResultViewHolder(View itemView) {
            super(itemView);
            ordName = itemView.findViewById(R.id.person);
            ordPrice = itemView.findViewById(R.id.contri);
        }
    }
}
