package in.stackroute.ust.movie.exceptions;

public class MovieNotFoundException extends RuntimeException {

    private String uri;
    public MovieNotFoundException(){}

    public MovieNotFoundException(String movieNotFound, String toUriString) {
        super(movieNotFound);
        this.uri = uri;
    }

    public String getUri(){
        return uri;
    }
}
