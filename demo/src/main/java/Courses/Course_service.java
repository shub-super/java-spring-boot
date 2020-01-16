package Courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


@Service
public class Course_service {

	@Autowired
	private Course_Repository cr;
	
	/*List<Topic> topic = new ArrayList<>(Arrays.asList(
			new Topic("Spring","java","spring framework"),
			new Topic("Mongo","Database","Schemaless"),
			new Topic("Powershell","Scripting","infrastructure")
			));
	*/
	public List<Course> getAllcourse(String topicId){
		List<Course> courses =new ArrayList<>();
		cr.findByTopicId(topicId).forEach(courses::add);
		return courses;
		
	}
	
	public Course getACourse(String id) {
		Course t;
		t=cr.findById(id).get();
	return t;
	
		//return topic.stream().filter(t -> t.getName().equals(id)).findFirst().get();
	}

	public void addCourse(Course t) {
		cr.save(t);
		
	}

	public void updateCourse(Course t) {
		cr.save(t);
		
	}

	public void deleteCourse(String id) {
		cr.deleteById(id);
		//topic.removeIf(t -> t.getName().equals(id));
		
	}
	
	
}
