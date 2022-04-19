package org.quangphan.spring.batch.config;

import org.quangphan.spring.batch.item.Processor;
import org.quangphan.spring.batch.item.Reader;
import org.quangphan.spring.batch.item.Writer;
import org.quangphan.spring.batch.listener.MyJobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    @Autowired
    private StepBuilderFactory sbFactory;

    @Autowired
    private JobBuilderFactory jbFactory;

    @Bean
    public Step step() {
        return sbFactory.get("step1")
                .<String, String>chunk(1)
                .reader(reader())
                .writer(writer())
                .processor(processor())
                .build();
    }

    @Bean
    public Job job() {
        return jbFactory.get("job1")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(step())
                .build();
    }


    @Bean
    public Reader reader() {
        return new Reader();
    }

    @Bean
    public ItemWriter<String> writer() {
        return new Writer();
    }

    @Bean
    public ItemProcessor<String, String> processor() {
        return new Processor();
    }

    @Bean
    public MyJobListener listener() {
        return new MyJobListener();
    }

}
