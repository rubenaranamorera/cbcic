package cat.cbcic.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.cbcic.web.lao.LAOEquips;
import cat.cbcic.web.lao.LAOJugadors;
import cat.cbcic.web.lao.LAOStaff;
import cat.cbcic.web.models.Equip;
import cat.cbcic.web.models.Jugador;
import cat.cbcic.web.models.StaffMember;

@Controller
public class EquipsController {
	
	@Autowired 
	private LAOEquips laoEquips;
	
	@Autowired 
	private LAOJugadors laoJugadors;
	
	@Autowired 
	private LAOStaff laoStaff;

	@RequestMapping("/senioramasc")
	public String senioramasc (Model model){		
		model.addAttribute("navActive", "equipsNav");
		model = getInfo(model, LAOEquips.EQUIP_SENIOR_A_MASC);		
		return "equips";		
	}
	
		
	private Model getInfo(Model m, int idEquip) {
		Equip equip = laoEquips.getEquipById(idEquip);
		List<Jugador> jugadorsList = laoJugadors.getJugadorsByEquip(idEquip);
		List<StaffMember> staffMembersList = laoStaff.getStaffMembersByEquip(idEquip);
		m.addAttribute("equip",equip);
		m.addAttribute("jugadorsList",jugadorsList);
		m.addAttribute("staffMembersList", staffMembersList);
		return m;
	}
	
	@RequestMapping("/seniorbmasc")
	public String seniorbmasc (Model model) {
		model.addAttribute("navActive", "equipsNav");
		model = getInfo(model, LAOEquips.EQUIP_SENIOR_B_MASC);
		return "equips";
	}
	
	@RequestMapping("/juniormasc")
	public String juniormasc(Model model) {
		model.addAttribute("navActive", "equipsNav");
		model = getInfo(model, LAOEquips.EQUIP_JUNIOR_MASC);
		return "equips";		
	}
	
	@RequestMapping("/seniorafem")
	public String seniorafem(Model model) {
		model.addAttribute("navActive", "equipsNav");
		model = getInfo(model, LAOEquips.EQUIP_SENIOR_A_FEM);
		return "equips";		
	}
	
	@RequestMapping("/seniorbfem")
	public String seniorbfem(Model model) {
		model.addAttribute("navActive", "equipsNav");
		model = getInfo(model, LAOEquips.EQUIP_SENIOR_B_FEM);
		return "equips";		
	}
	
	@RequestMapping("/sots21fem")
	public String sots25fem(Model model) {
		model.addAttribute("navActive", "equipsNav");
		model = getInfo(model, LAOEquips.EQUIP_SUB21_FEM);
		return "equips";		
	}
	
	@RequestMapping("/veterans")
	public String veterans(Model model) {
		model.addAttribute("navActive", "equipsNav");
		model = getInfo(model, LAOEquips.EQUIP_VETERANS);
		return "equips";		
	}

}
