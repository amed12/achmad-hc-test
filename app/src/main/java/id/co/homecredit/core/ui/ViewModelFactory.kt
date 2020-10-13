/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:45 PM
 *
 */

package id.co.homecredit.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.co.homecredit.core.domain.usecase.HomeCreditUseCase
import id.co.homecredit.di.AppScope
import id.co.homecredit.home.HomePageViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val homeCreditUseCase: HomeCreditUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomePageViewModel::class.java) -> {
                HomePageViewModel(homeCreditUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}