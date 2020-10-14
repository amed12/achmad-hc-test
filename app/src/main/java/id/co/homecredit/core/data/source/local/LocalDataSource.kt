/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:45 PM
 *
 */

package id.co.homecredit.core.data.source.local

import id.co.homecredit.core.data.source.local.entity.HomePageEntity
import id.co.homecredit.core.data.source.local.room.HomeCreditDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val homeCreditDao: HomeCreditDao) {

    fun getAllHomePage(): Flow<List<HomePageEntity>> = homeCreditDao.getAllHomePage()

    suspend fun insertHomePage(homePageList: List<HomePageEntity>) =
        homeCreditDao.insertHomePage(homePageList)
}

