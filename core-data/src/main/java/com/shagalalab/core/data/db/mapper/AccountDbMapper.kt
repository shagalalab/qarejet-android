package com.shagalalab.core.data.db.mapper

import com.shagalalab.core.data.db.model.AccountDbModel
import com.shagalalab.core.data.model.Account

internal object AccountDbMapper {
    fun mapAccountsListFromDb(dbModels: List<AccountDbModel>): List<Account> {
        return dbModels.map { mapAccountFromDb(it) }
    }

    fun mapAccountFromDb(dbModel: AccountDbModel): Account {
        return Account(dbModel.id, dbModel.title, dbModel.currency, dbModel.sign)
    }

    fun mapAccountToDb(model: Account): AccountDbModel {
        return AccountDbModel(title = model.title, currency = model.currency, sign = model.sign)
    }

    fun mapAccountsListToDb(models: List<Account>): List<AccountDbModel> {
        return models.map { mapAccountToDb(it) }
    }
}
