package hu.evosoft.statservice.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}
		
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
