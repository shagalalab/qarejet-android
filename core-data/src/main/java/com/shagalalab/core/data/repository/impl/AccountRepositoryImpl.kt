package com.shagalalab.core.data.repository.impl

import com.shagalalab.core.data.db.QarejetDatabase
import com.shagalalab.core.data.db.mapper.AccountDbMapper
import com.shagalalab.core.data.model.Account
import com.shagalalab.core.data.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class AccountRepositoryImpl(private val database: QarejetDatabase) : AccountRepository {
    override fun getAllAccounts(): Flow<List<Account>> {
        return database
            .accountDao()
            .getAccounts()
            .map(AccountDbMapper::mapAccountsListFromDb)
    }

    override fun getAccount(id: Long): Flow<Account> {
        return database
            .accountDao()
            .getAccount(id)
            .map(AccountDbMapper::mapAccountFromDb)
    }

    override suspend fun addAccount(account: Account) {
        database
            .accountDao()
            .insertAccount(AccountDbMapper.mapAccountToDb(account))
    }

    override suspend fun addAccounts(accounts: List<Account>) {
        database
            .accountDao()
            .insertAccounts(AccountDbMapper.mapAccountsListToDb(accounts))
    }
}
