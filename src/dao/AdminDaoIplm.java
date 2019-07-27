package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.AdminDto;

public class AdminDaoIplm implements IAdminDao {

	
	@Override
	public AdminDto getAminByNameAndPass(String adName, String adPassword) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ADMINS WHERE User_Name = '" + adName + "'" + " AND PASSWORD = '" + adPassword + "'");
			if (rs.next()) {
				AdminDto adminDto = new AdminDto();
				adminDto.setAdminName(rs.getString("User_Name"));
				adminDto.setAdPassword(rs.getString("Password"));
				adminDto.setAdFirstName(rs.getString("First_Name"));
				adminDto.setAdLastName(rs.getString("First_Name"));
				adminDto.setAdGender(rs.getString("Gender"));
				adminDto.setAdEmail(rs.getString("Email"));
				adminDto.setAdPhone(rs.getString("Phone"));
				adminDto.setAdAddress(rs.getString("Address"));

				return adminDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	
	}
	
	
	
}
