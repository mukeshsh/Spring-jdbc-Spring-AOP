package config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "dao")
public class PersistenceConfig {
    
	@Bean(name="hkDs")
	public DataSource createDS() {
		HikariDataSource hkDs=null;
		hkDs=new HikariDataSource();
		hkDs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hkDs.setUsername("jdbc");
		hkDs.setPassword("class");
		hkDs.setMaximumPoolSize(20);
		hkDs.setMinimumIdle(10);
		return hkDs;
	}
	@Bean(name="template")
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createDS());
	}
}
