package app.controller;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.model.User;
import app.service.UserService;

@Controller
@PropertySource("classpath:messages.properties")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Value("${messages.logout}")
	private String msg_logout;
	@Value("${messages.nouserfound}")
	private String msg_nouserfound;
	@Value("${messages.danger}")
	private String danger;

	public UserService getUserService() {
		return userService;
	}

	@PostMapping("/welcome")
	public String welcome(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request) {

		User user = getUserService().findByUsenameAndPassword(username, password);
		if (user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("name", user.getName());
			return "welcome";
		}
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.setAttribute("message", msg_logout);
		session.invalidate();
		return "login";
	}

	@GetMapping(value = "users/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		logger.info("detail student");
		User user = userService.findById(id);
		if (user != null) {
			model.addAttribute("user", user);
			return "users/user";
		}

		model.addAttribute("css", danger);
		model.addAttribute("msg", msg_nouserfound);
		return "error";
	}

}
