package poe.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class HomePageController {

	@GetMapping
	public String index (Model model) {
		model.addAttribute("message", "Welcome here!");
		return "index";
	}
	
}
