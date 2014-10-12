package hu.evosoft.statservice.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DestinationHost")
public class DestinationHost {

	@Id
	private String id;
	private String name;
	private Integer value;
	
	public DestinationHost() {
	}

	public DestinationHost(String id, String name, Integer value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	
}
