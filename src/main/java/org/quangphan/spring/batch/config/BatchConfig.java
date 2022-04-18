package org.quangphan.spring.batch.config;

import org.quangphan.spring.batch.item.Processor;
import org.quangphan.spring.batch.item.Reader;
import org.quangphan.spring.batch.item.Writer;
import org.quangphan.spring.batch.listener.MyJobListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    @Bean
    public Reader reader() {
        return new Reader();
    }

    @Bean
    public ItemWriter<String> stringItemWriter() {
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
