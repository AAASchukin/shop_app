package com.example.shop.rest;

import com.example.shop.entity.Item;
import com.example.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/item")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok(itemService.getAll());
    }

    @PostMapping
    public ResponseEntity<Item> addNewItem(@RequestBody Item newItem){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.add(newItem));
    }

    @PostMapping("/carts")
    public ResponseEntity<List<Item>> addNewItemToUserCart(@RequestParam("userId") Long userId, @RequestParam("itemId") Long itemId){
        return ResponseEntity.ok(itemService.addItemToUserCartById(userId, itemId));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Item>> getCartByUserId(@PathVariable Long id){
        return ResponseEntity.ok(itemService.getCartByUserId(id));
    }
}
