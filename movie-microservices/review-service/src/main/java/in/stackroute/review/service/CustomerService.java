package in.stackroute.review.service;

import in.stackroute.review.dto.CustomerDto;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerDto> findByReviewer(String reviewer);
}
