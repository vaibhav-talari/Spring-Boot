package spring.core.boot.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/library")
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcomeHome()
	{
		return "welcome";
	}
	
	
}
