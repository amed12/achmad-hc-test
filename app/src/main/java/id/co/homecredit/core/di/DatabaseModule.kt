/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:53 PM
 *
 */

package id.co.homecredit.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import id.co.homecredit.core.data.source.local.room.HomeCreditDao
import id.co.homecredit.core.data.source.local.room.HomeCreditDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): HomeCreditDatabase = Room.databaseBuilder(
        context.applicationContext,
        HomeCreditDatabase::class.java,
        "HomeCredit.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideHomeCreditDao(database: HomeCreditDatabase): HomeCreditDao = database.homePageDao()
}