package kulav.babylog.repositories;

//vzl28046@jioso.com
//4111764859

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kulav.babylog.models.Activity;

@RepositoryRestResource
public interface ActivityRepository extends CrudRepository<Activity,Long> {

}
