package com.example.covidservice.remoteDataSource;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;

// Create a CodecRegistry containing the PojoCodecProvider instance.


public class InsertPojoToMongoTask {

    public MongoDatabase getMongoDatabase(String dbName) {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase(dbName);
        database = database.withCodecRegistry(pojoCodecRegistry);
        return database;
    }

    public <Country> void saveCountry(Country country){
        String dbName = "covid";
        MongoDatabase database = getMongoDatabase(dbName);
        MongoCollection<Country> collection = (MongoCollection<Country>) database.getCollection(country.getClass().getSimpleName(), country.getClass());
        collection.insertOne(country);
    }

    public <Global> void saveGlobal(Global global){
        String dbName = "covid";
        MongoDatabase database = getMongoDatabase(dbName);
        MongoCollection<Global> collection = (MongoCollection<Global>) database.getCollection(global.getClass().getSimpleName(), global.getClass());
        collection.insertOne(global);
    }
}
