package kulav.babylog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import kulav.babylog.models.Baby;

@RepositoryRestResource
public interface BabiesRepository extends CrudRepository<Baby,Long> {

}
