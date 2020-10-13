/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:22 AM
 *
 */

package id.co.homecredit.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.co.homecredit.core.domain.usecase.HomeCreditUseCase

class HomePageViewModel(homeCreditUseCase: HomeCreditUseCase) : ViewModel() {
    val homePage = homeCreditUseCase.getHomePage().asLiveData()
}