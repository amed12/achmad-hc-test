/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:53 PM
 *
 */

package id.co.homecredit.di

import dagger.Component
import id.co.homecredit.core.di.CoreComponent
import id.co.homecredit.home.HomePageActivity

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)

interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: HomePageActivity)
}
