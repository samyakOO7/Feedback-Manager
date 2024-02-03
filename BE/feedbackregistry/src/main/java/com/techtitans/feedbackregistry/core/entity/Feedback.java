package com.techtitans.feedbackregistry.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Feedback {
    private String id;
    private String comment;
    private String rating;
    private Timestamp createdTime;
}
