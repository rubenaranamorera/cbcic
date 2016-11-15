package cat.cbcic.web.lao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cat.cbcic.web.dao.DAOEquips;
import cat.cbcic.web.models.Equip;

@Component
public class LAOEquips {

	public static int EQUIP_SENIOR_A_MASC = 1;
	public static int EQUIP_SENIOR_B_MASC = 2;
	public static int EQUIP_SUB21_MASC = 4;
	public static int EQUIP_SENIOR_A_FEM = 5;
	public static int EQUIP_SENIOR_B_FEM = 6;
	public static int EQUIP_VETERANS = 8;

	@Autowired
	private DAOEquips daoEquips;

	public Equip getEquipById (int idEquip){
		return daoEquips.getEquipById(idEquip);
	}


}
