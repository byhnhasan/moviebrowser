package com.hsnbyhn.moviebrowser.network

import com.hsnbyhn.moviebrowser.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class EndpointInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val oldUrl = request.url()

        val newUrl = BuildConfig.BASE_URL + oldUrl.toString()
            .replace(oldUrl.scheme() + "://" + oldUrl.host() + "/", "")
        val newRequestBuilder = request.newBuilder().url(newUrl)

        return chain.proceed(newRequestBuilder.build())

    }
}