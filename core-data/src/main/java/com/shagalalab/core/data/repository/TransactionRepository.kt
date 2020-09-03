package com.shagalalab.core.data.repository

import com.shagalalab.core.data.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    fun getAllTransactions(): Flow<List<Transaction>>
    fun getTransactionsWithinDateByType(from: Long, to: Long, categoryType: Int): Flow<List<Transaction>>
    fun getTransactionsWithinDateByCategory(from: Long, to: Long, categoryId: Long): Flow<List<Transaction>>
    fun getTransaction(id: Long): Flow<Transaction>
    suspend fun addTransaction(transaction: Transaction)
    suspend fun addTransactions(transactions: List<Transaction>)
}
