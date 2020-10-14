/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:53 PM
 *
 */

package id.co.homecredit.core.di

import dagger.Binds
import dagger.Module
import id.co.homecredit.core.data.HomeCreditRepository
import id.co.homecredit.core.domain.repository.IHCRepository

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(homeCreditRepository: HomeCreditRepository): IHCRepository
}