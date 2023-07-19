package in.stackroute.review.service;

import in.stackroute.review.domain.Review;
import in.stackroute.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review addReview(Review reviewEntity) {
        reviewRepository.save(reviewEntity);
        return reviewEntity;
    }

    @Override
    public List<Review> findById(int movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    @Override
    public List<Review> findByReviewer(String review) {
        return reviewRepository.findByReviewer(review);
    }

}
