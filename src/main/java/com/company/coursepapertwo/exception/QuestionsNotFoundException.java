package com.company.coursepapertwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class QuestionsNotFoundException extends RuntimeException{
    public QuestionsNotFoundException() {
    }

    public QuestionsNotFoundException(String s) {
        super(s);
    }

    public QuestionsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionsNotFoundException(Throwable cause) {
        super(cause);
    }
}
