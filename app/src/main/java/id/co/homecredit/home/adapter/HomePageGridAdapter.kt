/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:57 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:57 PM
 *
 */

package id.co.homecredit.home.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import id.co.homecredit.R
import id.co.homecredit.core.domain.model.HomePage
import kotlinx.android.synthetic.main.item_grid_homepage.view.*

class HomePageGridAdapter :BaseQuickAdapter<HomePage.Item,BaseViewHolder>(R.layout.item_grid_homepage) {
    override fun convert(holder: BaseViewHolder, item: HomePage.Item) {
        holder.itemView.apply {
            Glide.with(this).load(item.productImage).into(iv_grid_homepage)
            tv_grid_homepage?.text = item.productName.replace("Pembiayaan ","")
        }
    }
}