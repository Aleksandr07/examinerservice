package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questionsStorage = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionsStorage.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questionsStorage.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionsStorage.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionsStorage;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(questionsStorage);
        return questionList.get(random.nextInt(questionsStorage.size()));
    }
}
