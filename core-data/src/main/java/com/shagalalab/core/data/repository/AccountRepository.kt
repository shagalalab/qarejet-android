package com.shagalalab.core.data.repository

import com.shagalalab.core.data.model.Account
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    fun getAllAccounts(): Flow<List<Account>>
    fun getAccount(id: Long): Flow<Account>
    suspend fun addAccount(account: Account)
    suspend fun addAccounts(accounts: List<Account>)
}
