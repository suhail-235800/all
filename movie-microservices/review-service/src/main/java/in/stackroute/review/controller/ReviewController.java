package in.stackroute.review.controller;

import in.stackroute.review.service.ReviewService;
import in.stackroute.review.domain.Review;
import in.stackroute.review.dto.ReviewDto;


import in.stackroute.review.service.CustomerService;
import in.stackroute.review.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/reviews")
public class ReviewController
{
    private ReviewService reviewService;

    private MovieService movieService;

    private CustomerService customerService;

    public ReviewController(ReviewService reviewService, MovieService movieService,
                            CustomerService customerService) {
        this.reviewService = reviewService;
        this.movieService = movieService;
        this.customerService = customerService;
    }
    @PostMapping(" ")
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto reviewDto){
        var reviewEntity = toEntity(reviewDto);
        var movie = movieService.findById(reviewEntity.getMovieId());
        var customer = customerService.findByReviewer(reviewEntity.getReviewer());
        if(movie.isEmpty() || customer.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var newReview = reviewService.addReview(reviewEntity);
        return ResponseEntity.status(HttpStatus.OK).body(toDto(reviewEntity));
    }

    @GetMapping("/id/{movieId}")
    public ResponseEntity<List<ReviewDto>> getReviewsById(int movieId){
        final var test= reviewService.findById(movieId);
        if(test.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(test.stream().map(this::toDto).toList());
    }

    @GetMapping("reviewer/{reviewer}")
    public ResponseEntity<List<ReviewDto>> getReviewersByReviewer(String review){
        final var test = reviewService.findByReviewer(review);
        if(test.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(test.stream().map(this::toDto).toList());
    }

    private Review toEntity(ReviewDto dto) {
        return new Review(dto.movieId(), dto.review(),dto.reviewer(),dto.rating());
    }

    private ReviewDto toDto(Review entity) {
        return new ReviewDto(entity.getMovieId(), entity.getReview(), entity.getReviewer(), entity.getRating());
    }

}
