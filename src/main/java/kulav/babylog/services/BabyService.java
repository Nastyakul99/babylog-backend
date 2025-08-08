package kulav.babylog.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kulav.babylog.models.Baby;
import kulav.babylog.models.Family;
import kulav.babylog.models.Person;
import kulav.babylog.models.dto.BabyDTO;
import kulav.babylog.repositories.BabiesRepository;

@Service
public class BabyService {
	
	private final BabiesRepository babiesRepository;
	private final PersonService personService;
	private final FamilyService familyService;
	
	public BabyService(BabiesRepository babiesRepository,
			PersonService personService, FamilyService familyService) {
		this.babiesRepository = babiesRepository;
		this.personService = personService;
		this.familyService = familyService;
	}

    public Baby create(BabyDTO dto, long vkId) {
    	Baby b = new Baby();
    	Family family = familyService.create(vkId);
    	b.setFamily(family);
    	return update(b, dto);
    }
    
    public Baby update(BabyDTO dto) {
        return update(getById(dto.getId()), dto);
    }
    
    public Baby update(Baby b, BabyDTO dto) {
    	b.update(dto);
    	babiesRepository.save(b);
        return b;
    }
    
    public Baby getById(long id) {
    	return babiesRepository.findById(id)
    	.orElseThrow(() ->  new IllegalArgumentException("There is no baby with id = " + id));
    }
    
    //TODO: изменить
    public List<Baby> getByPersonVkId(long vkId) {
    	Optional<Person> opt = personService.getByVkId(vkId);
    	if (opt.isPresent()) {
    		Person p = opt.get();
    		Family f = p.getFamily();
    		return f.getBabies();
    	}
    	throw new IllegalArgumentException("There is no person with vkId = " + vkId);
    }
    
    @Transactional
    public List<Baby> delete(long id) {
    	Baby b = getById(id);
    	Family f = b.getFamily();		
    	babiesRepository.delete(b);
    	return f.getBabies();
    }
}
