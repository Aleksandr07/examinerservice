package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.exceptions.NotFoundException;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.examinerservice.constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionService questionService;

    @Test
    void add() {
        when(questionRepository.add(QUESTION_1)).thenReturn(QUESTION_1);
        assertEquals(QUESTION_1, questionService.add(QUESTION_TEXT_1, ANSWER_TEXT_1));
    }

    @Test
    void addInputQuestion() {
        when(questionRepository.add(QUESTION_1)).thenReturn(QUESTION_1);
        assertEquals(QUESTION_1, questionService.add(QUESTION_1));
    }

    @Test
    void remove() {
        when(questionRepository.remove(QUESTION_1)).thenReturn(QUESTION_1);
        questionService.add(QUESTION_1);
        assertEquals(QUESTION_1, questionService.remove(QUESTION_1));
    }

    @Test
    void shouldThrowNotFoundException() {
        when(questionRepository.remove(QUESTION_3)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> questionService.remove(QUESTION_3));
    }

    @Test
    void getAll() {
        when(questionRepository.getAll()).thenReturn(QUESTION_SET);
        assertIterableEquals(QUESTION_SET, questionService.getAll());
    }

}