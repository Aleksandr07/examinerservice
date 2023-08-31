package pro.sky.java.course2.examinerservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.NotFoundException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository{
    private final Set<Question> questionsStorage = new HashSet<>();

    @Override
    @PostConstruct
    public void init() {
        Question question1 = new Question("JavaQuestionText1", "JavaAnswerText1");
        Question question2 = new Question("JavaQuestionText2", "JavaAnswerText2");
        Question question3 = new Question("JavaQuestionText3", "JavaAnswerText3");
        Question question4 = new Question("JavaQuestionText4", "JavaAnswerText4");
        Question question5 = new Question("JavaQuestionText5", "JavaAnswerText5");
        questionsStorage.add(question1);
        questionsStorage.add(question2);
        questionsStorage.add(question3);
        questionsStorage.add(question4);
        questionsStorage.add(question5);
    }

    @Override
    public Question add(Question question) {
        questionsStorage.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        validationQuestion(question);
        questionsStorage.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionsStorage;
    }

    private void validationQuestion(Question question) {
        if (!questionsStorage.contains(question)) {
            throw new NotFoundException();
        }
    }

}
