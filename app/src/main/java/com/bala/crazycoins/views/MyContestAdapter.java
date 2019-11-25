package com.bala.crazycoins.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bala.crazycoins.R;

public class MyContestAdapter extends RecyclerView.Adapter<MyContestAdapter.ContactListViewHolder> {
    @NonNull
    @Override
    public ContactListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contests_list, parent,false);
        return new MyContestAdapter.ContactListViewHolder(inflate);    }

    @Override
    public void onBindViewHolder(@NonNull ContactListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ContactListViewHolder extends RecyclerView.ViewHolder {
        public ContactListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
