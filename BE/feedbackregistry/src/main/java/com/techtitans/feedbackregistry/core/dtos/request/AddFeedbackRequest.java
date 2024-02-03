package com.techtitans.feedbackregistry.core.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class AddFeedbackRequest {
    private String id;
    private String comment;
    private String rating;
    private String userId;
    private Timestamp createdTime;
}
