package apm.ds.userservice.service.client;

import apm.ds.userservice.dto.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("auctionservice")
public interface AuctionserviceFeignClient {
    @GetMapping("/api/items/get-items")
    ResponseEntity<List<ItemDto>> getItemsByUserId(@RequestParam Long userId);
}
