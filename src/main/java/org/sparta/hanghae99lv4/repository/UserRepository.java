package org.sparta.hanghae99lv4.repository;

import org.sparta.hanghae99lv4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}