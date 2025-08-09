package kulav.babylog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import kulav.babylog.models.records.ActivityRecord;

@RepositoryRestResource
public interface ActivityRecordRepository extends CrudRepository<ActivityRecord,Long> {

}
