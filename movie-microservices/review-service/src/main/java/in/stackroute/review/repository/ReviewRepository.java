package in.stackroute.review.repository;

import in.stackroute.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

    List<Review> findByMovieId(int movieId);

    List<Review> findByReviewer(String review);
}
