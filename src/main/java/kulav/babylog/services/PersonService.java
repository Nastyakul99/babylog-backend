package kulav.babylog.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import kulav.babylog.models.Person;
import kulav.babylog.models.dto.PersonDTO;
import kulav.babylog.repositories.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}


    public PersonDTO createDTO(long vkId) {
        Optional<Person> opt = findByVkId(vkId);
        if (opt.isPresent()) return PersonDTO.create(opt.get());
        Person newPerson = new Person(vkId);
        newPerson = personRepository.save(newPerson);
		return PersonDTO.create(newPerson);
    }
    
	//если пользователя нет, то создает его, иначе возвращает существующего
    public Person create(long vkId) {
        Optional<Person> opt = findByVkId(vkId);
        if (opt.isPresent()) return opt.get();
        Person newPerson = new Person(vkId);
        newPerson = personRepository.save(newPerson);
		return newPerson;
    }
    
    public Optional<Person> findByVkId(long vkId) {
    	return personRepository.findByVkId(vkId);
    }
    
    public Iterable<Person> findAll() {
    	return personRepository.findAll();
    }
}
