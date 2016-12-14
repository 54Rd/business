package org.business.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by wangz on 2016/11/21.
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "mainDataSrc")
    @Qualifier("mainDataSrc")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mainDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mainTemplate")
    public JdbcTemplate mainJdbcTemplate(@Qualifier("mainDataSrc") DataSource dataSource) {
        return new JdbcTemplate(dataSource);

    }
}
