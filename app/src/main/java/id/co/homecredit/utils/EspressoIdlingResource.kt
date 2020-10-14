/*
 * *
 *  * Created by Achmad Fathullah on 10/14/20 7:29 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/14/20 1:41 AM
 *
 */

package id.co.homecredit.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private val RESOURCE = "GLOBAL"
    private val countingIdlingResource = CountingIdlingResource(RESOURCE)

    val idlingresource: IdlingResource
        get() = countingIdlingResource

    fun increment() {
        countingIdlingResource.increment()
    }

    fun decrement() {
        countingIdlingResource.decrement()
    }
}