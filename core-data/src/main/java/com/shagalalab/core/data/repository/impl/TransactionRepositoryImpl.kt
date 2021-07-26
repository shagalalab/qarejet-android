package com.shagalalab.core.data.repository.impl

import com.shagalalab.core.data.db.QarejetDatabase
import com.shagalalab.core.data.db.mapper.TransactionDbMapper
import com.shagalalab.core.data.model.Account
import com.shagalalab.core.data.model.Category
import com.shagalalab.core.data.model.Transaction
import com.shagalalab.core.data.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class TransactionRepositoryImpl(private val database: QarejetDatabase) :
    TransactionRepository {

    override fun getTransaction(id: Long): Flow<Transaction> {
        return database
            .transactionDao()
            .getTransaction(id)
            .map(TransactionDbMapper::mapTransactionFromDb)
    }

    override fun getAllTransactions(): Flow<List<Transaction>> {
        return database
            .transactionDao()
            .getTransactions()
            .map(TransactionDbMapper::mapTransactionListFromDb)
    }

    override fun getTransactionsWithinDateByType(
        from: Long,
        to: Long,
        categoryType: Int
    ): Flow<List<Transaction>> {
        val list = mutableListOf<Transaction>()
        for (i in 1..10) {
            val transaction = Transaction(
                i.toLong(),
                1,
                25,
                Account(i.toLong(), "accountTitle", "usd", "sign"),
                Category(i.toLong(), "catTitle", 1),
                1.25,
                "memo"
            )
            list.add(i, transaction)
        }
        return flow {
            emit(list)
        }
    }

    fun getMockTransaction(): MutableList<Transaction> {
        val list = mutableListOf<Transaction>()
        for (i in 1..10) {
            val transaction = Transaction(
                i.toLong(),
                1,
                25,
                Account(i.toLong(), "accountTitle", "usd", "sign"),
                Category(i.toLong(), "catTitle", 1),
                1.25,
                "memo"
            )
            list.add(i, transaction)
        }
        return list
    }

    override fun getTransactionsWithinDateByCategory(
        from: Long,
        to: Long,
        categoryId: Long
    ): Flow<List<Transaction>> {
        return database
            .transactionDao()
            .getTransactionsWithinDateByCategory(from, to, categoryId)
            .map(TransactionDbMapper::mapTransactionListFromDb)
    }

    override suspend fun addTransaction(transaction: Transaction) {
        database
            .transactionDao()
            .insertTransaction(TransactionDbMapper.mapTransactionToDb(transaction))
    }

    override suspend fun addTransactions(transactions: List<Transaction>) {
        database
            .transactionDao()
            .insertTransactions(TransactionDbMapper.mapTransactionsListToDb(transactions))
    }
}
