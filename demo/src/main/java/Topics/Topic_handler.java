package Topics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Topic_handler {
	
	@Autowired
	private Topic_service ts;

	@RequestMapping("/topic")
	public List<Topic> Topic_metod() {
		return ts.getAlltopic();			
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id) throws InterruptedException {
		return ts.getATopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topic")
	public void addTopic(@RequestBody Topic t) {
		ts.addTopic(t);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{id}")
	public void updateTopic(@RequestBody Topic t,@PathVariable String id) {
		ts.updateTopic(t,id);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{id}")
	public void deleteTopic(@PathVariable String id) {
		ts.deleteTopic(id);
	}
}
