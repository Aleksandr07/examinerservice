package pro.sky.java.course2.examinerservice.constants;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

public class TestConstants {
    public static final String QUESTION_TEXT_1 = "QuestionText1";
    public static final String QUESTION_TEXT_2 = "QuestionText3";
    public static final String QUESTION_TEXT_3 = "QuestionText3";
    public static final String ANSWER_TEXT_1 = "AnswerText1";
    public static final String ANSWER_TEXT_2 = "AnswerText2";
    public static final String ANSWER_TEXT_3 = "AnswerText3";
    public static final Question QUESTION_1 = new Question(QUESTION_TEXT_1, ANSWER_TEXT_1);
    public static final Question QUESTION_2 = new Question(QUESTION_TEXT_2, ANSWER_TEXT_2);
    public static final Question QUESTION_3 = new Question(QUESTION_TEXT_3, ANSWER_TEXT_3);
    public static final Set<Question> QUESTION_SET = Set.of(QUESTION_1, QUESTION_2, QUESTION_3);
    public static final Set<Question> QUESTION_SET_ONE_QUESTION = Set.of(QUESTION_1);
}
