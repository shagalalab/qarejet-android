package com.shagalalab.core.utils.domain

interface UseCase<T> {
    suspend fun execute(): T
}
