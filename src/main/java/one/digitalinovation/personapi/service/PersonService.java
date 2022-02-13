package one.digitalinovation.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import one.digitalinovation.personapi.dto.request.PersonDTO;
import one.digitalinovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.exception.PersonNotFoundException;
import one.digitalinovation.personapi.mapper.PersonMapper;
import one.digitalinovation.personapi.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@PostMapping
	public MessageResponseDTO createPerson(PersonDTO personDTO) {

		Person personToSave = personMapper.toModel(personDTO);

		Person savedPerson = personRepository.save(personToSave);

		return createMessageResponse(savedPerson.getId(), "Created person with ID ");
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
	}

	private Person verifyIfExits(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExits(id);

		return personMapper.toDTO(person);
	}

	private MessageResponseDTO createMessageResponse(Long id, String s) {
		return MessageResponseDTO
				.builder()
				.message(s + id)
				.build();
	}
	
	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExits(id);

		personRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		
		verifyIfExits(id);
		
		Person personToUpdate = personMapper.toModel(personDTO);

		Person savedPerson = personRepository.save(personToUpdate);

		return createMessageResponse(savedPerson.getId(), "Updated person with ID ");
	}


}
