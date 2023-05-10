package com.example.QuickQuizServer.Repo;

import com.example.QuickQuizServer.Entity.exam.Question;
import com.example.QuickQuizServer.Entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
