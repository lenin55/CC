/*
 * @category crazy coins app
 * @copyright Copyright (C) 2019 . All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.bala.crazycoins.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.bala.crazycoins.R;


public class BaseApplication extends Application {

    private static BaseApplication mApp;

    /**
     * this method returns the udaan application instance;
     *
     * @return application instance
     */
    public static BaseApplication getInstance() {
        return mApp;
    }

    /**
     * set the app instance
     *
     * @param instance of car application
     */
    private static void setInstance(BaseApplication instance) {
        mApp = instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
        new RealmDB(getApplicationContext()).setUpRealm();
        initSharedPreferences();
    }

    /**
     * initialise the shared preference to store and share the values across the application
     */
    private void initSharedPreferences() {
        SharedPreferences mPreferences = getSharedPreferences(getString(R.string.app_name),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mPreferences.edit();
        mEditor.apply();
    }
}
