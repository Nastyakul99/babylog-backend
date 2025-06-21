package kulav.babylog;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import kulav.babylog.models.Activity;
import kulav.babylog.models.ActivityGroup;
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
    	
    	List<Activity> activities = List.of(new Activity("Левая", "Левая", groups.get(0).getImg(), groups.get(0)),
    			new Activity("Правая", "Правая", groups.get(0).getImg(), groups.get(0)),
    			new Activity("Бутылочка", "Бутылочка", groups.get(0).getImg(), groups.get(0)),
    			new Activity("Сон", "Сон", groups.get(1).getImg(), groups.get(1)));
    	
    	activities.stream()
    	.forEach(a -> activityRepository.save(a));
    	
    }
}