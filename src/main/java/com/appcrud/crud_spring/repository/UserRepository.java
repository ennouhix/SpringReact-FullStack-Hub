package com.appcrud.crud_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appcrud.crud_spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
