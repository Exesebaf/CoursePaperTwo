package com.company.coursepapertwo.service.impl;


import com.company.coursepapertwo.exception.QuestionAlreadyExistsException;
import com.company.coursepapertwo.exception.QuestionsNotFoundException;
import com.company.coursepapertwo.model.Question;
import com.company.coursepapertwo.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyExistsException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionsNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if(questions.isEmpty()){
            return null;
        }
        return questions.stream().skip(random.nextInt(questions.size())).findFirst().orElse(null);

    }










}
