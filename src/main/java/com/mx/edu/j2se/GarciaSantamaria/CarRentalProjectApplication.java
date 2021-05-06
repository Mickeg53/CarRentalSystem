package com.mx.edu.j2se.GarciaSantamaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import javax.sql.DataSource;


@SpringBootApplication
public class CarRentalProjectApplication {

	@Configuration
	public static class DBConfig{

	    //JDBC CONFIGURATION
		@Bean
		public JdbcTemplate jdbcTemplate(DataSource dataSource) {
			return new JdbcTemplate(dataSource);
		}

		//MYSQL DATASOURCE CONFIGURATION
		@Bean
		public DataSource dataSource(){
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");		/*oracle.jdbc.driver.OracleDriver*/
			dataSource.setUrl("jdbc:mysql://localhost:3306/carrentaldb");
			dataSource.setUsername( "root" );
			dataSource.setPassword( "123456789" );
			return dataSource;
		}

		//MVC CONFIGURATION
        @EnableWebMvc
        @ComponentScan("main")
        public class WebConfigMvc implements WebMvcConfigurer {

			@Bean
			public ViewResolver internalResourceViewResolver() {
				InternalResourceViewResolver bean = new InternalResourceViewResolver();
				bean.setViewClass(JstlView.class);
				bean.setPrefix("/WEB-INF/jsp/");
				bean.setSuffix(".jsp");
				return bean;
			}
        }

	}

	public static void main(String[] args) {
		SpringApplication.run(CarRentalProjectApplication.class, args);

	}
}
