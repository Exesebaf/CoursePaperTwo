package com.company.coursepapertwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectAmountOfQuestions extends RuntimeException{

    public IncorrectAmountOfQuestions() {
    }

    public IncorrectAmountOfQuestions(String s) {
        super(s);
    }

    public IncorrectAmountOfQuestions(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectAmountOfQuestions(Throwable cause) {
        super(cause);
    }

}
