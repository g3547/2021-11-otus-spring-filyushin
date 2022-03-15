package ru.otus.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.domain.AplUser;

import java.util.Optional;

public interface AplUserRepository extends JpaRepository<AplUser, Long> {
    Optional<AplUser> findByName(String name);
}
