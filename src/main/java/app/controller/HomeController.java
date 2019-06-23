package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String indexHomepage() {
		return "index.html";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact.html";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu.html";
	}
}
