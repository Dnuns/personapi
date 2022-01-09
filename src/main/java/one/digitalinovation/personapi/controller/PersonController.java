package one.digitalinovation.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.repository.PersonRepository;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonRepository personRepository;
	
	@Autowired	
	public PersonController(PersonRepository personRepository) {

		super();
		this.personRepository = personRepository;
	}

	@PostMapping
	public MessageResponseDTO createPerson(Person person) {
		
		Person savedPerson = personRepository.save(person);	
		return MessageResponseDTO.builder().message.("Created person with ID " + savedPerson.getId()).build();
	}

}
