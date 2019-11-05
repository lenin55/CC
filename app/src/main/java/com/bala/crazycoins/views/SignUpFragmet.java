package com.bala.crazycoins.views;

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
}
