package com.company.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Person;

public interface PersonDataJpaRepository extends JpaRepository<Person, Integer> {

	public List<Person> findAllByOrderByEmailAsc();
}