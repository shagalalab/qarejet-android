package com.shagalalab.core.utils.domain

interface UseCase<T> {
    suspend fun execute(): T
}

interface UseCaseWithParam<P, R> {
    suspend fun execute(parameter: P): R
}
