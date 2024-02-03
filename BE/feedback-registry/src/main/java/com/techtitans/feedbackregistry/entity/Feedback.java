package com.techtitans.feedbackregistry.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feedback_table")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
    private Integer rating;
    private Long userId;
    private Timestamp createdTime;

    @PrePersist
    protected void onCreate(){
        createdTime = Timestamp.from(Instant.now());
    }
}
