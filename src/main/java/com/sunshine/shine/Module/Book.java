package com.sunshine.shine.Module;


import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

@Data
public class Book {
    private String id;
    private String title;
    @Transient
    private Double price;
    private LocalDateTime createdAt;
    private Integer jumpToSchedule;
}
