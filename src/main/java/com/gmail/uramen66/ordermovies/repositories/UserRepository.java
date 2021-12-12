package com.gmail.uramen66.ordermovies.repositories;

import com.gmail.uramen66.ordermovies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findAllByName(String name);

}
