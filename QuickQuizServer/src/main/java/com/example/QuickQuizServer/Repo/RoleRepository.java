package com.example.QuickQuizServer.Repo;

import com.example.QuickQuizServer.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
