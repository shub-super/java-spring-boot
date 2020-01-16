package WebPage_Security;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

	private Details user;
	
	public UserPrincipal(Details user) {
		super();
		this.user = user;
	}

	
	//Used to assign ROLES to user
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
		//Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		//since there can be multiple role uses list
		
		if(user.getUsername().equals("shivam")) {
			
			List<GrantedAuthority> a=new LinkedList<>();
		a.add(new SimpleGrantedAuthority("ROLE_ADMIN"));//assigning role as admin
	
		return a;
		}
		else if(user.getUsername().equals("shubham")) {
			List<GrantedAuthority> a=new LinkedList<>();
			a.add(new SimpleGrantedAuthority("ROLE_USER"));
			return a;
		}
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
