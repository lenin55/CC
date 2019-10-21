/*
 * @category crazy coins app
 * @copyright Copyright (C) 2019 . All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.bala.crazycoins.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * The activity is act as base activity for all other activities where common operations for
 * activity handled here.
 *
 * @param <V> Instance of {@link android}.
 * @param <T> Instance of {@link ViewDataBinding}.
 * @version 1.0
 */

public abstract class BaseActivity<V extends BaseViewModel, T extends ViewDataBinding>
        extends AppCompatActivity implements
        BaseFragment.Callback {

    /**
     * Base view model
     */
    private V baseViewModel;

    /**
     * Data binding
     */
    private T viewDataBinding;

    @Override
    public void onFragmentAttached() {
        //no implementation
    }

    @Override
    public void onFragmentDetached(String tag) {
        //no implementation
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
        isNetworkConnected();
    }

    /**
     * To perform the data binding model
     */
    private void performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.baseViewModel = baseViewModel == null ? getViewModel() : baseViewModel;
        viewDataBinding.setVariable(getBindingVariable(), baseViewModel);
        viewDataBinding.executePendingBindings();
    }

    /**
     * Check if the internet available.
     *
     * @return boolean, Return true if network available.
     */
    protected boolean isNetworkConnected() {
        return InternetConnectivityReceiver.isConnected();
    }

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * Gat the instance of {@link ViewDataBinding}.
     *
     * @return ViewDataBinding
     */
    protected T getViewDataBinding() {
        return viewDataBinding;
    }

    /**
     * Check the status of special permission.
     *
     * @param permission Permission name tag.
     * @return boolean, Return true if permission available.
     */
    @TargetApi(Build.VERSION_CODES.M)
    protected boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Hide the keypad.
     */
    protected void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context
                    .INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context
                    .INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * make toast method to show toast if safe context check
     *
     * @param context context
     * @param message message
     */
    public void makeToast(Context context, String message) {
        if (context != null && message != null)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

