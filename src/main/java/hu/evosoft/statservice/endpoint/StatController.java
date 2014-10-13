package hu.evosoft.statservice.endpoint;

import hu.evosoft.statservice.pojo.DestinationHost;
import hu.evosoft.statservice.pojo.LogEntryDate;
import hu.evosoft.statservice.repository.DestinationHostRepository;
import hu.evosoft.statservice.repository.LogEntryDateRepository;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
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
		return found;
	}
	
	@RequestMapping(value = "/byDomain", method = RequestMethod.GET)
	List<DestinationHost> byDomain() {
		List<DestinationHost> found = destinationHostrepository.findAll();
		found.sort(DestinationHostComparator.INSTANCE);
		
		List<DestinationHost> top100 = new LinkedList<DestinationHost>();
		Iterator<DestinationHost> iterator = found.iterator();
		int threshold = 100;
		int current = 0;
		while (iterator.hasNext() && current < threshold) {
			top100.add(iterator.next());
			current++;
		}
		return top100;
	}

	/**
	 * Sorts the 'download by domain' statistics in a descending order. 
	 */
	private enum DestinationHostComparator implements Comparator<DestinationHost> {
		INSTANCE;
		
		public int compare(DestinationHost o1, DestinationHost o2) {
			return o2.getValue()  - o1.getValue();
		}
	}
	
}
