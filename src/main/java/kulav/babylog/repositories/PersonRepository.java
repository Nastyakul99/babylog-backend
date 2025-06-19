package kulav.babylog.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import kulav.babylog.models.Person;

@RepositoryRestResource(exported = false)
public interface PersonRepository extends CrudRepository<Person,Long> {

	Optional<Person> findByVkId(long vkId);
	
	/**
	 * 
	 * @param id - НЕ VKID
	 * @return члены семьи пользователя с переданным id
	 */
//	@Query (value="select pp from persons p where p.id=:id"
//			+ "join persons pp on pp.family_id=p.family_id", nativeQuery=true)
//	List<Person> findFamilyByPersonId(long id);
}
