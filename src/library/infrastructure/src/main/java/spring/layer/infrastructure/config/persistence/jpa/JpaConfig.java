package spring.layer.infrastructure.config.persistence.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = "spring.layer.domain")
@EnableJpaRepositories(basePackages = "spring.layer.infrastructure.persistence")
public class JpaConfig {}
