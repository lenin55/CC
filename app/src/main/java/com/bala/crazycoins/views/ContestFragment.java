package com.bala.crazycoins.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bala.crazycoins.R;
import com.bala.crazycoins.viewmodels.ContestViewModel;

public class ContestFragment extends Fragment {

    private ContestViewModel contestViewModel;

    private RecyclerView rvContestList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contestViewModel =
                ViewModelProviders.of(this).get(ContestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contest, container, false);
        root.findViewById(R.id.iv_logo).setVisibility(View.GONE);
        root.findViewById(R.id.tv_contest).setVisibility(View.VISIBLE);
        rvContestList = root.findViewById(R.id.rv_contest_list);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvContestList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContestList.setAdapter(new MyContestAdapter());
    }
}