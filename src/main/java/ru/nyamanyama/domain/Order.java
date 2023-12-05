package ru.nyamanyama.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.ZonedDateTime;


@Table(name = "orders")
@Data
public class Order {
    /**
     * Идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "appointment_table_seq", sequenceName = "orders_seq", allocationSize = 1)
    private Long id;

    /**
     * Идентификатор заказчика.
     */
    @Column(nullable = false)
    Long customerId;

    /**
     * Идентификатор курьера.
     */
    @Column
    Long courierId;

    /**
     * Дата и время оформления заказа.
     */
    @Column(nullable = false)
    ZonedDateTime orderDate;

    /**
     * Состояние заказа.
     */
    @Column
    OrderState orderState;
}
