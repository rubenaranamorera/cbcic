package cat.cbcic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OnsomController {

	@RequestMapping("/onsom")
	public String index(Model model) {	
		model.addAttribute("navActive", "onsomNav");
		return "onsom";		
	}	

}
