package com.bala.crazycoins.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bala.crazycoins.R;


public class OTPFragment extends Fragment {

    private int height;

    private FrameLayout fmBackground;

    public static OTPFragment newInstance() {
        return new OTPFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ot, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        height = display.getHeight();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fmBackground = view.findViewById(R.id.frame_otp_bg);
        ConstraintLayout.LayoutParams newLayoutParams = (ConstraintLayout.LayoutParams) fmBackground.getLayoutParams();
        newLayoutParams.height = height / 2;
        fmBackground.setLayoutParams(newLayoutParams);
        view.findViewById(R.id.fab_next).setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), HomeActivity.class));
            getActivity().finish();
        });
    }
}
