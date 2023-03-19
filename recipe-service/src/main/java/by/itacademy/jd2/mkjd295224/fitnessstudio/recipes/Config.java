package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.mapper.PageMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

@Configuration
public class Config {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(Page.class, PageMapper.class);
        return objectMapper;
    }
}
