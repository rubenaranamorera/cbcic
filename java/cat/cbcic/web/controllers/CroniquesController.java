package cat.cbcic.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.cbcic.web.lao.LAONoticies;
import cat.cbcic.web.models.Noticia;

@Controller
public class CroniquesController {

	@Autowired 
	private LAONoticies laoNoticies;
	
	@RequestMapping("/croniques")
	public String index(@RequestParam(value="pag",required=false, defaultValue = "0"  ) String pag, Model model) {		
		
		int pagina = Integer.valueOf(pag);			
		List<Noticia> noticiesList = laoNoticies.getPaginaN(pagina, true);		
		long totalPagines = laoNoticies.getTotalPagines(true);
		
		model.addAttribute("navActive", "croniquesNav");
		model.addAttribute("noticiesList", noticiesList);
		model.addAttribute("totalPagines", totalPagines);
		model.addAttribute("pagina", pagina);
		
		return "croniques";		
	}		

}
