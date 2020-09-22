package com.shagalalab.feature.splash.data

import android.content.Context
import com.shagalalab.core.data.model.Category
import com.shagalalab.core.data.model.TransactionType
import com.shagalalab.feature.splash.R

internal object Categories {
    private const val CATEGORY_ID_FOOD = 1L
    private const val CATEGORY_ID_LEISURE = 2L
    private const val CATEGORY_ID_EDUCATION = 3L
    private const val CATEGORY_ID_SHOPPING = 4L
    private const val CATEGORY_ID_TRANSPORTATION = 5L
    private const val CATEGORY_ID_BILLS = 6L
    private const val CATEGORY_ID_HEALTH = 7L
    private const val CATEGORY_ID_VEHICLE = 8L
    private const val CATEGORY_ID_OTHER = 9L
    private const val CATEGORY_ID_SALARY = 10L
    private const val CATEGORY_ID_GIFT = 11L
    private const val CATEGORY_ID_RENTAL = 12L
    private const val CATEGORY_ID_SALE = 13L
    private const val CATEGORY_ID_INTEREST = 14L
    private const val CATEGORY_ID_OTHER_INCOME = 15L

    fun getDefaultCategories(context: Context) = getExpenseCategories(context).plus(
        getIncomeCategories(context)
    )

    private fun getExpenseCategories(context: Context) = listOf(
        Category(
            CATEGORY_ID_FOOD,
            context.getString(R.string.category_expense_food),
            TransactionType.EXPENSE.ordinal
        ),
        Category(
            CATEGORY_ID_LEISURE,
            context.getString(R.string.category_expense_leisure),
            TransactionType.EXPENSE.ordinal
        ),
        Category(
            CATEGORY_ID_EDUCATION,
            context.getString(R.string.category_expense_education),
            TransactionType.EXPENSE.ordinal
        ),
        Category(
            CATEGORY_ID_SHOPPING,
            context.getString(R.string.category_expense_shopping),
            TransactionType.EXPENSE.ordinal
        ),
        Category(
            CATEGORY_ID_TRANSPORTATION,
            context.getString(R.string.category_expense_transport),
            TransactionType.EXPENSE.ordinal
        ),
        Category(
            CATEGORY_ID_BILLS,
            context.getString(R.string.category_expense_bills),
            TransactionType.EXPENSE.ordinal
        ),
        Category(
            CATEGORY_ID_HEALTH,
            context.getString(R.string.category_expense_health),
            TransactionType.EXPENSE.ordinal
        ),
        Category(
            CATEGORY_ID_VEHICLE,
            context.getString(R.string.category_expense_vehicle),
            TransactionType.EXPENSE.ordinal
        ),
        Category(
            CATEGORY_ID_OTHER,
            context.getString(R.string.category_expense_other),
            TransactionType.EXPENSE.ordinal
        )
    )

    private fun getIncomeCategories(context: Context) = listOf(
        Category(
            CATEGORY_ID_SALARY,
            context.getString(R.string.category_income_salary),
            TransactionType.INCOME.ordinal
        ),
        Category(
            CATEGORY_ID_GIFT,
            context.getString(R.string.category_income_gift),
            TransactionType.INCOME.ordinal
        ),
        Category(
            CATEGORY_ID_RENTAL,
            context.getString(R.string.category_income_rental),
            TransactionType.INCOME.ordinal
        ),
        Category(
            CATEGORY_ID_SALE,
            context.getString(R.string.category_income_sale),
            TransactionType.INCOME.ordinal
        ),
        Category(
            CATEGORY_ID_INTEREST,
            context.getString(R.string.category_income_interest),
            TransactionType.INCOME.ordinal
        ),
        Category(
            CATEGORY_ID_OTHER_INCOME,
            context.getString(R.string.category_income_other),
            TransactionType.INCOME.ordinal
        )
    )
}
