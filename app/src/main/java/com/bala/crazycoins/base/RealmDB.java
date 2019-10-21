/*
 * @category crazy coins app
 * @copyright Copyright (C) 2019 . All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.bala.crazycoins.base;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * This class RealmDb.java is to create the realm db for the first time app get
 *
 * @author suryamurugan68@gmail.com
 * @version 1.0
 */
public class RealmDB {

    /**
     * Application context
     */
    private Context context;

    /**
     * Constructor
     *
     * @param context application context
     */
    public RealmDB(Context context) {
        this.context = context;
    }

    /**
     * To create a realm db if the db does not exist..
     */
    public void setUpRealm() {
        Realm.init(context);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("car.db")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}