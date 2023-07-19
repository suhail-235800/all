package in.stackroute.ust.movie.service;

import in.stackroute.ust.movie.domain.Movie;
import in.stackroute.ust.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(int id) {
        return Optional.ofNullable(movieRepository.findAllById(id));
    }

    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }
    public Movie deleteMovie(Movie movie) {
        movieRepository.delete(movie);
        return movie;
    }
}
