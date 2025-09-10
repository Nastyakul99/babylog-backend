package kulav.babylog.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import kulav.babylog.models.Activity;

@RepositoryRestResource
public interface ActivityRepository extends CrudRepository<Activity,Long> {

	@Query(value="select a from Activity a where a.group.id=:id")
	List<Activity> findByGroup(long id);
	
	List<Activity> findAll();
}
