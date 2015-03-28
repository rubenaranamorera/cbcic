package cat.cbcic.web.lao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cat.cbcic.web.dao.DAOStaff;
import cat.cbcic.web.models.StaffMember;

@Component 
public class LAOStaff {

	@Autowired 
	private DAOStaff daoStaff;
	
	public List<StaffMember> getStaffMembersByEquip(int idEquip) {
		
		ArrayList<StaffMember> staffMembersList = daoStaff.getStaffMembersByEquip(idEquip);
		return staffMembersList;
	}
	
	
}
