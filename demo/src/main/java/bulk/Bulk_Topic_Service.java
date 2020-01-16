package bulk;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Topics.Topic;
import Topics.Topic_service;

@Service
public class Bulk_Topic_Service {

	@Autowired
	Topic_service ts;
	
	@Transactional
	public void insert() {
		
		List<Topic> t=new ArrayList<>();
		Topic t1=new Topic("3","mongo","database");
		ts.addTopic(t1);
		Topic t2=new Topic("","Security","");
		ts.addTopic(t2);
		
	}
	
	
	
	
}
