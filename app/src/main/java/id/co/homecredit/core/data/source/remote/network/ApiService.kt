/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:21 AM
 *
 */

package id.co.homecredit.core.data.source.remote.network

import id.co.homecredit.core.data.source.remote.response.HomePageResponse
import retrofit2.http.GET

interface ApiService {
    @GET("home")
    suspend fun getHomePageList(): HomePageResponse
}