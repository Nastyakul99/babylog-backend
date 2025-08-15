package kulav.babylog.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kulav.babylog.models.Activity;
import kulav.babylog.models.Baby;
import kulav.babylog.models.dto.records.ActivityRecordDTO;
import kulav.babylog.models.records.ActivityRecord;
import kulav.babylog.repositories.ActivityRecordRepository;

@Service
public class ActivityRecordService {

    private final ActivityRecordFactoryService factory;
    private final ActivityRecordRepository activityRecordRepository;
    private final BabyService babyService;

    public ActivityRecordService(ActivityRecordFactoryService factory,
            ActivityRecordRepository activityRecordRepository, BabyService babyService) {
        this.factory = factory;
        this.activityRecordRepository = activityRecordRepository;
		this.babyService = babyService;
    }
    
    public ActivityRecordDTO map(ActivityRecord record) {
    	Activity activity = record.getActivity();
        if (activity == null) {
            throw new IllegalArgumentException("Activity inside ActivityRecord cannot be null");
        }
    	return factory.createDTO(activity.getType(), record);
    }
    
    public ActivityRecord getById(long id) {
        return activityRecordRepository.findById(id)
        		.orElseThrow(() -> new IllegalArgumentException("ActivityRecord with id " + id + " not found"));
    }
    
    public List<ActivityRecord> getByBabyId(long babyId) {
    	Baby baby = babyService.getById(babyId);
    	return baby.getRecords();
    }
    
    public List<ActivityRecord> getByBabyIdAndActivityId(long babyId, long activityId) {
    	List<ActivityRecord> records = getByBabyId(babyId);
    	return records.stream()
    			.filter(r -> r.getActivity().getId() == activityId)
    			.toList();
    }

    @Transactional
    public ActivityRecord create(ActivityRecordDTO request) {
        ActivityRecord record = factory.createRecord(request);
        return activityRecordRepository.save(record);
    }
    
    @Transactional
    public ActivityRecord update(ActivityRecordDTO request) {
        Long id = request.getId();
        
        checkExistsById(id);

        ActivityRecord updatedRecord = factory.createRecord(request);

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
