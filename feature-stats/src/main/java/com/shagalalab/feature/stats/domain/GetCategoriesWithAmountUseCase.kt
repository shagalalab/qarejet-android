package com.shagalalab.feature.stats.domain

import com.shagalalab.core.data.model.Transaction
import com.shagalalab.core.data.repository.TransactionRepository
import com.shagalalab.core.utils.domain.UseCaseWithParam
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.joda.time.DateTime

class GetCategoriesWithAmountUseCase(private val transactionRepository: TransactionRepository) :
    UseCaseWithParam<Pair<DateTime, Int>, Flow<List<Transaction>>> {

    override suspend fun execute(parameter: Pair<DateTime, Int>): Flow<List<Transaction>> {
        val startDate =
            parameter.first.dayOfMonth().withMinimumValue().withTimeAtStartOfDay().millis
        val endDate =
            parameter.first.dayOfMonth().withMaximumValue().plusDays(1).withTimeAtStartOfDay()
                .minusSeconds(1).millis
        val categoryType = parameter.second
        return flow {
            transactionRepository.getTransactionsWithinDateByType(
                startDate,
                endDate,
                categoryType
            ).collect()
        }
    }
}
