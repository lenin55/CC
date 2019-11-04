package com.bala.crazycoins.views;


import com.bala.crazycoins.R;
import com.bala.crazycoins.base.BaseActivity;
import com.bala.crazycoins.databinding.ActivityMainBinding;
import com.bala.crazycoins.viewmodels.SignUpViewModel;

public class CrazyMainActivity extends BaseActivity<SignUpViewModel, ActivityMainBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public SignUpViewModel getViewModel() {
        return null;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }
}
