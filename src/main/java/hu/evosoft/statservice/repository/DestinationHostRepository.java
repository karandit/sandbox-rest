package hu.evosoft.statservice.repository;

import hu.evosoft.statservice.pojo.DestinationHost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * Repository for downloads by domain.
 * 
 * @author Karandi Tamas
 */
@Repository
public class DestinationHostRepository {

	private MongoOperations mongoOperations;
	
	@Autowired
	public void setMongoOperations(MongoOperations mongoOps) {
		this.mongoOperations = mongoOps;
	}
	
	public List<DestinationHost> findAll() {
		return mongoOperations.findAll(DestinationHost.class);
	}
}