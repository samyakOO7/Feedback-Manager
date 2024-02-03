package com.techtitans.feedbackregistry.core.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class AddFeedbackResponse {
    private String id;
    private String comment;
    private String rating;
    private Timestamp createdTime;
}
