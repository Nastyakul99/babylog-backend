package kulav.babylog.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kulav.babylog.aspects.authentication.Signed;
import kulav.babylog.models.dto.ActivityRecordSignedRequest;
import kulav.babylog.models.dto.RecordsByBabyAndActivityRequest;
import kulav.babylog.models.dto.SubIdRequest;
import kulav.babylog.models.dto.records.ActivityRecordDTO;
import kulav.babylog.models.records.ActivityRecord;
import kulav.babylog.services.ActivityRecordService;

@RestController
@RequestMapping("/activityRecords")
public class ActivityRecordController {

    private final ActivityRecordService activityRecordService;

    public ActivityRecordController(ActivityRecordService activityRecordService) {
        this.activityRecordService = activityRecordService;
    }

    @Signed
    @PostMapping
    public ActivityRecordDTO create(@RequestBody ActivityRecordSignedRequest request) {
        ActivityRecord createdRecord = activityRecordService.create(request.getActivityRecord());
        ActivityRecordDTO dto = activityRecordService.map(createdRecord);
        return dto;
    }
    
    @Signed
    @GetMapping("/baby/")
    public List<ActivityRecordDTO> getByBabyId(SubIdRequest request) {
    	return activityRecordService.getByBabyId(request.getSubId())
    			.stream()
    			.map(activityRecordService::map)
    			.toList();
    }
    
    @Signed
    @GetMapping("/baby/activity")
    public List<ActivityRecordDTO> getByBabyIdAndActivityId(RecordsByBabyAndActivityRequest request) {
    	return activityRecordService.getByBabyIdAndActivityId(request.getBabyId(), request.getActivityId())
    			.stream()
    			.map(activityRecordService::map)
    			.toList();
    }
    
    @Signed
    @GetMapping("/baby/group")
    public List<ActivityRecordDTO> getByBabyIdAndGroupId(RecordsByBabyAndActivityRequest request) {
    	return activityRecordService.getByBabyIdAndGroupId(request.getBabyId(), request.getActivityId())
    			.stream()
    			.map(activityRecordService::map)
    			.toList();
    }

    @Signed
    @PutMapping
    public ActivityRecordDTO update(@RequestBody ActivityRecordSignedRequest request) {
        ActivityRecord updatedRecord = activityRecordService.update(request.getActivityRecord());
        return activityRecordService.map(updatedRecord);
    }

    @Signed
    @DeleteMapping()
    public void delete(SubIdRequest request) {
        activityRecordService.delete(request.getSubId());
    }
}