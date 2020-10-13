/*
 * *
 *  * Created by Achmad Fathullah on 10/13/20 9:22 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 10/13/20 9:19 AM
 *
 */

package id.co.homecredit.core.utils

import id.co.homecredit.core.data.source.local.entity.HomePageEntity
import id.co.homecredit.core.domain.model.HomePage

object DataMapper {
    fun mapHomePageToEntities(input: List<HomePage>): List<HomePageEntity> = input.map {
        HomePageEntity(
            items = it.items,
            section = it.section,
            sectionTitle = it.sectionTitle
        )
    }

    fun mapEntitiesHomePageToDomain(input: List<HomePageEntity>): List<HomePage> = input.map {
        HomePage(items = it.items, sectionTitle = it.sectionTitle, section = it.section)
    }
}