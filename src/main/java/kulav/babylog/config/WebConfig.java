package kulav.babylog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer, RepositoryRestConfigurer {
	
	private final String MAPPING = "/**";
	
	private final String[] ORIGINS = {"*"}; //{"https://vk.com"};
	
	private final String[] METHODS = {"GET", "POST", "PUT", "DELETE"};
	
	private final String[] HEADERS = {"*"};
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(MAPPING)
                .allowedOrigins(ORIGINS)
                .allowedMethods(METHODS)
                .allowedHeaders(HEADERS)
                .allowCredentials(false);
    }
    
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
      cors.addMapping(MAPPING)
        .allowedOrigins(ORIGINS)
        .allowedMethods(METHODS)
        .allowedHeaders(HEADERS)
        .allowCredentials(false);
    }
}