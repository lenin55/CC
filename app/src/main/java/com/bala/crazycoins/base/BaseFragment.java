/*
 * @category crazy coins app
 * @copyright Copyright (C) 2019 . All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.bala.crazycoins.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * The fragment is act as base fragment for all other fragments where common operations for fragment
 * handled here.
 *
 * @param <T> Instance of {@link ViewDataBinding}.
 * @version 1.0
 */

public abstract class BaseFragment<V extends BaseViewModel, T
        extends ViewDataBinding> extends Fragment {

    /**
     * Activity context
     */
    private BaseActivity mActivity;

    /**
     * View
     */
    private View mRootView;

    /**
     * Data binding
     */
    private T mViewDataBinding;

    /**
     * View model class
     */
    private V mViewModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();

        setHasOptionsMenu(false);
    }

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();
        return mRootView;
    }

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    /**
     * Get the instance of {@link BaseActivity}.
     *
     * @return BaseActivity
     */
    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    /**
     * Gat the instance of {@link ViewDataBinding}.
     *
     * @return ViewDataBinding
     */
    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    /**
     * Check if the internat available.
     *
     * @return boolean, Return true if network available.
     */
    public boolean isNetworkConnected() {
        return mActivity != null && mActivity.isNetworkConnected();
    }

    /**
     * Method to show toast from extended activity.
     *
     * @param stringResourceId Id of {@link StringRes}
     */
    protected void showToast(@StringRes int stringResourceId) {
        getViewModel().showToast(getString(stringResourceId));
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

    /**
     * Calbak for base fragment related operations.
     */
    public interface Callback {

        /**
         * Callback on fragment attached.
         */
        void onFragmentAttached();

        /**
         * Callback on fragment detached from activity.
         *
         * @param tag Name tag of activity.
         */
        void onFragmentDetached(String tag);
    }

}