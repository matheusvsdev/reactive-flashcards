package com.matheusvsdev.reactiveflashcards.core.mongo;

import com.matheusvsdev.reactiveflashcards.core.mongo.converter.DateToOffsetDateTimeConverter;
import com.matheusvsdev.reactiveflashcards.core.mongo.converter.OffsetDateTimeToDateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableReactiveMongoAuditing(dateTimeProviderRef = "dateTimeProvider")
public class MongoConfig {

    @Bean
    MongoCustomConversions customConversions() {
        final List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new OffsetDateTimeToDateConverter());
        converters.add(new DateToOffsetDateTimeConverter());
        return new MongoCustomConversions(converters);
    }
}
