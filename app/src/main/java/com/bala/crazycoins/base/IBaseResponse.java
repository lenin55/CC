/*
 * @category crazy coins app
 * @copyright Copyright (C) 2019 . All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.bala.crazycoins.base;

import retrofit2.Response;

/**
 * IBaseResponse.java This class is for sending the response from the retrofit to its view It is the
 * generic response model method where the model class can be used based on the need
 *
 * @version 1.0
 */
public interface IBaseResponse {

    /**
     * on response from the api call received
     *
     * @param response   response
     * @param identifier to differentiate the api call
     */
    <T> void onResponseReceived(Response<T> response, String identifier);

    /**
     * on error response received
     *
     * @param error      error message
     * @param identifier identifier
     */
    void onErrorResponse(Throwable error, String identifier);

    /**
     * on failure response received
     *
     * @param failureMessage failure message
     * @param errorCode      error code
     */
    void onFailureCase(String failureMessage, int errorCode);
}
