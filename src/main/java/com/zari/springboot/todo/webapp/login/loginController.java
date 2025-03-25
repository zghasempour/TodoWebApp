package com.zari.springboot.todo.webapp.login;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class loginController {
	private AuthenticationService authenticationService;
	
	
	public loginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	/*private Logger logger = LoggerFactory.getLogger(getClass());
	@RequestMapping("/login")
	public String login(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		//logger.debug("Request Param Is {}",name);
		return "login";	
	}
*/	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";	
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			return "welcomePage";	
		}
		model.put("errorMessage", "Invalid Credentials! Please Try Again!");
		return "login";	
	}
}
