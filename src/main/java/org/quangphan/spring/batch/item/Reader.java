package org.quangphan.spring.batch.item;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

    private String[] courses = {"JWS", "Two", "Angular"};
    private int count;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (count < courses.length) {
            return courses[count++];
        }

        count = 0;

        return null;
    }
}
