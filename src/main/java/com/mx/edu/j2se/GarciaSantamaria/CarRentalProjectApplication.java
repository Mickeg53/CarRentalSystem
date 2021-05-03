package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class CarRentalProjectApplication {

	@Configuration
	public static class DBConfig{

		@Bean
		public JdbcTemplate jdbcTemplate(DataSource dataSource) {
			return new JdbcTemplate(dataSource);
		}

		@Bean
		public DataSource dataSource(){
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");		/*oracle.jdbc.driver.OracleDriver*/
			dataSource.setUrl("jdbc:mysql://localhost:3306/carrentaldb");
			dataSource.setUsername( "root" );
			dataSource.setPassword( "123456789" );
			return dataSource;
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(CarRentalProjectApplication.class, args);

	}
}
