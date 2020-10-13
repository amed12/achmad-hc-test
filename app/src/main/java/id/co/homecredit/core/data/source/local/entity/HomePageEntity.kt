/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:21 AM
 *
 */

package id.co.homecredit.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import id.co.homecredit.core.domain.model.HomePage

@Entity(tableName = "homepage")
data class HomePageEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "section")
    var section: String = "", // products

    @ColumnInfo(name = "list_item")
    var items: List<HomePage.Item> = listOf(),

    @ColumnInfo(name = "section_title")
    var sectionTitle: String = "" // Our Blog
)