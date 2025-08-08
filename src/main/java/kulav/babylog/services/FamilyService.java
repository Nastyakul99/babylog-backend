package kulav.babylog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import kulav.babylog.models.Family;
import kulav.babylog.models.Person;
import kulav.babylog.models.dto.PersonDTO;
import kulav.babylog.repositories.FamilyRepository;

@Service
public class FamilyService {
	
	private final FamilyRepository familyRepository;
	
	private final PersonService personService;
	
	@Autowired
	private final MessageSource messageSource;
	
	public FamilyService(FamilyRepository familyRepository, PersonService personService, MessageSource messageSource) {
		this.familyRepository = familyRepository;
		this.personService = personService;
		this.messageSource = messageSource;
	}

	@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Person> addToFamily(long vkId, long newMemberVkId) {
		Family family = create(vkId);
		Person newMember = personService.create(newMemberVkId);
		family.addPerson(newMember);
		familyRepository.save(family);
		return family.getPersons();
	}
	
	public List<PersonDTO> addToFamilyDTO(long vkId, long newMemberVkId) {
		return addToFamily(vkId, newMemberVkId).stream()
		.map(PersonDTO::create)
		.toList();
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Person> removeFromFamily(long userVkId, long deletedVkId) {
		personService.getByVkId(deletedVkId)
		.ifPresent(p -> p.removeFromFamily());
		return getByVKId(userVkId);
	}
	
	public Family create(long vkId) {
		Person person = personService.create(vkId);
		Family family = person.getFamily();
		if (family == null) {
			family = create();
			family.addPerson(person);
			familyRepository.save(family);
		}
		return family;
	}
	
	public Family create() {
		Family family = new Family();
		return familyRepository.save(family);
	}
	
	public List<Person> getByVKId(long vkId) {
		Optional<Person> opt = personService.getByVkId(vkId);
		if (opt.isPresent()) {
			Person person = opt.get();
			Family family = person.getFamily();
			if (family != null) return family.getPersons();
			return new ArrayList<Person>();
		}
		throw new IllegalArgumentException(
				messageSource.getMessage("error.user.does.not.exist",
						new Object[]{}, Locale.getDefault()));
	}
}
