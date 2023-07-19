package in.stackroute.ust.movie.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    private String uri;
    public CustomerNotFoundException(){}

    public CustomerNotFoundException(String movieNotFound, String toUriString) {
        super(movieNotFound);
        this.uri = uri;
    }

    public String getUri(){
        return uri;
    }
}
