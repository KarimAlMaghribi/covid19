package com.example.mongoData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class MongoDataApplication extends AbstractReactiveMongoConfiguration {

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create();
	}



	@Override
	protected String getDatabaseName() {
		return "reactive";
	}
}


