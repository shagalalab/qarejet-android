package com.shagalalab.core.utils.data

import com.shagalalab.core.utils.R

enum class DefaultCategory(val id: Int, val iconRes: Int, colorRes: Int) {
    CATEGORY_EXPENSE_FOOD(1, R.drawable.ic_baseline_local_dining_24, R.color.red),
    CATEGORY_EXPENSE_LEISURE(2, R.drawable.ic_baseline_local_movies_24, R.color.purple),
    CATEGORY_EXPENSE_EDUCATION(3, R.drawable.ic_baseline_school_24, R.color.deep_purple),
    CATEGORY_EXPENSE_SHOPPING(4, R.drawable.ic_baseline_local_grocery_store_24, R.color.indigo),
    CATEGORY_EXPENSE_TRANSPORT(5, R.drawable.ic_baseline_directions_bus_24, R.color.blue),
    CATEGORY_EXPENSE_BILLS(6, R.drawable.ic_baseline_receipt_24, R.color.teal),
    CATEGORY_EXPENSE_HEALTH(7, R.drawable.ic_baseline_local_hospital_24, R.color.green),
    CATEGORY_EXPENSE_VEHICLE(8, R.drawable.ic_baseline_directions_car_24, R.color.lime),
    CATEGORY_EXPENSE_OTHER(9, R.drawable.ic_baseline_monetization_on_24, R.color.amber),
    CATEGORY_INCOME_SALARY(10, R.drawable.ic_baseline_account_balance_wallet_24, R.color.orange),
    CATEGORY_INCOME_GIFT(11, R.drawable.ic_baseline_card_giftcard_24, R.color.deep_orange),
    CATEGORY_INCOME_RENTAL(12, R.drawable.ic_baseline_business_24, R.color.brown),
    CATEGORY_INCOME_SALE(13, R.drawable.ic_baseline_shop_24, R.color.grey),
    CATEGORY_INCOME_INTEREST(14, R.drawable.ic_baseline_insert_chart_24, R.color.blue_grey),
    CATEGORY_INCOME_OTHER(15, R.drawable.ic_baseline_account_balance_24, R.color.light_blue)
}
