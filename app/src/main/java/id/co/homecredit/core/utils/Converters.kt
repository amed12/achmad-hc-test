/*
 * *
 *  * Created by Achmad Fathullah on 10/14/20 12:13 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/14/20 12:03 AM
 *
 */

package id.co.homecredit.core.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import id.co.homecredit.core.domain.model.HomePage

class Converters {

    @TypeConverter
    fun homePageToJson(value: List<HomePage.Item>?): String = Gson().toJson(value)

    @TypeConverter
    fun homePageJsonToList(value: String) =
        Gson().fromJson(value, Array<HomePage.Item>::class.java).toList()
}