package my.home.jkits.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class DataSourceConfig {
    @Bean
    //@Primary
    public DataSource createPostgresDataSource(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.login}") String login,
            @Value("${spring.datasource.password}") String password
    ) {
        Objects.requireNonNull(password, "DB password for login: '" + login + "' is null");

        DataSourceBuilder<BasicDataSource> dataSourceBuilder = DataSourceBuilder.create().type(BasicDataSource.class);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(login);
        dataSourceBuilder.password(password);

        BasicDataSource ds = dataSourceBuilder.build();
        ds.setValidationQueryTimeout(30);
        ds.setFastFailValidation(true);
        ds.setTestOnBorrow(true);
        ds.setConnectionProperties("prepareThreshold=0");

        return ds;
    }
}