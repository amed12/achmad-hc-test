/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:19 AM
 *
 */

package id.co.homecredit.core.domain.usecase

import id.co.homecredit.core.data.Resource
import id.co.homecredit.core.domain.model.HomePage
import kotlinx.coroutines.flow.Flow

interface HomeCreditUseCase {
    fun getHomePage(): Flow<Resource<List<HomePage>>>
}