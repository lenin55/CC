/*
 * @category crazy coins app
 * @copyright Copyright (C) 2019 . All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.bala.crazycoins.base;

import android.app.Application;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.AndroidViewModel;


/**
 * The view model is act as base view model for all other view model where common operations for
 * view model handled here.
 *
 * @param <I> Listener for operations from activity.
 * @version 1.0
 */

public class BaseViewModel<I> extends AndroidViewModel {

    private I iView;

    /**
     * Constructor for {@link BaseViewModel}.
     *
     * @param application Instance of application.
     */
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Method to show toast from extended view model.
     *
     * @param message Id of {@link StringRes}
     */

    protected void showToast(String message) {
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(BaseApplication.getInstance(), message,
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Get the navigation interface.
     *
     * @return I, INstance of interface.
     */
    public I getNavigator() {
        return iView;
    }

    /**
     * Navigation for callback.
     *
     * @param navigator Istance of I.
     */
    public void setNavigator(I navigator) {
        this.iView = navigator;
    }

}
