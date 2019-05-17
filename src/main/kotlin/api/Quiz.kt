package io.github.potatocurry.kashoot.api

import io.github.potatocurry.kashoot.json.JSONQuiz
import io.github.potatocurry.kashoot.json.JsonChoice
import io.github.potatocurry.kashoot.json.JsonQuestion
import java.net.URL

class Quiz internal constructor(quizID: String) {
    private val jsonQuiz: JSONQuiz

    init {
        val jsonURL = "$kahootEndpoint/$quizID"
        val jsonContent = URL(jsonURL).readText()
        jsonQuiz = JSONQuiz.fromJson(jsonContent) ?: throw KotlinNullPointerException("JSON content empty at $jsonURL")
    }

    val uuid = jsonQuiz.uuid

    val language = jsonQuiz.language

    val creatorID = jsonQuiz.creator

    val creator = jsonQuiz.creatorUsername

    val primaryUsage = jsonQuiz.creatorPrimaryUsage

    val folderID = jsonQuiz.folderID

    // TODO: Change to boolean?
    val visiblity = jsonQuiz.visibility

    val audience = jsonQuiz.audience

    val title = jsonQuiz.title

    val description = jsonQuiz.description

    val quizType = jsonQuiz.quizType

    val cover = jsonQuiz.cover

    val coverID = jsonQuiz.coverMetadata.id

    val questions = jsonQuiz.questions.map(::Question)

    val sponsored = jsonQuiz.metadata.sponsored

    val duplicationProtection = jsonQuiz.metadata.duplicationProtection

    val resources = jsonQuiz.resources

    val slug = jsonQuiz.slug

    val type = jsonQuiz.type

    // TODO: Change to timestamps?
    val created = jsonQuiz.created

    val modified = jsonQuiz.modified
}

class Question internal constructor(jsonQuestion: JsonQuestion) {
    val question = jsonQuestion.question

    val format = jsonQuestion.questionFormat

    val time = jsonQuestion.time

    val points = jsonQuestion.points

    val answerCount = jsonQuestion.numberOfAnswers

    val choices = jsonQuestion.choices.map(::Choice)

    val correctAnswer = choices.single{ it.correct }.answer
}

class Choice internal constructor(jsonChoice: JsonChoice) {
    val answer = jsonChoice.answer

    val correct = jsonChoice.correct
}
