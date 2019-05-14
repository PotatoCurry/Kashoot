package io.github.potatocurry.kashoot.api

internal const val kahootEndpoint = "https://play.kahoot.it/rest/kahoots"

class Kashoot {
    fun getQuiz(quizID: String): Quiz {
        return Quiz(quizID)
    }
}
