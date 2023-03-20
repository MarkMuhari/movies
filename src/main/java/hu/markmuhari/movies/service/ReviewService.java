package hu.markmuhari.movies.service;

import hu.markmuhari.movies.model.Movie;
import hu.markmuhari.movies.model.Review;
import hu.markmuhari.movies.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;


    public Review createReview(String reviewBody, String imdbId) {
        Review savedReview = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(savedReview))
                .first();

        return savedReview;
    }
}
