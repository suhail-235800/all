package in.stackroute.controller;

import in.stackroute.domain.Item;

import in.stackroute.domain.ItemRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "item-service",url = "http://localhost:8000")
public interface ApiClient {

    @PostMapping("/api/v1/items/search-codes")
    public ResponseEntity<List<Item>> getItemsByIds(@RequestBody ItemRequestDto dto);

}
