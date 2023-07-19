package in.stackroute.ust.movie.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record MovieDto(
        int id,
        @NotNull(message = "Movie title cannot be null")
        @NotEmpty(message = "Movie title cannot be empty")
        String title
) {

}