package ru.nyamanyama.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Table(name = "users")
@Data
public class User {
    /**
     * Идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "appointment_table_seq", sequenceName = "users_seq", allocationSize = 1)
    private Long id;
    /**
     * Имя.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * Фамилия.
     */
    @Column(nullable = false)
    private String secondName;

    /**
     * Логин.
     */
    @Column(nullable = false)
    private String login;

    /**
     * Пароль.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Номер телефона.
     */
    @Column(nullable = false)
    private String phoneNumber;

    /**
     * Почта.
     */
    @Column
    private String email;

    /**
     * Номер телефона.
     */
    @Column(nullable = false)
    private UserRole role;

}
