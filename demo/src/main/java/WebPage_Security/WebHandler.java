package WebPage_Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebHandler {

	@RequestMapping(method=RequestMethod.GET,value="/home")
	public String getHome() {
		return "home.jsp";
	}
	@RequestMapping(method=RequestMethod.GET,value="/login")
	public String getLogin() {
		return "login.jsp";
	}
	@RequestMapping(method=RequestMethod.GET,value="/logout-success")
	public String getLogout() {
		return "logout.jsp";
	}
	@RequestMapping(method=RequestMethod.GET,value="/admin")
	public String getAdmin() {
		return "admin.jsp";
	}
	@RequestMapping(method=RequestMethod.GET,value="/user")
	public String getUser() {
		return "user.jsp";
	}
}
