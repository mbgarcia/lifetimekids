package com.ninart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninart.models.Child;

public interface IChildRepository extends JpaRepository<Child, Long>{

}
