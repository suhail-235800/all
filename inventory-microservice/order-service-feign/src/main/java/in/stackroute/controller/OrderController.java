package in.stackroute.controller;

import in.stackroute.domain.Item;
import in.stackroute.domain.ItemRequestDto;
import in.stackroute.domain.NewOrderDto;
import in.stackroute.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    ApiClient apiClient;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody NewOrderDto dto) {


        ItemRequestDto dto1 = new ItemRequestDto(dto.items());
        HttpEntity<ItemRequestDto> request = new HttpEntity<>(dto1);

        ResponseEntity<List<Item>> responseEntity = apiClient.getItemsByIds(dto1);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<Item> items = responseEntity.getBody();
            int total = items.stream().mapToInt(Item::price).sum();
            Order order = new Order(dto.orderId(), dto.orderDate(), items, total);
            return ResponseEntity.ok(order);
        } else {

            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }
}
