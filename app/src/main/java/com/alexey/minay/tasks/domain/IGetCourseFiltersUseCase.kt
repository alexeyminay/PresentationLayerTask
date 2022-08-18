package com.alexey.minay.tasks.domain

interface IGetCourseFiltersUseCase {
    suspend fun invoke(): Result<List<CourseFilter>>
}