package kulav.babylog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kulav.babylog.models.Family;

@RepositoryRestResource
public interface FamilyRepository extends CrudRepository<Family,Long> {

}
