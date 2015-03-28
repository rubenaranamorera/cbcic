package cat.cbcic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HistoriaController {

	@RequestMapping("/historia")
	public String index(Model model) {		
		model.addAttribute("navActive", "historiaNav");
		return "historia";		
	}	

}
