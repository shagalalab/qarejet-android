package com.shagalalab.feature.splash.data

import android.content.Context
import com.shagalalab.core.data.model.Account
import com.shagalalab.core.data.model.Currency
import com.shagalalab.feature.splash.R

internal object Accounts {
    fun getDefaultAccounts(context: Context) = listOf(
        Account(0, context.getString(R.string.account_cash), Currency.UZBEK_SUM.code),
        Account(1, context.getString(R.string.account_card), Currency.UZBEK_SUM.code)
    )
}
