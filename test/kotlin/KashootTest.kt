package io.github.potatocurry.kashoot

import io.github.potatocurry.kashoot.api.Kashoot
import org.junit.Test
import kotlin.test.*

class KashootTest {
    @Test
    fun testQuiz() {
        val kashoot = Kashoot()
        val quiz = kashoot.getQuiz("a8412292-da22-4411-bc52-339d08ab31a4")
        val questions = quiz.questions
        assertNotNull(questions)
        assertEquals(5, questions.size)
    }
}
