/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 8:56 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 7:42 PM
 *
 */

package id.co.homecredit.core.data

import id.co.homecredit.core.data.source.local.LocalDataSource
import id.co.homecredit.core.data.source.remote.RemoteDataSource
import id.co.homecredit.core.data.source.remote.network.ApiResponse
import id.co.homecredit.core.domain.model.HomePage
import id.co.homecredit.core.domain.repository.IHCRepository
import id.co.homecredit.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeCreditRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IHCRepository {

    override fun getHomePage(): Flow<Resource<List<HomePage>>> =
        object : NetworkBoundResource<List<HomePage>, List<HomePage>>() {
            override fun loadFromDB(): Flow<List<HomePage>> {
                return localDataSource.getAllHomePage().map {
                    DataMapper.mapEntitiesHomePageToDomain(it)
                }
            }

            override fun shouldFetch(data: List<HomePage>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<HomePage>>> =
                remoteDataSource.getAllHomePage()

            override suspend fun saveCallResult(data: List<HomePage>) {
                val homePageList = DataMapper.mapHomePageToEntities(data)
                localDataSource.insertHomePage(homePageList)
            }

        }.asFlow()


}