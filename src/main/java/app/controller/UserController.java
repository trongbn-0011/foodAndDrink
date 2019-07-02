package app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.model.User;
import app.service.UserService;
import validate.UserValidation;

@Controller
@PropertySource("classpath:messages.properties")
@PropertySource("classpath:constants.properties")
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
	@Value("${defaultUserPage}")
	private int defaultPage;
	@Value("${defaultUserPageSize}")
	private int defaultPageSize;

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

	@PostMapping(value = "/registerProcess")
	public String register(@ModelAttribute("user") User user, BindingResult result) {
		UserValidation validation = new UserValidation();
		validation.validate(user, result);
		if (result.hasErrors()) {
			return "register";
		} else {
			userService.createUser(user);
		}
		return "index";
	}

	@GetMapping("/register")
	public String register(ModelMap modelMap) {
		modelMap.addAttribute("user", new User());
		return "register";
	}
	
	@GetMapping(value = "/users")
	public String index(Model model, @RequestParam("search") Optional<String> search, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(defaultPage);
	    int pageSize = size.orElse(defaultPageSize);
	    String userName = search.orElse("");
	    
	    Page<User> users = userService.loadUsers(userName, PageRequest.of(currentPage - 1, pageSize));
	    
	    model.addAttribute("search", userName);
	    model.addAttribute("users", users);
	    
	    int totalPages = users.getTotalPages();
        
	    if (totalPages > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
	    return "users/users";
	}
	
}
