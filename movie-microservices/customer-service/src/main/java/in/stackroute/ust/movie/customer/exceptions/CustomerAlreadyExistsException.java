package in.stackroute.ust.movie.customer.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{

    private String uri;

    public CustomerAlreadyExistsException(String message, String uri) {
        super(message);
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
