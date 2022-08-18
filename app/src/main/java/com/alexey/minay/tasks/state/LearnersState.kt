package com.alexey.minay.tasks.state


data class LearnersState(
        val type: Type,
        val learners: List<Learner>,
        val isMessagingAvailable: Boolean,
        val filters: LearnerFilters
) {

    enum class Type {
        INIT,
        EMPTY,
        NO_INTERNET,
        DATA,
        SERVER_CONNECTION_ERROR
    }

    companion object {
        fun default() = LearnersState(
                type = Type.INIT,
                learners = emptyList(),
                isMessagingAvailable = false,
                filters = LearnerFilters.default()
        )
    }
}

