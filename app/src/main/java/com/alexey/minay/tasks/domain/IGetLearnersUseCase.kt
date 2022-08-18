package com.alexey.minay.tasks.domain

interface IGetLearnersUseCase {
    suspend fun invoke(courseFilterId: String?): Result<List<Learner>>
}