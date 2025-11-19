package kulav.babylog.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kulav.babylog.models.metadata.ActivityGroupMetadata;

@RepositoryRestResource
public interface ActivityGroupMetadataRepository extends CrudRepository<ActivityGroupMetadata,Long> {

	List<ActivityGroupMetadata> findAll();
}
