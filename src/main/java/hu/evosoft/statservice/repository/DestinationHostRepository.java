package hu.evosoft.statservice.repository;

import hu.evosoft.statservice.pojo.DestinationHost;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class DestinationHostRepository {

	@Autowired
	private MongoOperations mongoOperations;
	
	@PostConstruct
	public void initIt() throws Exception {
		System.out.println("DestinationHostRepository.initIt()");
	}
	
	public List<DestinationHost> findAll() {
		return mongoOperations.findAll(DestinationHost.class);
	}
}