package dao;

import dto.AdminDto;

public interface IAdminDao {
	public AdminDto getAminByNameAndPass(String adName, String password);

	//public boolean checkLogin(String adName, String password);



}
