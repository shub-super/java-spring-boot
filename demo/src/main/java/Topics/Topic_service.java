package Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


@Service
public class Topic_service {

	@Autowired
	private Topic_Repository tr;
	
	/*List<Topic> topic = new ArrayList<>(Arrays.asList(
			new Topic("Spring","java","spring framework"),
			new Topic("Mongo","Database","Schemaless"),
			new Topic("Powershell","Scripting","infrastructure")
			));
	*/
	public List<Topic> getAlltopic(){
		List<Topic> topics =new ArrayList<>();
		tr.findAll().forEach(topics::add);
		return topics;
		
	}
	//for caching the request with the id as the parameter the cache entry is stored on
	//users machine time reduced from 4.3 s to 0.1 s
	@Cacheable(value="Topic-Cache" , key="'Topic-cachee'+#id")
	public Topic getATopic(String id) throws InterruptedException {
		Thread.sleep(4000);
		Topic t;
		t=tr.findById(id).get();
	return t;
	
		//return topic.stream().filter(t -> t.getName().equals(id)).findFirst().get();
	}

	public void addTopic(Topic t) {
		tr.save(t);
		
	}

	public void updateTopic(Topic t, String id) {
		tr.save(t);
		
	}

	public void deleteTopic(String id) {
		tr.deleteById(id);
		//topic.removeIf(t -> t.getName().equals(id));
		
	}
	
	
}
