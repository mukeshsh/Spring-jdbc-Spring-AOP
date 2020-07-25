package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages= "com.nt.dao")
public class PersistenceConfig {
    
	@Bean
	public DataSource CreateDs() {
		HikariDataSource ds=null;
		ds=new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("ronaldo");
		ds.setPassword("messi_1");
		ds.setMinimumIdle(10);
		return ds;
	}
	public JdbcTemplate createTemplate() {
		return new JdbcTemplate(CreateDs());
	}
}
