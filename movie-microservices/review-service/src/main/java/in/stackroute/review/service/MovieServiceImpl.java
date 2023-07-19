package in.stackroute.review.service;

import in.stackroute.review.dto.MovieDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private String url="http://MOVIE-SERVICE/v1/movies/{id}";
    private RestTemplate restTemplate;
    public MovieServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<MovieDto> findById(int movieId) {
        try{
            final var repsonse = restTemplate.getForEntity(url, MovieDto.class,movieId);
            if(repsonse.getStatusCode().is2xxSuccessful()){
                var body = repsonse.getBody();
                return Optional.of(body);
            }
            return Optional.empty();
        }
        catch (Exception e){
            return Optional.empty();
        }
    }
}
