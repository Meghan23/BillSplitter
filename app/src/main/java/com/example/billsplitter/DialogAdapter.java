package com.example.billsplitter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import java.util.ArrayList;


public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder> {

    private Context mCtx;
    private ArrayList<Person> perData;
    int pos;
    private ArrayList<Integer> assigned = new ArrayList<>();

    public DialogAdapter(Context mCtx, ArrayList<Person> perData) {
        this.mCtx = mCtx;
        this.perData = perData;
    }

    @Override
    public DialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.inflate_chkbox, null);
        return new DialogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DialogViewHolder holder, int position) {
        pos = position;
        Person ord = perData.get(position);
        holder.checkBox.setText(ord.getName());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.checkBox.isChecked()){
                    assigned.add(pos);
                }
            }
        });
    }

    public ArrayList<Integer> fetchAssigned(){
        return assigned;
    }

    @Override
    public int getItemCount() {
        return perData.size();
    }

    class DialogViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox;

        public DialogViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.chk);
        }
    }
}
