package in.stackroute.review.service;

import in.stackroute.review.dto.MovieDto;

import java.util.Optional;


public interface MovieService {
    Optional<MovieDto> findById(int movieId);
}
