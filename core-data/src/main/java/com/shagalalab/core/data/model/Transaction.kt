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

enum class Currency(val code: String) {
    UZBEK_SUM("UZS"),
    US_DOLLAR("USD"),
    RUSSIAN_ROUBLE("RUB"),
}
