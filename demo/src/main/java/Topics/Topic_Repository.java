package Topics;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//crudRepository contains some predefined methods to perform the general operations with defination in it
//also crud is generic hence needs class type info and primary key data type info since 
//to return the object of topic when queried from database
@Repository
public interface Topic_Repository extends CrudRepository<Topic, String> {

}
