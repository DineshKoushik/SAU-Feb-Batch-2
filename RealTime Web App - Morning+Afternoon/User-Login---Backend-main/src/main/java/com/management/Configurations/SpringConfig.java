package com.management.Configurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@SuppressWarnings("deprecation")
@SpringBootApplication
@ComponentScan(basePackages = "com.management") // to let spring know where are controllers, services, beans etc.
public class SpringConfig {

//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/order_management_fullstack");
//        dataSource.setUsername("auadmin");
//        dataSource.setPassword("AbhiHydra629@@");
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.setResultsMapCaseInsensitive(true);
//        return jdbcTemplate;
//    }

    public static void main(String[] args) {
        System.out.println("Starting Order Management FullStack Application on port 8000");
        SpringApplication.run(SpringConfig.class, args);
        System.out.println("Started Order Management FullStack Application on port 8000\n");
    }
}