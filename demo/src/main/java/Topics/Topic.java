package Topics;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity      //to create a table in the database
public class Topic {
    @Id					//to mark the name field as primary key since that is necessary for the database
    private String id;
	private String field;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	public Topic() {
		
	}
	public Topic(String id, String field, String description) {
		super();
		this.id = id;
		this.field = field;
		this.description = description;
	}
	
	
}
