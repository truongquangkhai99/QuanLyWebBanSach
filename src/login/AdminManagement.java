package login;

import dao.AdminDaoIplm;
import dao.IAdminDao;
import dto.AdminDto;

public class AdminManagement {
	IAdminDao adminDao = new AdminDaoIplm();
	
	public boolean checkLogin(String adName, String password) {
		AdminDto adminDto = adminDao.getAminByNameAndPass(adName, password);
		if (adminDto != null) {
			return true;
		} else {
			return false;
		}
	}

}
