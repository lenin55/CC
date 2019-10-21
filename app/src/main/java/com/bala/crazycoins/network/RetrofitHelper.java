/*
 * @category crazy coins app
 * @copyright Copyright (C) 2019 . All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.bala.crazycoins.network;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Helper class that facilitates network calls using retrofit. This class manages the creation of
 * Retrofit instance while also maintaining a singleton pattern for the same. Methods are available
 * to create implementations for web service interfaces.
 * <p>
 * The constructor {@link #RetrofitHelper()} creates the implementation for the interface parameter
 * passed, and keeps a reference to it, within this class and returns the reference, for any calls
 * to the {@link #getAPI()} method.
 * <p>
 *
 * @version 1.0
 */

public class RetrofitHelper {

    /**
     * The static reference to the retrofit instance created. Once created, will have a valid
     * reference until the application is terminated, unless explicitly set to null.
     */
    private static Retrofit mRetrofit = null;

    /**
     * The reference to the service implementation created by {@link #RetrofitHelper()}()}.
     */
    private static RetrofitHelper mHelper = null;

    /**
     * API request url's
     */
    private API mApiImpl;

    /**
     * default constructor
     */
    private RetrofitHelper() {
        mApiImpl = getRetrofit().create(API.class);
    }

    /**
     * Constructs and returns the retrofit instance, and maintains a singleton pattern for the
     * retrofit instance created.
     * <p>
     * The same retrofit object can be used across the entire application.
     *
     * @return Returns the singleton instance of retrofit.
     */
    private static Retrofit getRetrofit() {
        if (null == mRetrofit) {

            int requestTimeout = 60;
            OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(requestTimeout, TimeUnit.SECONDS)
                    .readTimeout(requestTimeout, TimeUnit.SECONDS)
                    .writeTimeout(requestTimeout, TimeUnit.SECONDS);

            Interceptor headerInterceptor = chain -> {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder();
                Request request = requestBuilder.build();
                return chain.proceed(request);
            };

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(interceptor);
            httpClient.addInterceptor(headerInterceptor);

            mRetrofit = new Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return mRetrofit;
    }

    /**
     * Helper method to maintain a singleton instance of this class.
     *
     * @return The existing instance of this class if present. Otherwise, it creates a new instance
     * and returns that.
     */
    public static RetrofitHelper getInstance() {
        if (mHelper == null) {
            mHelper = new RetrofitHelper();
        }

        return mHelper;
    }

    /**
     * retrofit helper instance
     *
     * @param refresh refresh identifier
     * @return instance of retrofit helper
     */
    public static RetrofitHelper getInstance(String refresh) {
        if (refresh.isEmpty()) {
            if (mHelper == null)
                mHelper = new RetrofitHelper();
            return mHelper;
        } else
            return null;
    }

    /**
     * Returns a reference to implementation for the interface parameter passed.
     *
     * @return Implementation reference of the interface passed.
     */
    public API getAPI() {
        return mApiImpl;
    }
}
