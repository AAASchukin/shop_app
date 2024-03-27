package com.example.shop.repos;

import com.example.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    @Query(nativeQuery = true, value = "select * from cart where cart.id_usr = ?1")
    List<Item> findItemsByUserId(Long id);
}
