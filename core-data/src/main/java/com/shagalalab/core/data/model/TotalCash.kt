package com.shagalalab.core.data.model

data class TotalCash(
    val incomeAmount: Double,
    val expenseAmount: Double,
    val accountList: List<AccountWithAmount>,
    val lastTransactions: List<Transaction>
)
