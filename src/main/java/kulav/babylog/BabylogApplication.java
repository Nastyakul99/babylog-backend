package kulav.babylog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class BabylogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabylogApplication.class, args);
	}

}
