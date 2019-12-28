package io.swagger.api.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean(name = "msqldb")
    @ConfigurationProperties(prefix = "spring.mysql-db")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "msqlJdbcTemplate")
    public JdbcTemplate jedbcTemplate(@Qualifier("msqldb")DataSource dsMsql) {
        return new JdbcTemplate(dsMsql);
    }
}
