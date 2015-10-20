package cat.cbcic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlaysController {

	@RequestMapping("/plays")
	public String index(Model model) {
		return "plays";
	}	

}
