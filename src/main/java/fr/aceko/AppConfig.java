package fr.aceko;

import fr.aceko.infrastructure.PostgresConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "fr.aceko")
public class AppConfig {

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(PostgresConnection.driver);
        dataSource.setUrl(PostgresConnection.url);
        dataSource.setUsername(PostgresConnection.user);
        dataSource.setPassword(PostgresConnection.password);
        return dataSource;
    }
}
