/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:21 AM
 *
 */

package id.co.homecredit.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.co.homecredit.core.di.Injection
import id.co.homecredit.core.domain.usecase.HomeCreditUseCase
import id.co.homecredit.home.HomePageViewModel

class ViewModelFactory private constructor(private val homeCreditUseCase: HomeCreditUseCase) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(
                this
            ) {
                instance ?: ViewModelFactory(Injection.provideHomeCreditUseCase(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomePageViewModel::class.java) -> {
                HomePageViewModel(homeCreditUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}