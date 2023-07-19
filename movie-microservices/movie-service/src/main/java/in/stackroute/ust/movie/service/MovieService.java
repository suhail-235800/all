package in.stackroute.ust.movie.service;

import in.stackroute.ust.movie.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovie(int id);
    Movie addMovie(Movie movie);
    Movie deleteMovie(Movie movie);
}
