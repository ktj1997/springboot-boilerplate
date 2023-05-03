package spring.layer.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "spring.layer")
@EnableJpaRepositories(basePackages = "spring.layer")
public class JpaConfig {}
