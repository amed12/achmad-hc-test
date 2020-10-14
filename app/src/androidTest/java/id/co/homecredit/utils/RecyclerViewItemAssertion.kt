/*
 * *
 *  * Created by Achmad Fathullah on 10/14/20 7:29 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/14/20 1:45 AM
 *
 */

package id.co.homecredit.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Assert


class RecyclerViewItemAssertion(private var expectedCount: Int) : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }
        val recyclerView = view as RecyclerView
        val adapter = recyclerView.adapter
        Assert.assertNotNull(adapter)
        assertThat(adapter?.itemCount, `is`(expectedCount))
    }
}