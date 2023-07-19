package in.stackroute.ust.movie.controller;

import in.stackroute.ust.movie.domain.Movie;
import in.stackroute.ust.movie.dto.MovieDto;
import in.stackroute.ust.movie.exceptions.MovieAlreadyExistsException;
import in.stackroute.ust.movie.exceptions.MovieNotFoundException;
import in.stackroute.ust.movie.repository.MovieRepository;
import in.stackroute.ust.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/movies")
public class MovieController {

    private MovieService movieService;

    private Logger logger = LoggerFactory.getLogger(MovieController.class);
    private final MovieRepository movieRepository;

    public MovieController(MovieService movieService,
                           MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<MovieDto>> getAllCustomer(){
        logger.info("getAllMovies");
        final var list = movieService.getAllMovies();
        if(list.isEmpty()){
            logger.info("getAllMovies:No movies found");
            throw new MovieNotFoundException(
                    String.format("Movie not found"),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        return ResponseEntity.ok(list.stream().map(this::toDto).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getCustomer(@PathVariable int id){
        logger.info("getMovie with id {}",id);
        final var movie = movieService.getMovie(id);
        if(movie.isEmpty()){
            logger.error("getMovie : movie with id {}",id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found",id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(toDto(movie.get()));
    }

    @PostMapping("")
    public ResponseEntity<MovieDto> addMovies(@Valid @RequestBody MovieDto moviedto){
        logger.info("addMovies with title {}",moviedto.title());
        final var movie = movieRepository.findByIdOrTitle(moviedto.id(),moviedto.title());
        if(movie.isPresent()){
            logger.error("addMovies with id {} or title {}",moviedto.id(),moviedto.title());
            throw new MovieAlreadyExistsException(
                    String.format("Movie already exists"),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        final var new1 = movieService.addMovie(toEntity(moviedto));
        return ResponseEntity.status(HttpStatus.OK).body(toDto(new1));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateCustomer(@RequestBody MovieDto moviedto,@PathVariable int id){
        logger.info("Update Movie:Updating movie with id{}",id);
        var optional = movieService.getMovie(id);
        if(optional.isEmpty()){
            logger.error("updateMovie:movie with id {} not found",id);
            throw new MovieNotFoundException(
              String.format("Movie with id %d not found",id),
              ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(toDto(movieService.addMovie(optional.get())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteCustomer(@PathVariable int id){
        logger.info("deleteMovie: Deleting movie with id {} ", id);
        var optional = movieService.getMovie(id);
        if (optional.isEmpty()) {
            logger.error("deleteMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        movieService.deleteMovie(optional.get());
        return ResponseEntity.noContent().build();
    }

    private Movie toEntity(MovieDto dto) {
        return new Movie(dto.id(), dto.title());
    }

    private MovieDto toDto(Movie entity) {
        return new MovieDto(entity.getId(), entity.getTitle());
    }

}
