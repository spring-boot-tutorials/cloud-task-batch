package com.example.spring_cloud_task.configuration;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    @Bean
    public Job job2() {
        return jobBuilderFactory.get("job2")
                .start(stepBuilderFactory.get("job2step1")
                        .tasklet((Tasklet) (contribution, chunkContext) -> {
                            System.out.println("This is a random job");
                            return RepeatStatus.FINISHED;
                        }).build()).build();
    }
}
