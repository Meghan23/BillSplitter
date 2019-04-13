package com.example.billsplitter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private Context mCtx;
    private ArrayList<OrderModel> orderList;
    int pos;

    public OrderAdapter(Context mCtx, ArrayList<OrderModel> orderList) {
        this.mCtx = mCtx;
        this.orderList = orderList;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_card_inflate, null);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        pos = position;
        OrderModel ord = orderList.get(position);
        holder.ordName.setText(ord.getName());
        holder.ordPrice.setText(ord.getPrice());
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderList.remove(pos);
                notifyItemRemoved(pos);
                notifyItemRangeChanged(pos,orderList.size());
            }
        });
    }

    public void addItem(OrderModel xyz) {
        orderList.add(xyz);
    }

    public ArrayList<OrderModel> getOrderList(){
        return orderList;
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView ordName, ordPrice;
        ImageButton del;

        public OrderViewHolder(View itemView) {
            super(itemView);
            ordName = itemView.findViewById(R.id.newDish);
            ordPrice = itemView.findViewById(R.id.newPrice);
            del = itemView.findViewById(R.id.Delete);
        }
    }
}
