/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:21 AM
 *
 */

package id.co.homecredit.core.data

import id.co.homecredit.core.data.source.local.LocalDataSource
import id.co.homecredit.core.data.source.remote.RemoteDataSource
import id.co.homecredit.core.data.source.remote.network.ApiResponse
import id.co.homecredit.core.domain.model.HomePage
import id.co.homecredit.core.domain.repository.IRepositoryHc
import id.co.homecredit.core.utils.AppExecutors
import id.co.homecredit.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeCreditRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IRepositoryHc {
    companion object {
        @Volatile
        private var instance: HomeCreditRepository? = null

        fun getInstance(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ) = instance ?: synchronized(this) {
            instance ?: HomeCreditRepository(remoteDataSource, localDataSource, appExecutors)
        }
    }

    override fun getHomePage(): Flow<Resource<List<HomePage>>> =
        object : NetworkBoundResource<List<HomePage>, List<HomePage>>() {
            override fun loadFromDB(): Flow<List<HomePage>> {
                return localDataSource.getAllHomePage().map {
                    DataMapper.mapEntitiesHomePageToDomain(it)
                }
            }

            override fun shouldFetch(data: List<HomePage>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<HomePage>>> =
                remoteDataSource.getAllHomePage()

            override suspend fun saveCallResult(data: List<HomePage>) {
                val homePageList = DataMapper.mapHomePageToEntities(data)
                localDataSource.insertHomePage(homePageList)
            }

        }.asFlow()


}