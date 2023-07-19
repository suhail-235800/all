package in.stackroute.service;

import in.stackroute.dto.Item;
import in.stackroute.dto.ItemRequestDto;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import java.util.stream.Stream;

@Service
public class ItemserviceImpl implements ItemService {

    private RestTemplate restTemplate;

    private final String itemServiceUrl = "http://ITEM-SERVICE/api/v1/items/search-codes";

    public ItemserviceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Item> getItemsByIds(List<String> codes) {
        try {
            ItemRequestDto dto = new ItemRequestDto(codes);
            HttpEntity<ItemRequestDto> request = new HttpEntity<>(dto);
            var response = restTemplate.postForEntity(itemServiceUrl,request,Item[].class);
            
            if(response.getStatusCode().is2xxSuccessful()){
                return Stream.of(response.getBody()).toList();
            }
        }catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
        return List.of();
    }
}
