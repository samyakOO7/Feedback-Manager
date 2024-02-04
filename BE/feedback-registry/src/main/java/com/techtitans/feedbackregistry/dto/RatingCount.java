package com.techtitans.feedbackregistry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingCount {
    private long rating;
    private long count_of_ratings;
}