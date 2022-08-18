package com.alexey.minay.tasks.presentation.state

data class LearnerFilters(
        val type: Type,
        val learningFilter: LearningFilter,
        val dateFilter: DateFilter
) {

    enum class DateFilter {
        LAST_90_DAYS,
        LAST_30_DAYS
    }

    enum class LearningFilter {
        ASSIGN,
        CATALOG,
        ASSIGN_AND_CATALOG
    }

    enum class Type {
        INIT,
        ERROR,
        DATA
    }

    companion object {
        fun default() = LearnerFilters(
                type = Type.INIT,
                learningFilter = LearningFilter.ASSIGN_AND_CATALOG,
                dateFilter = DateFilter.LAST_90_DAYS
        )
    }

}