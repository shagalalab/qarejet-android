package com.shagalalab.core.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shagalalab.core.data.db.model.FullTransactionModel
import com.shagalalab.core.data.db.model.TransactionDbModel
import kotlinx.coroutines.flow.Flow

@Dao
internal interface TransactionDao {
    @Query(
        "SELECT transactions.*, accounts.*, categories.*\n" +
            "FROM transactions\n" +
            "INNER JOIN accounts ON transactions.acc_id = accounts.account_id\n" +
            "INNER JOIN categories ON transactions.cat_id = categories.category_id"
    )
    fun getTransactions(): Flow<List<FullTransactionModel>>

    @Query(
        "SELECT transactions.*, accounts.*, categories.*\n" +
            "FROM transactions\n" +
            "INNER JOIN accounts ON transactions.acc_id = accounts.account_id\n" +
            "INNER JOIN categories ON transactions.cat_id = categories.category_id\n" +
            "WHERE date > :from AND date < :to AND categories.category_id = :categoryId"
    )
    fun getTransactionsWithinDateByCategory(from: Long, to: Long, categoryId: Long): Flow<List<FullTransactionModel>>

    @Query(
        "SELECT transactions.*, accounts.*, categories.*\n" +
            "FROM transactions\n" +
            "INNER JOIN accounts ON transactions.acc_id = accounts.account_id\n" +
            "INNER JOIN categories ON transactions.cat_id = categories.category_id\n" +
            "WHERE date > :from AND date < :to AND categories.category_type = :categoryType"
    )
    fun getTransactionsWithinDateByType(from: Long, to: Long, categoryType: Int): Flow<List<FullTransactionModel>>

    @Query(
        "SELECT transactions.*, accounts.*, categories.*\n" +
            "FROM transactions\n" +
            "INNER JOIN accounts ON transactions.acc_id = accounts.account_id\n" +
            "INNER JOIN categories ON transactions.cat_id = categories.category_id\n" +
            "WHERE id = :id"
    )
    fun getTransaction(id: Long): Flow<FullTransactionModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: TransactionDbModel)

    @Insert
    suspend fun insertTransactions(transactions: List<TransactionDbModel>)

    @Delete
    suspend fun deleteTransaction(transaction: TransactionDbModel)
}
