/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 8:56 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 8:56 PM
 *
 */

package id.co.homecredit.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import id.co.homecredit.MyApplication
import id.co.homecredit.R
import id.co.homecredit.core.data.Resource
import id.co.homecredit.core.ui.ViewModelFactory
import id.co.homecredit.home.adapter.HomePageGridAdapter
import id.co.homecredit.home.adapter.HomePageListAdapter
import id.co.homecredit.utils.dialog.LoadingDialog
import id.co.homecredit.utils.extension.showToast
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.view_failed.view.*
import kotlinx.android.synthetic.main.view_header.view.*
import java.lang.Exception
import javax.inject.Inject


class HomePageActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    private val loadingDialog by lazy { LoadingDialog(this) }
    private val adapterGrid by lazy { HomePageGridAdapter() }
    private val adapterList by lazy { HomePageListAdapter() }
    private val homePageViewModel: HomePageViewModel by lazy {
        ViewModelProvider(this, factory)[HomePageViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).appComponent.inject(this)
        setContentView(R.layout.activity_home_page)
        rv_grid_homepage.adapter = adapterGrid
        rv_list_homepage.adapter = adapterList
        homePageViewModel.getDataHomePage()
        homePageViewModel.homePage.observe(this, { homePage ->
            if (homePage != null) {
                when (homePage) {
                    is Resource.Loading -> {
                        loadingDialog.show(true)
                    }
                    is Resource.Success -> {
                        loadingDialog.show(false)
                        homePage.data?.map {
                            if (it.sectionTitle.isEmpty()) {
                                with(adapterGrid) {
                                    setList(it.items)
                                    setOnItemClickListener { _, _, position ->
                                        try {
                                            startActivity(
                                                Intent(
                                                    Intent.ACTION_VIEW,
                                                    Uri.parse(it.items[position].link)
                                                )
                                            )
                                        }catch (e:Exception){
                                            showToast(e.toString())
                                        }
                                    }
                                }
                            } else {
                                with(adapterList){
                                    setList(it.items)
                                    setHeaderView(getHeaderView(rv_list_homepage,it.sectionTitle))
                                    setOnItemClickListener { _, _, position ->
                                        try {
                                            startActivity(
                                                Intent(
                                                    Intent.ACTION_VIEW,
                                                    Uri.parse(it.items[position].link)
                                                )
                                            )
                                        }catch (e:Exception){
                                            showToast(e.toString())
                                        }
                                    }
                                }
                            }

                        }
                    }
                    is Resource.Error -> {
                        loadingDialog.show(false)
                        adapterGrid.setEmptyView(getErrorGridView(rv_grid_homepage,homePage.message.toString()))
                        adapterList.setEmptyView(getErrorGridView(rv_list_homepage,homePage.message.toString()))
                    }
                }
            }


        })
    }

    private fun getErrorGridView(rv:RecyclerView,errorMessage:String): View {
        val errorView: View = layoutInflater.inflate(R.layout.view_failed, rv, false)
        errorView.apply {
            tv_error_item?.text = errorMessage
            setOnClickListener {
                homePageViewModel.getDataHomePage()
            }
        }
        return errorView
    }

    private fun getHeaderView(rv:RecyclerView,headerTitle:String): View {
        val headerView: View = layoutInflater.inflate(R.layout.view_header, rv, false)
        headerView.apply {
            tv_header?.text = headerTitle
        }
        return headerView
    }

}