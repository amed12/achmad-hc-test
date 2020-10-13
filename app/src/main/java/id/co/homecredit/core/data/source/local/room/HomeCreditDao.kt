/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:21 AM
 *
 */

package id.co.homecredit.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.co.homecredit.core.data.source.local.entity.HomePageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HomeCreditDao {
    @Query("SELECT * FROM homepage")
    fun getAllHomePage(): Flow<List<HomePageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHomePage(homePage: List<HomePageEntity>)
}