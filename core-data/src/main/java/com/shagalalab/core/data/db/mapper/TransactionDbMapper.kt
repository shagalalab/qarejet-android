package com.shagalalab.core.data.db.mapper

import com.shagalalab.core.data.db.model.FullTransactionModel
import com.shagalalab.core.data.db.model.TransactionDbModel
import com.shagalalab.core.data.model.Transaction

internal object TransactionDbMapper {
    fun mapTransactionListFromDb(dbModels: List<FullTransactionModel>): List<Transaction> {
        return dbModels.map { mapTransactionFromDb(it) }
    }

    fun mapTransactionFromDb(dbModel: FullTransactionModel): Transaction {
        return Transaction(
            dbModel.transaction.id,
            dbModel.transaction.type,
            dbModel.transaction.date,
            AccountDbMapper.mapAccountFromDb(dbModel.account),
            CategoryDbMapper.mapCategoryFromDb(dbModel.category),
            dbModel.transaction.amount,
            dbModel.transaction.memo
        )
    }

    fun mapTransactionsListToDb(models: List<Transaction>): List<TransactionDbModel> {
        return models.map { mapTransactionToDb(it) }
    }

    fun mapTransactionToDb(model: Transaction): TransactionDbModel {
        return TransactionDbModel(
            type = model.type,
            date = model.date,
            accountId = model.account.id,
            categoryId = model.category.id,
            amount = model.amount,
            memo = model.memo
        )
    }
}
