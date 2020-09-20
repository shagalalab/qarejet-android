package com.shagalalab.feature.splash.domain

import com.shagalalab.core.data.model.Account
import com.shagalalab.core.data.model.Category
import com.shagalalab.core.data.repository.AccountRepository
import com.shagalalab.core.data.repository.CategoryRepository
import com.shagalalab.core.data.repository.ConfigRepository
import com.shagalalab.core.utils.data.Resource
import com.shagalalab.core.utils.domain.UseCase

internal class CheckDataPopulatedUseCase(
    private val configRepository: ConfigRepository,
    private val accountRepository: AccountRepository,
    private val categoryRepository: CategoryRepository,
    private val defaultAccounts: List<Account>,
    private val defaultCategories: List<Category>
) : UseCase<Resource<Boolean>> {

    override suspend fun execute(): Resource<Boolean> {
        return if (!configRepository.checkInitialDataPopulated()) {
            try {
                accountRepository.addAccounts(defaultAccounts)
                categoryRepository.addCategories(defaultCategories)
                configRepository.setInitialDataPopulated()
                Resource.success(true)
            } catch (e: Exception) {
                Resource.error("Couldn't add default accounts and categories")
            }
        } else {
            Resource.success(true)
        }
    }
}
