package com.company.coursepapertwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuestionAlreadyExistsException extends RuntimeException{

    public QuestionAlreadyExistsException() {
    }

    public QuestionAlreadyExistsException(String s) {
        super(s);
    }

    public QuestionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAlreadyExistsException(Throwable cause) {
        super(cause);
    }



}
