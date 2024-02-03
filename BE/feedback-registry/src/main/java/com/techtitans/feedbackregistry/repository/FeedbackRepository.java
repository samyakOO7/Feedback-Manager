package com.techtitans.feedbackregistry.repository;

import com.techtitans.feedbackregistry.entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

}
