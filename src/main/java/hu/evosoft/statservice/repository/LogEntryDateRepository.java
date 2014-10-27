package hu.evosoft.statservice.repository;

import hu.evosoft.statservice.pojo.LogEntryDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * Repository for download by time statistics.
 * 
 * @author Karandi Tamas
 */
@Repository
public class LogEntryDateRepository {

	private MongoOperations mongoOperations;
	
	@Autowired
    public void setMongoOperations(MongoOperations mongoOps) {
        this.mongoOperations = mongoOps;
    }
	
	public List<LogEntryDate> findAll() {
		return mongoOperations.findAll(LogEntryDate.class);
	}
}