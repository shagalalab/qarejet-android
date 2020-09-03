package com.shagalalab.core.data.repository

import com.shagalalab.core.data.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategories(): Flow<List<Category>>
    fun getCategory(id: Long): Flow<Category>
    suspend fun addCategory(category: Category)
    suspend fun addCategories(categories: List<Category>)
}
