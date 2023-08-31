package pro.sky.java.course2.examinerservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.QuestionsStorageOutOfBoundsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService, @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }


    private final Random random = new Random();

    @Override
    public Collection<Question> getQuestions(int amount) {
        int distribution = random.nextInt(amount);
        Set<Question> questionSet = new HashSet<>();
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new QuestionsStorageOutOfBoundsException();
        }
        if (distribution > javaQuestionService.getAll().size()) {
            questionSet.addAll(javaQuestionService.getAll());
        } else {
            while (questionSet.size() < distribution) {
                questionSet.add(javaQuestionService.getRandomQuestion());
            }
        }
        while (questionSet.size() < amount) {
            questionSet.add(mathQuestionService.getRandomQuestion());
        }
        return questionSet;
    }
}
