package kulav.babylog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kulav.babylog.models.Person;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person,Long> {

}
