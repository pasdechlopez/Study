//package com.example.study;
//
//import android.content.ClipData;
//import android.view.View;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.Collections;
//import java.util.List;
//
//public class ItemViewHolder extends RecyclerView.ViewHolder {
//    private TextView name;
//    private TextView price;
//
//    public ItemViewHolder(@NonNull View itemView ) {
//        super(itemView);
//
//        name = itemView.findViewById(R.id.name);
//        price = itemView.findViewById(R.id.price);
//
//    }
//
//    public void bind(ClipData.Item item){
//        name.setText(item.getName());
//        price.setText(item.getPrice());
//    }
//
//    private List<ClipData.Item> items = Collections.emptyList();
//
//    public void setItems(List<ClipData.Item> items) {
//        this.items = items;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//}
