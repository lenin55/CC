package com.bala.crazycoins.views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bala.crazycoins.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MegaContestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MegaContestFragment extends Fragment {


    public MegaContestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MegaContestFragment.
     */
    public static MegaContestFragment newInstance() {
        return new MegaContestFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mega_contest, container, false);
    }

}
