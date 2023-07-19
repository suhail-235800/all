package in.stackroute.ust.movie.customer.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record LoginDto(
        @NotNull
        @NotEmpty
        String email,
        @NotNull
        @NotEmpty
        String password) {
}
