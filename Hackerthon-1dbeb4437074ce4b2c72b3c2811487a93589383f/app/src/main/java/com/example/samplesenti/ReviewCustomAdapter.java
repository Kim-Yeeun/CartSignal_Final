package com.example.samplesenti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewCustomAdapter extends RecyclerView.Adapter<ReviewCustomAdapter.CustomViewHolder> {
    private ArrayList<Review> arrayList;
    private Context context;


    public ReviewCustomAdapter(ArrayList<Review> arrayList, ReviewRecyclerView mainActivity) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_list_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_total.setText(String.valueOf(arrayList.get(position).getTotal()));
        holder.tv_time.setText(String.valueOf(arrayList.get(position).getTime()));
        holder.tv_trust.setText(String.valueOf(arrayList.get(position).getTrust()));
        holder.tv_sentence.setText(String.valueOf(arrayList.get(position).getReview()));

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView tv_total;
        TextView tv_time;
        TextView tv_trust;
        TextView tv_sentence;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_total = itemView.findViewById(R.id.tv_total);
            this.tv_time = itemView.findViewById(R.id.tv_time);
            this.tv_trust = itemView.findViewById(R.id.tv_trust);
            this.tv_sentence = itemView.findViewById(R.id.tv_sentence);

        }
    }
}
