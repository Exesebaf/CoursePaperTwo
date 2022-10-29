package com.company.coursepapertwo.service;

import com.company.coursepapertwo.model.Question;

import java.util.Collection;

public interface QuestionService {

     Question add(String questions, String answer);

     Question add(Question question);

     Question remove(Question question);

     Collection<Question> getAll();

     Question getRandomQuestion();


}
