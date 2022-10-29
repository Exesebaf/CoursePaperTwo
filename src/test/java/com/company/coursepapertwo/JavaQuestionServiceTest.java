package com.company.coursepapertwo;

import com.company.coursepapertwo.exception.QuestionAlreadyExistsException;
import com.company.coursepapertwo.exception.QuestionsNotFoundException;
import com.company.coursepapertwo.model.Question;
import com.company.coursepapertwo.service.QuestionService;
import com.company.coursepapertwo.service.impl.JavaQuestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @AfterEach
    public void cleanUp() {
        questionService.getAll().forEach(questionService::remove);
    }


    @Test
    public void addPositiveTest() {
        Question question1 = new Question("q1", "a1");
        add(question1);

        Question question2 = new Question("q2", "a1");
        questionService.add(question2);
        assertThat(questionService.getAll())
                .hasSize(2)
                .containsOnly(question1, question2);
    }

    @Test
    public void addNegativeTest() {
        Question question = new Question("q1", "a1");
        add(question);
        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(() -> questionService.add(question));
    }

    @Test
    public void removePositiveTest() {
        Question question = new Question("q1", "a1");
        add(question);
        questionService.remove(question);
        assertThat(questionService.getAll().isEmpty());
    }

    @Test
    public void removeNegativeTest() {
        Question question = new Question("q1", "a1");
        assertThatExceptionOfType(QuestionsNotFoundException.class)
                .isThrownBy(() -> questionService.remove(question));
        add(question);
        assertThatExceptionOfType(QuestionsNotFoundException.class)
                .isThrownBy(() -> questionService.remove(new Question("test", "test")));

    }


    @Test
    public void getRandomQuestionPositiveTest() {
        for (int i = 1; i<=5; i++){
            add(new Question("q" + i, "a" + i));
        }
        assertThat(questionService.getRandomQuestion()).isIn(questionService.getAll());
    }
    @Test
    public void getRandomQuestionNegativeTest() {
        assertThat(questionService.getAll()).isEmpty();
        assertThat(questionService.getRandomQuestion()).isNull();
    }


    private void add(Question question) {
        int sizeBefore = questionService.getAll().size();
        questionService.add(question.getQuestion(), question.getAnswer());
        assertThat(questionService.getAll())
                .hasSize(sizeBefore + 1)
                .contains(question);
    }


}
