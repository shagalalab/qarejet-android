package com.shagalalab.core.data.db.mapper

import com.shagalalab.core.data.db.model.CategoryDbModel
import com.shagalalab.core.data.model.Category

internal object CategoryDbMapper {
    fun mapCategoryListFromDb(dbModels: List<CategoryDbModel>): List<Category> {
        return dbModels.map { mapCategoryFromDb(it) }
    }

    fun mapCategoryFromDb(dbModel: CategoryDbModel): Category {
        return Category(dbModel.id, dbModel.title, dbModel.icon, dbModel.color, dbModel.type)
    }

    fun mapCategoriesListToDb(models: List<Category>): List<CategoryDbModel> {
        return models.map { mapCategoryToDb(it) }
    }

    fun mapCategoryToDb(model: Category): CategoryDbModel {
        return CategoryDbModel(
            title = model.title,
            icon = model.icon,
            color = model.color,
            type = model.type
        )
    }
}
