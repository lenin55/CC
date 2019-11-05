package com.bala.crazycoins.views;

import androidx.lifecycle.ViewModelProviders;

import com.bala.crazycoins.R;
import com.bala.crazycoins.base.BaseFragment;
import com.bala.crazycoins.databinding.FragmentSignInBinding;
import com.bala.crazycoins.viewmodels.SignInViewModel;

public class SignInFragment extends BaseFragment<SignInViewModel, FragmentSignInBinding> {
    @Override
    public SignInViewModel getViewModel() {
        return ViewModelProviders.of(this).get(SignInViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_sign_in;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    public static SignInFragment newInstance() {
        return new SignInFragment();
    }

}
