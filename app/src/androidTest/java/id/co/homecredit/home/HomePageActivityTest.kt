/*
 * *
 *  * Created by Achmad Fathullah on 10/14/20 7:29 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/14/20 7:29 AM
 *
 */

package id.co.homecredit.home

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import id.co.homecredit.R
import id.co.homecredit.utils.EspressoIdlingResource
import id.co.homecredit.utils.RecyclerViewItemAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomePageActivityTest {
    @get:Rule
    var activityTest = ActivityTestRule(HomePageActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingresource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingresource)
    }

    @Test
    fun loadHomePageGrid() {
        Espresso.onView(withId(R.id.rv_grid_homepage))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_grid_homepage)).check(RecyclerViewItemAssertion(6))
    }
}