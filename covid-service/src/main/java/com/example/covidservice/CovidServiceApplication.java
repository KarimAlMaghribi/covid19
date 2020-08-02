package com.example.covidservice;

import com.example.covidservice.model.entity.CountryEntity;
import com.example.covidservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CovidServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(CovidServiceApplication.class, args);
	}

}