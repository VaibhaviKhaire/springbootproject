package com.project.Simpleproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Simpleproject.Model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
