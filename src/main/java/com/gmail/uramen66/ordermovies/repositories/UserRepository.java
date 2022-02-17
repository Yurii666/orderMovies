package com.gmail.uramen66.ordermovies.repositories;

import com.gmail.uramen66.ordermovies.enums.StatusType;
import com.gmail.uramen66.ordermovies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.id = :id and u.status = :status")
    Optional<User> findByIdAndStatus(Long id, StatusType statusType);

    @Query(value = "select u from User u where u.id = :id")
    Optional<User> findById(Long id);
}
