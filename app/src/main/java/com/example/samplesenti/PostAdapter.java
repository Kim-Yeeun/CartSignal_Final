package com.example.samplesenti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyHolder> {
    Context context;
    List<Post> postlist;
    String meUid;

    PostAdapter(Context context, List<Post> postlist, String meUid) {
        this.context = context;
        this.postlist = postlist;
        meUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemhost, parent, false);
        return new PostAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //final String uid = postlist.get(position).get();
        final String money = postlist.get(position).getMinMoney();
        final String user = postlist.get(position).getMaxUser();
        final String info = postlist.get(position).getMoreInfo();
        final String date = postlist.get(position).getEndDate();

        if (money != null) {
            holder.stMoney.setText(money);
            holder.stUser.setText(user);
            holder.stInfo.setText(info);
            holder.stDate.setText(date);
        }
    }

    @Override
    public int getItemCount() {
        return postlist.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        EditText stMoney, stUser, stInfo, stDate;

        public MyHolder(View itemView) {
            super(itemView);

            stMoney = itemView.findViewById(R.id.minMoney);
            stUser = itemView.findViewById(R.id.maxUser);
            stInfo = itemView.findViewById(R.id.moreInfo);
            stDate = itemView.findViewById(R.id.endDate);

        }
    }
}