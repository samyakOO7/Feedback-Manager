package com.techtitans.feedbackregistry.repository;

import com.techtitans.feedbackregistry.dto.RatingCount;
import com.techtitans.feedbackregistry.entity.Feedback;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

    @Query(nativeQuery = true, value = "SELECT rating, COUNT(*) as count_of_ratings FROM feedback_table where feedback_table.user_id=:userId GROUP BY rating")
    Iterable<RatingCountProjection> findByUserId(@Param("userId") Long userId);

    interface RatingCountProjection {
        Long getRating();
        Long getCount_of_ratings();
    }
}
