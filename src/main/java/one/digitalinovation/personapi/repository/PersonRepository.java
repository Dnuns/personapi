package one.digitalinovation.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinovation.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {	
}