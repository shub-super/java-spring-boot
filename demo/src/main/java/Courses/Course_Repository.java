package Courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//crudRepository contains some predefined methods to perform the general operations with defination in it
//also crud is generic hence needs class type info and primary key data type info since 
//to return the object of topic when queried from database
//@Repository
public interface Course_Repository extends CrudRepository<Course, String> {

	public List<Course> findByTopicId(String topicId);  //JPA automatically provides the body of this method since we have defined
	//it in certain way which is findByClassnameClassproperty(classProperty) note here class name and class property is of the class
	//to which it has been linked by a ManyToOne or other relations.
	
	
	public List<Course> findByField(String field);//method to find course with the given field in it jpa will give the defination to it
	//automatically
	
	
	/* Note all these method starts with "find" then "By" to indicate filter and finally by "Propertyname" in case the property 
	 is not a class like in case of 1 method  findByTopicId then we further need to add the property name of that class which
	 in this case is "Id"*/
}
