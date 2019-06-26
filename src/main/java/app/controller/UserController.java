package app.controller;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.model.User;
import app.service.UserService;

@Controller
@PropertySource("classpath:messages.properties")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Value("${messages.logout}")
	private String msg_logout;

	public UserService getUserService() {
		return userService;
	}

	@PostMapping("/welcome")
	public String welcome(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		User user = getUserService().findByUsenameAndPassword(username, password);
		if (user != null) {
			model.addAttribute("name", user.getName());
			return "welcome";
		}
		return "login";
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("message", msg_logout);
		return "login";
	}
}
