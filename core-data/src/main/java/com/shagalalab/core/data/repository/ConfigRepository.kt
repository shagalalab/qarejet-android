package com.shagalalab.core.data.repository

interface ConfigRepository {
    fun checkInitialDataPopulated(): Boolean
    fun setInitialDataPopulated()
}
