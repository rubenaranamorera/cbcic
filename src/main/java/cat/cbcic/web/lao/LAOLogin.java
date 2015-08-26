package cat.cbcic.web.lao;

import cat.cbcic.web.dao.DAOUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class LAOLogin {

	@Autowired 
	private DAOUsers daoUsers;

	public boolean checkUserAndPassword (String user, String password){
		return daoUsers.checkUserAndPassword(user, password);
	}

	public boolean isSuperAdmin(String user){
		return daoUsers.isSuperAdmin(user);
	}

	public boolean createUser(String user, String password,boolean admin, boolean superAdmin, String email){

		return daoUsers.createUser(user, password, admin, superAdmin, email);
	}

}
