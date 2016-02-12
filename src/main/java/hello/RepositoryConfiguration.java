package hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by libinsalal on 2/8/16.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"hello"})
@EnableJpaRepositories(basePackages = "hello")
public class RepositoryConfiguration {

}
