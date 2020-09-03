package com.shagalalab.core.data.model

data class Transaction(
    val id: Long,
    val type: Int,
    val date: Long,
    val account: Account,
    val category: Category,
    val amount: Double,
    val memo: String
)

enum class TransactionType {
    INCOME,
    EXPENSE
}
