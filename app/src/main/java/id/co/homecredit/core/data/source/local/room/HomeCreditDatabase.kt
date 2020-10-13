/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:21 AM
 *
 */

package id.co.homecredit.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.co.homecredit.core.data.source.local.entity.HomePageEntity
import id.co.homecredit.core.utils.Converters

@Database(entities = [HomePageEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class HomeCreditDatabase : RoomDatabase() {
    abstract fun homePageDao(): HomeCreditDao

    companion object {
        @Volatile
        private var INSTANCE: HomeCreditDatabase? = null

        fun getInstance(context: Context): HomeCreditDatabase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                HomeCreditDatabase::class.java,
                "HomeCredit.db"
            ).fallbackToDestructiveMigration().build()
            INSTANCE = instance
            instance
        }
    }
}