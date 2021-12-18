package com.example.icthack.repositories;

import com.example.icthack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий, который используется для работы с сущностями, служащими для авторизации и регистрации.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByIsu(long isu);
}
