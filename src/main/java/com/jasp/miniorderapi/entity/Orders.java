package com.jasp.miniorderapi.entity;

import com.jasp.miniorderapi.category.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(name = "unq_order_num", columnNames = {"number"})})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDateTime dateTime;

    private int amount;


    public Orders(String name, Category category, LocalDateTime dateTime, int amount) {
        this.name = name;
        this.category = category;
        this.dateTime = dateTime;
        this.amount = amount;
    }
}
