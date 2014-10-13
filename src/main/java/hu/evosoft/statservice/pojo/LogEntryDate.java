package hu.evosoft.statservice.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Stores data about the download count at a given time.
 * 
 * @author Karandi Tamas
 */
@Document(collection = "LogEntryDate")
public class LogEntryDate  {
	
	@Id
	private String id;
	private int value;
	private Long timeStamp;
	
	public LogEntryDate() {
	}
	public LogEntryDate(String id, Long timeStamp, int value) {
		this.id = id;
		this.timeStamp = timeStamp;
		this.value = value;
	}
	
	/** 
	 * @return the count of the downloads
	 */
	public int getValue() { return value; }
	public void setValue(int value) { this.value = value; }

	/**
	 * @return the time stamp. This time stamp represents a range of 10 minutes. 
	 */
	public Long getTimeStamp() { return timeStamp; }
	public void setTimeStamp(Long timeStamp) { this.timeStamp = timeStamp; }
	
	
}
