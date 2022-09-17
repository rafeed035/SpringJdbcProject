package JdbcConfig;

import RepositoryImplementation.BrandRepositoryImplementation;
import RepositoryImplementation.CategoryRepositoryImplementation;
import RepositoryImplementation.ProductRepositoryImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {

    @Bean
    public DriverManagerDataSource getDriverManagerDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring_core_db");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("rafeed2030");

        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDriverManagerDataSource());

        return jdbcTemplate;
    }

    @Bean
    public CategoryRepositoryImplementation getCategoryRepositoryImplementation(){
        return new CategoryRepositoryImplementation();
    }

    @Bean
    public BrandRepositoryImplementation getBrandRepositoryImplementation(){
        return new BrandRepositoryImplementation();
    }

    @Bean
    public ProductRepositoryImplementation getProductRepositoryImplementation(){
        return new ProductRepositoryImplementation();
    }
}
