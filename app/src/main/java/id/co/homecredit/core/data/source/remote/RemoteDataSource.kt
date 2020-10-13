/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:19 AM
 *
 */

package id.co.homecredit.core.data.source.remote

import id.co.homecredit.core.data.source.remote.network.ApiResponse
import id.co.homecredit.core.data.source.remote.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    suspend fun getAllHomePage() = flow {
        try {
            val response = apiService.getHomePageList()
            val dataArray = response.dataHomePage
            if (dataArray.isNotEmpty()) {
                emit(ApiResponse.Success(response.dataHomePage))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.toString()))
            Timber.e(e.toString())
        }
    }.flowOn(Dispatchers.IO)
}
