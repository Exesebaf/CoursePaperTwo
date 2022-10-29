package com.company.coursepapertwo.service;

import com.company.coursepapertwo.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
