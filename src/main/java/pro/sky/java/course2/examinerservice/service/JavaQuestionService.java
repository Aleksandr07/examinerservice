package pro.sky.java.course2.examinerservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final QuestionRepository questionsStorage;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionsStorage) {
        this.questionsStorage = questionsStorage;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questionsStorage.add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        return questionsStorage.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionsStorage.remove(question);

    }

    @Override
    public Collection<Question> getAll() {
        return questionsStorage.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(questionsStorage.getAll());
        return questionList.get(random.nextInt(questionsStorage.getAll().size()));
    }

}
