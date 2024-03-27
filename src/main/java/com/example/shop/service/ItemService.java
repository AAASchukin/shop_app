package com.example.shop.service;

import com.example.shop.entity.Item;

import java.util.List;

public interface ItemService {
    Item add(Item newItem);

    List<Item> getAll();
    List<Item> addItemToUserCartById(Long userId, Long itemId);
    List<Item> getCartByUserId(Long id);
}
