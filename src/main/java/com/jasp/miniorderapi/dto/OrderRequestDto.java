package com.jasp.miniorderapi.dto;

import com.jasp.miniorderapi.category.Category;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderRequestDto {

    private String name;
    private Category category;
    private LocalDateTime dateTime;
    private int amount;
}
