package ru.nyamanyama.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nyamanyama.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
