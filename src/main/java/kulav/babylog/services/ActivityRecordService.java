package kulav.babylog.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kulav.babylog.models.Activity;
import kulav.babylog.models.dto.records.ActivityRecordDTO;
import kulav.babylog.models.records.ActivityRecord;
import kulav.babylog.repositories.ActivityRecordRepository;

@Service
public class ActivityRecordService {

	private final ActivityService activityService;
    private final ActivityRecordFactoryService factory;
    private final ActivityRecordRepository activityRecordRepository;

    public ActivityRecordService(
    		ActivityService activityService,
            ActivityRecordFactoryService factory,
            ActivityRecordRepository activityRecordRepository) {
        this.activityService = activityService;
        this.factory = factory;
        this.activityRecordRepository = activityRecordRepository;
    }
    
    public ActivityRecordDTO map(ActivityRecord record) {
    	Activity activity = record.getActivity();
        if (activity == null) {
            throw new IllegalArgumentException("Activity inside ActivityRecord cannot be null");
        }
    	return factory.createDTO(activity.getType(), record);
    }
    
    public ActivityRecord getById(Long id) {
        return activityRecordRepository.findById(id)
        		.orElseThrow(() -> new IllegalArgumentException("ActivityRecord with id " + id + " not found"));
    }

    @Transactional
    public ActivityRecord create(ActivityRecordDTO request) {
        Activity activity = activityService.getById(request.getActivityId());

        ActivityRecord record = factory.createRecord(activity, request);
        return activityRecordRepository.save(record);
    }
    
    @Transactional
    public ActivityRecord update(ActivityRecordDTO request) {
        Long id = request.getId();
        
        checkExistsById(id);
               
        Activity activity = activityService.getById(request.getActivityId());

        ActivityRecord updatedRecord = factory.createRecord(activity, request);

        updatedRecord.setId(id);

        return activityRecordRepository.save(updatedRecord);
    }
    
    @Transactional
    public void delete(Long id) {
    	checkExistsById(id);
        activityRecordRepository.deleteById(id);
    }
    
    private void checkExistsById(Long id) {
        if (id == null || !activityRecordRepository.existsById(id)) {
            throw new IllegalArgumentException("ActivityRecord with id " + id + " not found");
        }
    }
}
