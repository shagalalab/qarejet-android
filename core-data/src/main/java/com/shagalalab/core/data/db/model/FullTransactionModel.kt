package com.shagalalab.core.data.db.model

import androidx.room.Embedded

internal class FullTransactionModel {
    @Embedded
    lateinit var transaction: TransactionDbModel
    @Embedded
    lateinit var category: CategoryDbModel
    @Embedded
    lateinit var account: AccountDbModel
}
