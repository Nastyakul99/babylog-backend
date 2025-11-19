package kulav.babylog.services;

import java.util.List;
import org.springframework.stereotype.Service;
import kulav.babylog.models.metadata.ActivityGroupMetadata;
import kulav.babylog.repositories.ActivityGroupMetadataRepository;

@Service
public class ActivityGroupMetadataService {

	private final ActivityGroupMetadataRepository activityGroupMetadataRepository;
	
	public ActivityGroupMetadataService (ActivityGroupMetadataRepository activityGroupMetadataRepository) {
		this.activityGroupMetadataRepository = activityGroupMetadataRepository;
	}
	
	public List<ActivityGroupMetadata> get() {
		return activityGroupMetadataRepository.findAll();
	}
}
