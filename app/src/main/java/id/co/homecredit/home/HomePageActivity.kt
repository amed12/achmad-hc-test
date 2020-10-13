/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:53 PM
 *
 */

package id.co.homecredit.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.co.homecredit.MyApplication
import id.co.homecredit.R
import id.co.homecredit.core.data.Resource
import id.co.homecredit.core.ui.ViewModelFactory
import javax.inject.Inject

class HomePageActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val homePageViewModel: HomePageViewModel by lazy {
        ViewModelProvider(this, factory)[HomePageViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).appComponent.inject(this)
        setContentView(R.layout.activity_home_page)
        homePageViewModel.homePage.observe(this, { homePage ->
            if (homePage != null) {
                when (homePage) {
                    is Resource.Loading -> Toast.makeText(this, "loading", Toast.LENGTH_SHORT)
                        .show()
                    is Resource.Success -> {
                        Toast.makeText(
                            this,
                            "selesai ${homePage.data?.get(0)?.section}",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                    is Resource.Error -> {
                        Toast.makeText(
                            this,
                            "selesai ${homePage.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }


        })
    }
}