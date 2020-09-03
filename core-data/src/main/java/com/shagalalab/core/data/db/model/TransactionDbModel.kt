package com.shagalalab.core.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
internal data class TransactionDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val type: Int,
    val date: Long,
    @ColumnInfo(name = "acc_id") val accountId: Long,
    @ColumnInfo(name = "cat_id") val categoryId: Long,
    val amount: Double,
    val memo: String
)
