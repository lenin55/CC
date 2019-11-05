package com.bala.crazycoins.views;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

import com.bala.crazycoins.R;
import com.bala.crazycoins.base.BaseFragment;
import com.bala.crazycoins.databinding.FragmentSignUpBinding;
import com.bala.crazycoins.viewmodels.SignUpViewModel;

public class SignUpFragmet extends BaseFragment<SignUpViewModel, FragmentSignUpBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_sign_up;
    }

    @Override
    public SignUpViewModel getViewModel() {
        return ViewModelProviders.of(this).get(SignUpViewModel.class);
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    public static SignUpFragmet newInstance() {
        return new SignUpFragmet();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fab_next).setOnClickListener(v -> {
            if (getActivity() instanceof WelcomeScreenActivity) {
                ((WelcomeScreenActivity) getActivity()).addFragment(OTPFragment.newInstance(), true, false);
            }
        });
    }
}
