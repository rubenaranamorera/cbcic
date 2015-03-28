package cat.cbcic.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.cbcic.web.lao.LAONoticies;
import cat.cbcic.web.models.Noticia;

@Controller
public class HomeController {

	
	@Autowired 
	private LAONoticies laoNoticies;
	
	
	@RequestMapping("/home")
	public String index(Model model) {				
		Noticia noticia = laoNoticies.getHomeNoticia();
		model.addAttribute("noticia", noticia);	
		List<Noticia> noticiesList = laoNoticies.getLastNNoticiesWithoutNoticia(noticia.getIdNoticia(), LAONoticies.NUM_NOTICIES_HOME);		
		model.addAttribute("noticiesList", noticiesList);
		return "home";		
	}	

}
