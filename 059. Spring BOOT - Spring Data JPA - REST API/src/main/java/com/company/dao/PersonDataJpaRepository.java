package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Person;

public interface PersonDataJpaRepository extends JpaRepository<Person, Integer> {

}