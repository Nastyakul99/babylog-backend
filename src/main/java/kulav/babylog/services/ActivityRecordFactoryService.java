package kulav.babylog.services;

import org.springframework.stereotype.Component;
import kulav.babylog.models.Activity;
import kulav.babylog.models.Baby;
import kulav.babylog.models.Person;
import kulav.babylog.models.TypeActivityRecord;
import kulav.babylog.models.dto.records.ActivityRecordDTO;
import kulav.babylog.models.dto.records.IntegerAndTimeRangeDTO;
import kulav.babylog.models.dto.records.MLAndTimeRangeDTO;
import kulav.babylog.models.records.ActivityRecord;
import kulav.babylog.models.records.IntegerAndTimeRange;
import kulav.babylog.models.records.MLAndTimeRange;
import kulav.babylog.models.records.TextNoteRecord;
import kulav.babylog.models.records.TimeRangeRecord;
import kulav.babylog.models.dto.records.TimeRangeRecordDTO;
import kulav.babylog.models.dto.records.TextNoteRecordDTO;

@Component
public class ActivityRecordFactoryService {
	
	private final ActivityService activityService;
	private final BabyService babyService;
	private final PersonService personService;
	
	public ActivityRecordFactoryService(ActivityService activityService, BabyService babyService, PersonService personService) {
		this.activityService = activityService;
		this.babyService = babyService;
		this.personService = personService;
	}

    public ActivityRecord createRecord(ActivityRecordDTO request) {
    	Activity activity = activityService.getById(request.getActivityId());
    	Baby baby = babyService.getById(request.getBabyId());
    	Person person = personService.getByVkId(request.getAuthorId()).orElse(null);
        switch (activity.getType()) {
            case BASE_RECORD -> {
            	ActivityRecord record = new ActivityRecord();
            	ActivityRecordDTO dto = check(request, ActivityRecordDTO.class);
            	return record.update(dto, activity, baby, person);
            }
            case TIME_RANGE -> {
                TimeRangeRecord record = new TimeRangeRecord();
                TimeRangeRecordDTO dto = check(request, TimeRangeRecordDTO.class);
                return record.update(dto, activity, baby, person);
            }
            case TEXT_NOTE -> {
                TextNoteRecord record = new TextNoteRecord();
                TextNoteRecordDTO dto = check(request, TextNoteRecordDTO.class);
                return record.update(dto, activity, baby, person);
            }
            case COUNT_RECORD -> {
                IntegerAndTimeRange record = new IntegerAndTimeRange();
                IntegerAndTimeRangeDTO dto = check(request, IntegerAndTimeRangeDTO.class);
                return record.update(dto, activity, baby, person);
            }
            case ML_RECORD -> {
                MLAndTimeRange record = new MLAndTimeRange();
                MLAndTimeRangeDTO dto = check(request, MLAndTimeRangeDTO.class);
                return record.update(dto, activity, baby, person);
            }
            default -> throw new IllegalArgumentException("Unsupported activity type");
        }
    }
    
    public ActivityRecordDTO createDTO(TypeActivityRecord arType, ActivityRecord record) {
        switch (arType) {
            case BASE_RECORD -> {
            	ActivityRecord r = check(record, ActivityRecord.class);
            	ActivityRecordDTO dto = ActivityRecordDTO.create(r);
            	return dto;
            }
            case TIME_RANGE -> {
            	TimeRangeRecord r = check(record, TimeRangeRecord.class);
            	TimeRangeRecordDTO dto = TimeRangeRecordDTO.create(r);
            	return dto;
            }
            case TEXT_NOTE -> {
            	TextNoteRecord r = check(record, TextNoteRecord.class);
            	TextNoteRecordDTO dto = TextNoteRecordDTO.create(r);
            	return dto;
            }
            case COUNT_RECORD -> {
            	IntegerAndTimeRange r = check(record, IntegerAndTimeRange.class);
            	IntegerAndTimeRangeDTO dto = IntegerAndTimeRangeDTO.create(r);
            	return dto;
            }
            case ML_RECORD -> {
            	MLAndTimeRange r = check(record, MLAndTimeRange.class);
            	MLAndTimeRangeDTO dto = MLAndTimeRangeDTO.create(r);
            	return dto;
            }
            default -> throw new IllegalArgumentException("Unsupported activity type");
        }
    }
    
    //TODO: дописать
    private <T> T check(Object request, Class<T> clazz) {
        if (!clazz.isInstance(request)) {
            throw new IllegalArgumentException("Invalid request type: expected "
            		+ clazz.getSimpleName() +
                    ", but got " + request.getClass().getSimpleName());
        }
        return clazz.cast(request);
    }
}

