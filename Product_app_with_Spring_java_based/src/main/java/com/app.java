package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author saikiran.v
 *
 */
@Configuration
@ComponentScans(value = { @ComponentScan("com.pennat.prod.dao"), @ComponentScan("com.pennat.prod.service") })
public class app {

	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUrl("jdbc:sqlserver://192.168.1.145:1433;databaseName=training2018");
		ds.setUsername("pennant");
		ds.setPassword("zxcvbn1@");
		return ds;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbc = new JdbcTemplate();
		jdbc.setDataSource(getDataSource());
		return jdbc;
	}

}
