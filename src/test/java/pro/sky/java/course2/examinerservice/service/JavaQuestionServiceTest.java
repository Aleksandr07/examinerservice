package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.examinerservice.constants.TestConstants.*;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @Test
    void add() {
        assertEquals(0, questionService.getAll().size());
        assertEquals(QUESTION_1, questionService.add(QUESTION_TEXT_1, ANSWER_TEXT_1));
    }

    @Test
    void addInputQuestion() {
        assertEquals(0, questionService.getAll().size());
        assertEquals(QUESTION_1, questionService.add(QUESTION_1));
    }

    @Test
    void remove() {
        assertEquals(0, questionService.getAll().size());
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        assertNotEquals(0, questionService.getAll().size());
        assertEquals(QUESTION_2, questionService.remove(QUESTION_2));
    }

    @Test
    void getAll() {
        assertEquals(0, questionService.getAll().size());
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);
        assertIterableEquals(QUESTION_SET, questionService.getAll());
    }

}