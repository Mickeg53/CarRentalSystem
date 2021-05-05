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
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
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
        @ComponentScan
        public class WebConfigMvc extends WebMvcConfigurerAdapter {

            @Bean
            public ViewResolver viewResolver () {
                InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
                viewResolver.setViewClass(JstlView.class);
                viewResolver.setPrefix("/WEB-INF/jsp/"); //this is location you put jsp
                viewResolver.setSuffix(".jsp");
                return viewResolver;
            }

            @Override
            public void configureViewResolvers(ViewResolverRegistry registry){
                InternalResourceViewResolver resolver = new InternalResourceViewResolver();
                resolver.setPrefix("/WEB-INF/jsp/");
                resolver.setSuffix(".jsp");
                resolver.setViewClass(JstlView.class);
                registry.viewResolver(resolver);
            }
        }

	}

	public static void main(String[] args) {
		SpringApplication.run(CarRentalProjectApplication.class, args);

	}
}
