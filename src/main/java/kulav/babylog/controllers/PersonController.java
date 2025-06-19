package kulav.babylog.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kulav.babylog.aspects.authentication.Signed;
import kulav.babylog.models.dto.SignedRequestImpl;
import kulav.babylog.models.Person;
import kulav.babylog.models.dto.PersonDTO;
import kulav.babylog.services.PersonService;

@RestController
@RequestMapping({"/persons"})
public class PersonController {
	
	private PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@Signed
	@PostMapping()
	public PersonDTO create(@RequestBody SignedRequestImpl person) {
		return personService.createDTO(person.getUserId());
	}
	
	//TODO: для теста
	@GetMapping()
	public Iterable<Person> findAll() {
		return personService.findAll();
	}
}
