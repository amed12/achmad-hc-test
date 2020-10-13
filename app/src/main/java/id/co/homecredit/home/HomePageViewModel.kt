/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:22 AM
 *
 */

package id.co.homecredit.home

import androidx.lifecycle.*
import id.co.homecredit.core.data.Resource
import id.co.homecredit.core.domain.model.HomePage
import id.co.homecredit.core.domain.usecase.HomeCreditUseCase
import timber.log.Timber

class HomePageViewModel(homeCreditUseCase: HomeCreditUseCase) : ViewModel() {
    private var homeFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val homePage: LiveData<Resource<List<HomePage>>>
    init {
        Timber.d("Injection view model")
        homePage =  homeFetchingLiveData.switchMap {
            homeCreditUseCase.getHomePage().asLiveData()
        }
    }
    fun getDataHomePage() = homeFetchingLiveData.postValue(true)
}