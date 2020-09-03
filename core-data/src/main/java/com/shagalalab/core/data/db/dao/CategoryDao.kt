package com.shagalalab.core.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shagalalab.core.data.db.model.CategoryDbModel
import kotlinx.coroutines.flow.Flow

@Dao
internal interface CategoryDao {
    @Query("SELECT * FROM categories")
    fun getCategories(): Flow<List<CategoryDbModel>>

    @Query("SELECT * FROM categories WHERE category_id = :id")
    fun getCategory(id: Long): Flow<CategoryDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: CategoryDbModel)

    @Insert
    suspend fun insertCategories(categories: List<CategoryDbModel>)

    @Delete
    suspend fun deleteCategory(category: CategoryDbModel)
}
