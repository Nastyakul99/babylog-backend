package kulav.babylog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import kulav.babylog.models.ActivityGroup;

@RepositoryRestResource
public interface ActivityGroupRepository extends CrudRepository<ActivityGroup,Long> {

}
