package com.ninart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninart.models.User;

public interface IUserRepository extends JpaRepository<User, String>{

}
