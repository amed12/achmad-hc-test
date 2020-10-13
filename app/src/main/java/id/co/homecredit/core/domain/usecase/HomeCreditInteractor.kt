/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 12:30 PM
 *
 */

package id.co.homecredit.core.domain.usecase

import id.co.homecredit.core.data.Resource
import id.co.homecredit.core.domain.model.HomePage
import id.co.homecredit.core.domain.repository.IHCRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Suppress("SpellCheckingInspection")
class HomeCreditInteractor @Inject constructor(private val homeCreditRepository: IHCRepository) :
    HomeCreditUseCase {
    override fun getHomePage(): Flow<Resource<List<HomePage>>> = homeCreditRepository.getHomePage()

}