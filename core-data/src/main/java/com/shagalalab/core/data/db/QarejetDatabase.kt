package com.shagalalab.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shagalalab.core.data.db.dao.AccountDao
import com.shagalalab.core.data.db.dao.CategoryDao
import com.shagalalab.core.data.db.dao.TransactionDao
import com.shagalalab.core.data.db.model.AccountDbModel
import com.shagalalab.core.data.db.model.CategoryDbModel
import com.shagalalab.core.data.db.model.TransactionDbModel

@Database(
    entities = [AccountDbModel::class, CategoryDbModel::class, TransactionDbModel::class],
    version = 1,
    exportSchema = false
)
internal abstract class QarejetDatabase : RoomDatabase() {
    internal abstract fun accountDao(): AccountDao
    internal abstract fun categoryDao(): CategoryDao
    internal abstract fun transactionDao(): TransactionDao
}
