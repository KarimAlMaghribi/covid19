package com.example.serviceregistrationanddiscoveryclient;

import com.example.serviceregistrationanddiscoveryclient.dto.model.CountryDTO;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.*;
import com.example.serviceregistrationanddiscoveryclient.repository.CountryRepository;
import com.example.serviceregistrationanddiscoveryclient.service.DataService;
import com.example.serviceregistrationanddiscoveryclient.service.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceRegistrationAndDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistrationAndDiscoveryClientApplication.class, args);
	}


	@Bean
	CommandLineRunner covidDataToMongo() {
		DataService service = new DataServiceImpl();
		return args ->
				System.out.println(service.getAllCountries());
				//updateDB();

	}
	private void updateDB() {
		RetrieveDataTask apiTask = new RetrieveDataTask();
		InsertPojoToMongoTask mongoTask = new InsertPojoToMongoTask();

		List<Country> countryList = apiTask.getCountryList();
		Global globals = apiTask.getGlobalData();

		mongoTask.saveGlobal(globals);

		mongoTask.drobCountryCollection(countryList.get(0));
		for( Country country: countryList) {
			mongoTask.saveCountry(country);
		}
	}
}




@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
}
