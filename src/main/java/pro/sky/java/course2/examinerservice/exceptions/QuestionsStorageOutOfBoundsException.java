package pro.sky.java.course2.examinerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionsStorageOutOfBoundsException extends RuntimeException{
    public QuestionsStorageOutOfBoundsException() {
    }

    public QuestionsStorageOutOfBoundsException(String message) {
        super(message);
    }

    public QuestionsStorageOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionsStorageOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public QuestionsStorageOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
