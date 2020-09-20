package com.shagalalab.feature.splash.data

import android.content.Context
import com.shagalalab.core.data.model.Category
import com.shagalalab.core.data.model.TransactionType
import com.shagalalab.feature.splash.R

internal object Categories {
    fun getDefaultCategories(context: Context) = listOf(
        Category(1, context.getString(R.string.category_expense_food), TransactionType.EXPENSE.ordinal),
        Category(2, context.getString(R.string.category_expense_leisure), TransactionType.EXPENSE.ordinal),
        Category(3, context.getString(R.string.category_expense_education), TransactionType.EXPENSE.ordinal),
        Category(4, context.getString(R.string.category_expense_shopping), TransactionType.EXPENSE.ordinal),
        Category(5, context.getString(R.string.category_expense_transport), TransactionType.EXPENSE.ordinal),
        Category(6, context.getString(R.string.category_expense_bills), TransactionType.EXPENSE.ordinal),
        Category(7, context.getString(R.string.category_expense_health), TransactionType.EXPENSE.ordinal),
        Category(8, context.getString(R.string.category_expense_vehicle), TransactionType.EXPENSE.ordinal),
        Category(9, context.getString(R.string.category_expense_other), TransactionType.EXPENSE.ordinal),
        Category(10, context.getString(R.string.category_income_salary), TransactionType.INCOME.ordinal),
        Category(11, context.getString(R.string.category_income_gift), TransactionType.INCOME.ordinal),
        Category(12, context.getString(R.string.category_income_rental), TransactionType.INCOME.ordinal),
        Category(13, context.getString(R.string.category_income_sale), TransactionType.INCOME.ordinal),
        Category(14, context.getString(R.string.category_income_interest), TransactionType.INCOME.ordinal),
        Category(15, context.getString(R.string.category_income_other), TransactionType.INCOME.ordinal)
    )
}
