/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:19 AM
 *
 */

package id.co.homecredit.core.di

import android.content.Context
import id.co.homecredit.core.data.HomeCreditRepository
import id.co.homecredit.core.data.source.local.LocalDataSource
import id.co.homecredit.core.data.source.local.room.HomeCreditDatabase
import id.co.homecredit.core.data.source.remote.RemoteDataSource
import id.co.homecredit.core.data.source.remote.network.ApiConfig
import id.co.homecredit.core.domain.repository.IRepositoryHc
import id.co.homecredit.core.domain.usecase.HomeCreditInteractor
import id.co.homecredit.core.domain.usecase.HomeCreditUseCase
import id.co.homecredit.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): IRepositoryHc {
        val database = HomeCreditDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.homePageDao())
        val appExecutors = AppExecutors()

        return HomeCreditRepository.getInstance(
            remoteDataSource = remoteDataSource,
            appExecutors = appExecutors,
            localDataSource = localDataSource
        )

    }

    fun provideHomeCreditUseCase(context: Context): HomeCreditUseCase = HomeCreditInteractor(
        provideRepository(context)
    )
}