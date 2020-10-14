/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:53 PM
 *
 */

package id.co.homecredit.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.co.homecredit.core.data.source.local.entity.HomePageEntity
import id.co.homecredit.core.utils.Converters

@Database(entities = [HomePageEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class HomeCreditDatabase : RoomDatabase() {
    abstract fun homePageDao(): HomeCreditDao
}