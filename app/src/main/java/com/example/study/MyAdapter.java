package com.example.study;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class MyAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";

    private List<Item> itemsList = Collections.emptyList();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.item,
                        parent,
                        false
                );
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(itemsList.get(position));
        Log.i(TAG, "onBindViewHolder: "+ itemsList.get(position).isSold());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Item item) {
            TextView textView = itemView.findViewById(R.id.text);
            String str = item.getName() + item.getPrice();
            int color = itemView.getContext().getResources().getColor(R.color.smth);
            textView.setBackgroundColor(item.isSold() ? color: 0);
            textView.setText(item.isSold() ? str + "" + "Sold" : str);
        }
    }

    public void setItems(List<Item> itemsList) {
        this.itemsList = itemsList;
        notifyDataSetChanged();
    }

    public List<Item> getItems() {
        return itemsList;
    }
}
