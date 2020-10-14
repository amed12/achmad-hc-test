/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:22 AM
 *
 */

package id.co.homecredit.core.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HomePage(
    val items: List<Item> = listOf(),
    val section: String = "", // products
    @SerializedName("section_title")
    val sectionTitle: String = "" // Our Blog
) {
    @Keep
    data class Item(
        val link: String = "", // https://www.homecredit.co.id/kredit-hp
        @SerializedName("product_image")
        val productImage: String = "", // https://img.icons8.com/color/phone
        @SerializedName("product_name")
        val productName: String = "" // Pembiayaan Handphone
        , // https://www.homecredit.co.id/kredit-hp
        @SerializedName("article_title")
        val articleTitle: String = "", // https://img.icons8.com/color/phone
        @SerializedName("article_image")
        val articleImage: String = "" // Pembiayaan Handphone
    )
}