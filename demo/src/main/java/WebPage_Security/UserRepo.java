package WebPage_Security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Details, Integer> {
 Details findByUsername(String username);
}
