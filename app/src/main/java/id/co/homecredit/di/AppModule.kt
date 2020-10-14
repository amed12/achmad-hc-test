/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 11:09 AM
 *
 */

package id.co.homecredit.di

import dagger.Binds
import dagger.Module
import id.co.homecredit.core.domain.usecase.HomeCreditInteractor
import id.co.homecredit.core.domain.usecase.HomeCreditUseCase

@Module
abstract class AppModule {
    @Binds
    abstract fun provideTourismUseCase(homeCreditInteractor: HomeCreditInteractor): HomeCreditUseCase
}