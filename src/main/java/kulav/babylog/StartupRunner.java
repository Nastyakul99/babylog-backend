package kulav.babylog;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import kulav.babylog.models.Activity;
import kulav.babylog.models.ActivityGroup;
import kulav.babylog.models.TypeActivityRecord;
import kulav.babylog.repositories.ActivityGroupRepository;
import kulav.babylog.repositories.ActivityRepository;

@Component
public class StartupRunner implements CommandLineRunner {
	
	@Autowired
	private ActivityGroupRepository activityGroupRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Transactional
    @Override
    public void run(String... args) throws Exception {
    	List<ActivityGroup> groups = List.of(new ActivityGroup("Кормление", "Кормление", "https://img.icons8.com/plasticine/100/baby-bottle.png"),
    			new ActivityGroup("Сон", "Сон", "https://img.icons8.com/plasticine/100/crib.png"),
    			new ActivityGroup("Подгузники", "Подгузники", "https://img.icons8.com/plasticine/100/nappy.png"));
    	
    	groups.stream()
    	.forEach(g -> activityGroupRepository.save(g));
    	
    	List<Activity> activities = List.of(new Activity("Левая", "Левая", groups.get(0).getImg(), groups.get(0), TypeActivityRecord.TIME_RANGE),
    			new Activity("Правая", "Правая", groups.get(0).getImg(), groups.get(0), TypeActivityRecord.TIME_RANGE),
    			new Activity("Бутылочка смесь", "Бутылочка смесь", groups.get(0).getImg(), groups.get(0), TypeActivityRecord.BASE_RECORD),
    			new Activity("Бутылочка молоко", "Бутылочка молоко", groups.get(0).getImg(), groups.get(0), TypeActivityRecord.BASE_RECORD),
    			new Activity("Еда", "Еда", groups.get(0).getImg(), groups.get(0), TypeActivityRecord.TEXT_NOTE),
    			new Activity("Мокрый", "Мокрый", groups.get(2).getImg(), groups.get(0), TypeActivityRecord.BASE_RECORD),
    			new Activity("Грязный", "Грязный", groups.get(2).getImg(), groups.get(0), TypeActivityRecord.BASE_RECORD),
    			new Activity("Сон дневной", "Сон дневной", groups.get(1).getImg(), groups.get(1), TypeActivityRecord.TIME_RANGE),
    			new Activity("Сон ночной", "Сон ночной", groups.get(1).getImg(), groups.get(1), TypeActivityRecord.TIME_RANGE));
    	
    	activities.stream()
    	.forEach(a -> activityRepository.save(a));
    }
}