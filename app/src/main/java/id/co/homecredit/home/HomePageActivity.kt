/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 8:56 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 8:56 PM
 *
 */

package id.co.homecredit.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.co.homecredit.MyApplication
import id.co.homecredit.R
import id.co.homecredit.core.data.Resource
import id.co.homecredit.core.ui.ViewModelFactory
import id.co.homecredit.utils.dialog.LoadingDialog
import id.co.homecredit.utils.extension.showToast
import javax.inject.Inject

class HomePageActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    private val loadingDialog by lazy { LoadingDialog(this) }
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
                    is Resource.Loading -> {
                        loadingDialog.show(true)
                    }
                    is Resource.Success -> {
                        loadingDialog.show(false)
                    }
                    is Resource.Error -> {
                        loadingDialog.show(false)
                        showToast("selesai ${homePage.message}")
                    }
                }
            }


        })
    }
}