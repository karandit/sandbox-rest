package hu.evosoft.statservice.tests;

import hu.evosoft.statservice.repository.DestinationHostRepository;
import hu.evosoft.statservice.repository.LogEntryDateRepository;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories(basePackages = "hu.evosoft.statservice.repository", includeFilters = @ComponentScan.Filter(value = { DestinationHostRepository.class }, type = FilterType.ASSIGNABLE_TYPE))
public class MongoConfiguration {

    public @Bean DestinationHostRepository destinationHostRepository(MongoTemplate mongoTemplate) {
        DestinationHostRepository repo = new DestinationHostRepository();
        repo.setMongoOperations(mongoTemplate);
        return repo;
    }

    public @Bean LogEntryDateRepository logEntryDateRepository(MongoTemplate mongoTemplate) {
        LogEntryDateRepository repo = new LogEntryDateRepository();
        repo.setMongoOperations(mongoTemplate);
        return repo;
    }

    public @Bean MongoTemplate mongoTemplate(Mongo mongo) throws UnknownHostException {
        return new MongoTemplate(mongo, "test-db");
    }

    public @Bean Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }

}