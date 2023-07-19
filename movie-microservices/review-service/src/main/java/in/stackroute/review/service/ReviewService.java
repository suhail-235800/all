package in.stackroute.review.service;

import in.stackroute.review.domain.Review;

import java.util.List;

public interface ReviewService {

    Review addReview(Review reviewEntity);

    List<Review> findById(int movieId);

   List<Review> findByReviewer(String review);
}
