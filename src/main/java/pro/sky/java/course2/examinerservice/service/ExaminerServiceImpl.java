package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.QuestionsStorageOutOfBoundsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new QuestionsStorageOutOfBoundsException();
        }
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
