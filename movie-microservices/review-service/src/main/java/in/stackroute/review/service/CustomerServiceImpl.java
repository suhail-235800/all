package in.stackroute.review.service;

import in.stackroute.review.dto.CustomerDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private String url="http://CUSTOMER-SERVICE/v1/customer/email/{email}";
    private RestTemplate restTemplate;

    public CustomerServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public Optional<CustomerDto> findByReviewer(String reviewer) {

        try{
            final var response = restTemplate.getForEntity(url,CustomerDto.class,reviewer);
            if(response.getStatusCode().is2xxSuccessful()){
                final var body = response.getBody();
                return Optional.ofNullable(body);
            }
            return Optional.empty();
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
