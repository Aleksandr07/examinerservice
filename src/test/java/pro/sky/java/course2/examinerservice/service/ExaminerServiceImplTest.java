package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.exceptions.QuestionsStorageOutOfBoundsException;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import static pro.sky.java.course2.examinerservice.constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @Mock
    private MathQuestionService mathQuestionService;


    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void initOut() {
        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
    }

    @Test
    void getQuestions() {
        when(javaQuestionService.getAll()).thenReturn(QUESTION_SET);
        when(mathQuestionService.getAll()).thenReturn(QUESTION_SET);
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION_1, QUESTION_2, QUESTION_3);
        when(mathQuestionService.getRandomQuestion()).thenReturn(QUESTION_1, QUESTION_2, QUESTION_3);
        assertEquals(QUESTION_SET, examinerService.getQuestions(3));
    }

    @Test
    void shouldThrowQuestionStorageOutOfBoundsException() {
        when(javaQuestionService.getAll()).thenReturn(QUESTION_SET);
        when(mathQuestionService.getAll()).thenReturn(QUESTION_SET);
        assertThrows(QuestionsStorageOutOfBoundsException.class, () -> examinerService.getQuestions(7));
    }
}