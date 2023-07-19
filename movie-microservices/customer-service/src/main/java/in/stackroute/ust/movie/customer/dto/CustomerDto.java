package in.stackroute.ust.movie.customer.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CustomerDto(int id, String name,
                          @NotNull
                          @NotEmpty
                          String email,
                          @NotNull
                          @NotEmpty
                          String password) {
}
