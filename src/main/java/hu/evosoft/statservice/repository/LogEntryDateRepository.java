package hu.evosoft.statservice.repository;

import hu.evosoft.statservice.pojo.LogEntryDate;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class LogEntryDateRepository {

	@Autowired
	private MongoOperations mongoOperations;
	
	@PostConstruct
	public void initIt() throws Exception {
		System.out.println("LogEntryDateRepository.initIt()");
	}
	
	public List<LogEntryDate> findAll() {
		return mongoOperations.findAll(LogEntryDate.class);
	}
}