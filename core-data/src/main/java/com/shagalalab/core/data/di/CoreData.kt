package com.shagalalab.core.data.di

import androidx.room.Room
import com.shagalalab.core.data.db.QarejetDatabase
import com.shagalalab.core.data.repository.AccountRepository
import com.shagalalab.core.data.repository.CategoryRepository
import com.shagalalab.core.data.repository.ConfigRepository
import com.shagalalab.core.data.repository.TransactionRepository
import com.shagalalab.core.data.repository.impl.AccountRepositoryImpl
import com.shagalalab.core.data.repository.impl.CategoryRepositoryImpl
import com.shagalalab.core.data.repository.impl.ConfigRepositoryImpl
import com.shagalalab.core.data.repository.impl.TransactionRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object CoreData {
    val module = module {
        single {
            Room.databaseBuilder(androidContext(), QarejetDatabase::class.java, "qarejet.db").build()
        }
        factory<ConfigRepository> { ConfigRepositoryImpl(get()) }
        single<AccountRepository> { AccountRepositoryImpl(get()) }
        single<CategoryRepository> { CategoryRepositoryImpl(get()) }
        single<TransactionRepository> { TransactionRepositoryImpl(get()) }
    }
}
