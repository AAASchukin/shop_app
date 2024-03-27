package com.example.shop.service.impl;

import com.example.shop.entity.Item;
import com.example.shop.entity.User;
import com.example.shop.repos.ItemRepo;
import com.example.shop.repos.UserRepo;
import com.example.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;
    private final UserRepo userRepo;

    @Override
    public Item add(Item newItem) {
        itemRepo.save(newItem);
        return newItem;
    }

    @Override
    public List<Item> getAll() {
        return itemRepo.findAll();
    }

    @Override
    public List<Item> addItemToUserCartById(Long userId, Long itemId) {
        User userToAdd = userRepo.findById(userId).get();
        Item itemToAdd = itemRepo.findById(itemId).get();

        userToAdd.getItems().add(itemToAdd);

        return userToAdd.getItems();
    }

    @Override
    public List<Item> getCartByUserId(Long id) {
        User userToFind = userRepo.findById(id).get();

        return userToFind.getItems();
    }
}
