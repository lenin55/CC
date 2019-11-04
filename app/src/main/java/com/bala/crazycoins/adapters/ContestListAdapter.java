package com.bala.crazycoins.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bala.crazycoins.R;

public class ContestListAdapter extends RecyclerView.Adapter<ContestListAdapter.ContestListViewHolder> {

    public ContestListAdapter(Context context) {
    }

    @NonNull
    @Override
    public ContestListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contest, null);
        return new ContestListAdapter.ContestListViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ContestListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ContestListViewHolder extends RecyclerView.ViewHolder {
        public ContestListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
