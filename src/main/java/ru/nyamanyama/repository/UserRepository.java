package ru.nyamanyama.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nyamanyama.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
