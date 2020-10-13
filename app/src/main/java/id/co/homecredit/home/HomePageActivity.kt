/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:21 AM
 *
 */

package id.co.homecredit.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.co.homecredit.R
import id.co.homecredit.core.data.Resource
import id.co.homecredit.core.ui.ViewModelFactory

class HomePageActivity : AppCompatActivity() {
    private lateinit var homePageViewModel: HomePageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val factory = ViewModelFactory.getInstance(this)
        homePageViewModel = ViewModelProvider(this, factory)[HomePageViewModel::class.java]
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