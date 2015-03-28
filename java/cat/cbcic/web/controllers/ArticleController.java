package cat.cbcic.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.cbcic.web.lao.LAONoticies;
import cat.cbcic.web.models.Noticia;

@Controller
public class ArticleController {


	@Autowired 
	private LAONoticies laoNoticies;
	
	@RequestMapping("/article")
	public String index(Model model, @RequestParam("idNoticia") String idNoticia) {		
				
		Noticia noticia = laoNoticies.getNoticiaById(Integer.parseInt(idNoticia));
		
		model.addAttribute("noticia", noticia);		
		
		return "article";		
	}	

}
