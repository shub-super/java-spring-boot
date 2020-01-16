package Courses;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Topics.Topic;


//controller
@RestController
public class Course_handler {
	
	@Autowired
	private Course_service cs;

	@RequestMapping("/topic/{id}/course")
	public List<Course> Course_method(@PathVariable String id) {
		return cs.getAllcourse(id);			
	}
	
	@RequestMapping("/topic/{id}/course/{courseid}")
	public Course getCourse(@PathVariable String courseid) {
		return cs.getACourse(courseid);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topic/{topicId}/course")
	public void addCourse(@RequestBody Course r,@PathVariable String topicId) {
		r.setTopic(new Topic(topicId,"",""));
		cs.addCourse(r);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{topicId}/course/{courseid}")
	public void updateCourse(@RequestBody Course r,@PathVariable String topicId) {
		r.setTopic(new Topic(topicId,"",""));
		cs.updateCourse(r);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{topicid}/course/{id}")
	public void deleteCourse(@PathVariable String id) {
		cs.deleteCourse(id);
	}
}
