package com.example.shop.repos;

import com.example.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
//    @Query("SELECT u FROM User u WHERE u.firstName LIKE %:name% AND u.lastName LIKE %:surname%")
//    List<User> findUsersByNameAndSurnameRegex(String nameRegex, String surnameRegex);
    @Query(value = "SELECT * FROM usr WHERE LOWER(first_name) LIKE LOWER(CONCAT('%', ?1, '%')) AND LOWER(last_name) LIKE LOWER(CONCAT('%', ?2, '%'))", nativeQuery = true)
    List<User> findAllByFirstNameLikeIgnoreCaseAndLastNameLikeIgnoreCase(String firstName, String lastName);
    User findUserByLogin(String login);
}
