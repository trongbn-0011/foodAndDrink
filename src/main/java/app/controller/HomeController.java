package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String indexHomepage() {
		return "index";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
