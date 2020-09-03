package com.shagalalab.core.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shagalalab.core.data.db.model.AccountDbModel
import kotlinx.coroutines.flow.Flow

@Dao
internal interface AccountDao {
    @Query("SELECT * FROM accounts")
    fun getAccounts(): Flow<List<AccountDbModel>>

    @Query("SELECT * FROM accounts WHERE account_id = :id")
    fun getAccount(id: Long): Flow<AccountDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: AccountDbModel)

    @Insert
    suspend fun insertAccounts(accounts: List<AccountDbModel>)

    @Delete
    suspend fun deleteAccount(account: AccountDbModel)
}
