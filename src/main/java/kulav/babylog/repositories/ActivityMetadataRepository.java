package kulav.babylog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kulav.babylog.models.metadata.ActivityMetadata;

@RepositoryRestResource
public interface ActivityMetadataRepository extends CrudRepository<ActivityMetadata,Long> {

	List<ActivityMetadata> findAll();
}
