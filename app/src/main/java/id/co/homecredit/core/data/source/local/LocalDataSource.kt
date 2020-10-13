/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:19 AM
 *
 */

package id.co.homecredit.core.data.source.local

import id.co.homecredit.core.data.source.local.entity.HomePageEntity
import id.co.homecredit.core.data.source.local.room.HomeCreditDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val homeCreditDao: HomeCreditDao) {
    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(homeCreditDao: HomeCreditDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(homeCreditDao)
            }
    }

    fun getAllHomePage(): Flow<List<HomePageEntity>> = homeCreditDao.getAllHomePage()

    suspend fun insertHomePage(homePageList: List<HomePageEntity>) =
        homeCreditDao.insertHomePage(homePageList)
}

