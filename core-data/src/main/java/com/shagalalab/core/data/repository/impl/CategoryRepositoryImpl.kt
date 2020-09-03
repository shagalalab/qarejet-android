package com.shagalalab.core.data.repository.impl

import com.shagalalab.core.data.db.QarejetDatabase
import com.shagalalab.core.data.db.mapper.CategoryDbMapper
import com.shagalalab.core.data.model.Category
import com.shagalalab.core.data.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class CategoryRepositoryImpl(private val database: QarejetDatabase) : CategoryRepository {
    override fun getAllCategories(): Flow<List<Category>> {
        return database
            .categoryDao()
            .getCategories()
            .map(CategoryDbMapper::mapCategoryListFromDb)
    }

    override fun getCategory(id: Long): Flow<Category> {
        return database
            .categoryDao()
            .getCategory(id)
            .map(CategoryDbMapper::mapCategoryFromDb)
    }

    override suspend fun addCategory(category: Category) {
        database
            .categoryDao()
            .insertCategory(CategoryDbMapper.mapCategoryToDb(category))
    }

    override suspend fun addCategories(categories: List<Category>) {
        database
            .categoryDao()
            .insertCategories(CategoryDbMapper.mapCategoriesListToDb(categories))
    }
}
