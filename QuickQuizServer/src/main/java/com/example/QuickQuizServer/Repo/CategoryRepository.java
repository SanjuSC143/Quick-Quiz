package com.example.QuickQuizServer.Repo;

import com.example.QuickQuizServer.Entity.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
