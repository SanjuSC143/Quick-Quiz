package com.example.QuickQuizServer.Service;

import com.example.QuickQuizServer.Entity.exam.Question;
import com.example.QuickQuizServer.Entity.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long questionId);
    public Set<Question> getQuestionsOfQuiz(Quiz quiz);
    public void deleteQuestion(Long quesId);
    public Question get(Long questionsId);

}
