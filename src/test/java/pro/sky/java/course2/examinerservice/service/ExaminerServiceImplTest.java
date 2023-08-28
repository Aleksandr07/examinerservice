package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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

    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Test
    void getQuestions() {
        when(javaQuestionService.getAll()).thenReturn(QUESTION_SET);
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION_1);
        assertIterableEquals(QUESTION_SET_ONE_QUESTION, examinerService.getQuestions(1));
    }

    @Test
    void shouldThrowQuestionStorageOutOfBoundsException() {
        assertThrows(QuestionsStorageOutOfBoundsException.class, () -> examinerService.getQuestions(4));
    }
}