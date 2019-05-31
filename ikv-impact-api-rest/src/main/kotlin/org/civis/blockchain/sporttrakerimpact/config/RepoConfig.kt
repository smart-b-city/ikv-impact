package org.civis.blockchain.sporttrakerimpact.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.civis.blockchain.sporttrakerimpact.repository.RepositoryFactory
import org.civis.blockchain.sporttrakerimpact.strava.StravaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RepoConfig {

    @Bean
    protected fun objectMapper(): ObjectMapper {
        return ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .registerModule(KotlinModule())
                .registerModule(JavaTimeModule())
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
    }

    @Bean
    protected fun stravaRepository(objectMapper: ObjectMapper): StravaRepository {
        return RepositoryFactory().buildStravaRepository(objectMapper);
    }


}