/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:21 AM
 *
 */

package id.co.homecredit.core.domain.repository

import id.co.homecredit.core.data.Resource
import id.co.homecredit.core.domain.model.HomePage
import kotlinx.coroutines.flow.Flow

interface IRepositoryHc {
    fun getHomePage(): Flow<Resource<List<HomePage>>>
}