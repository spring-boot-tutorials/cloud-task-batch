package com.example.spring_cloud_task.configuration;

import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@EnableTask
@Configuration
public class DefaultConfiguration {

    @Bean
    public HelloWorldTaskConfigurer getTaskConfigurer(DataSource dataSource) {
        return new HelloWorldTaskConfigurer(dataSource);
    }

    public class HelloWorldTaskConfigurer extends DefaultTaskConfigurer {
        public HelloWorldTaskConfigurer(DataSource dataSource){
            super(dataSource);
        }
    }
}
