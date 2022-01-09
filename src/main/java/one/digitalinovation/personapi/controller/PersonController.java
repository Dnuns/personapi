package one.digitalinovation.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import one.digitalinovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.repository.PersonRepository;
import one.digitalinovation.personapi.service.PersonService;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	@Autowired
	private PersonService service;

	@PostMapping
	public MessageResponseDTO createPerson(@RequestBody Person person) {
		
		return service.createPerson(person);
	}

}
