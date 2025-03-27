package com.zari.springboot.todo.webapp.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class welcomeController {

	@RequestMapping("/")
	public String goToWelcomePage(ModelMap model) {
			model.put("name", getLoggedInUsername());
			return "welcomePage";
	}

	private String getLoggedInUsername(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
