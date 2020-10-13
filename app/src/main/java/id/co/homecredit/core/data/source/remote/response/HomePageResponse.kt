/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:19 AM
 *
 */

package id.co.homecredit.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
import id.co.homecredit.core.domain.model.HomePage

data class HomePageResponse(
    @field:SerializedName("data")
    val dataHomePage: List<HomePage>
)