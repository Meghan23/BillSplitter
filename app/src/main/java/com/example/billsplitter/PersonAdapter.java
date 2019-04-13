package com.example.billsplitter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private Context mCtx;
    private ArrayList<Person> perList;
  //  int pos;

    public PersonAdapter(Context mCtx, ArrayList<Person> perList) {
        this.mCtx = mCtx;
        this.perList = perList;
    }

    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.inflate_person, null);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
 //       pos = position;
        Person ord = perList.get(position);
        holder.pName.setText(ord.getName());
   //     holder.ordPrice.setText(ord.getPrice());
   /*     holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderList.remove(pos);
                notifyItemRemoved(pos);
                notifyItemRangeChanged(pos,orderList.size());
            }
        });
        */
    }

    public void addItem(Person xyz) {
        perList.add(xyz);
    }

    public ArrayList<Person> getPerList(){
        return perList;
    }

    @Override
    public int getItemCount() {
        return perList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView pName;

        public PersonViewHolder(View itemView) {
            super(itemView);
            pName = itemView.findViewById(R.id.personName);
        }
    }
}
