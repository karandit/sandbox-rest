package hu.evosoft.statservice.endpoint;

import hu.evosoft.statservice.pojo.DestinationHost;
import hu.evosoft.statservice.pojo.LogEntryDate;
import hu.evosoft.statservice.repository.DestinationHostRepository;
import hu.evosoft.statservice.repository.LogEntryDateRepository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatController {
	
	@Autowired private LogEntryDateRepository logEntryDateRepository;
	@Autowired private DestinationHostRepository destinationHostrepository;
	
	@PostConstruct
	public void initIt() throws Exception {
	  System.out.println("StatController.initIt()");
	}
	
	@RequestMapping(value = "/byTime", method = RequestMethod.GET)
	List<LogEntryDate> byTime() {
		List<LogEntryDate> found = logEntryDateRepository.findAll();
		System.out.println("StatByTimeController.list() " + found.size());
		return found;
	}
	
	@RequestMapping(value = "/byDomain", method = RequestMethod.GET)
	List<DestinationHost> byDomain() {
		List<DestinationHost> found = destinationHostrepository.findAll();
		System.out.println("StatByDomainController.list(): " + found.size());
		return found;
	}

	
}
