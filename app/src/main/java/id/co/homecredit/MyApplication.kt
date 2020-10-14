/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:53 PM
 *
 */

package id.co.homecredit

import android.app.Application
import androidx.multidex.BuildConfig
import id.co.homecredit.core.di.CoreComponent
import id.co.homecredit.core.di.DaggerCoreComponent
import id.co.homecredit.di.AppComponent
import id.co.homecredit.di.DaggerAppComponent
import timber.log.Timber

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }

}