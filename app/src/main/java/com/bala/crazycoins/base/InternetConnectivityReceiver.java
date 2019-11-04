/*
 * @category crazy coins app
 * @copyright Copyright (C) 2019 . All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.bala.crazycoins.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * InternetConnectivityReceiver.java
 * <p>
 * This receiver class is for notifying the network change all over the application This extends
 * BroadCastReceiver which will receive the connectivity status on the onReceive method The network
 * change will be notified to the other activities using the connectivityReceiverListener
 * interface.
 */
public class InternetConnectivityReceiver {

    /**
     * constructor
     */
    private InternetConnectivityReceiver() {
        //default constructor
    }

    /**
     * to check the network connectivity status
     *
     * @return connectivity status
     */
    public static boolean isConnected() {
        ConnectivityManager
                connectivityManager = (ConnectivityManager) BaseApplication.getInstance().
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

}