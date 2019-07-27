package dto;

public class AdminDto {
	
	private String adminName;
	private String adPassword;
	private String adFirstName;
	private String adLastName;
	private String adGender;
	private String adEmail;
	private String adPhone;
	private String adAddress;
	
	public AdminDto() {
		
	}
	
	public AdminDto(String adminName, String adPassword, String adFirstName, String adLastName, String adGender,
			String adEmail, String adPhone, String adAddress) {
		
		this.adminName = adminName;
		this.adPassword = adPassword;
		this.adFirstName = adFirstName;
		this.adLastName = adLastName;
		this.adGender = adGender;
		this.adEmail = adEmail;
		this.adPhone = adPhone;
		this.adAddress = adAddress;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdPassword() {
		return adPassword;
	}
	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}
	public String getAdFirstName() {
		return adFirstName;
	}
	public void setAdFirstName(String adFirstName) {
		this.adFirstName = adFirstName;
	}
	public String getAdLastName() {
		return adLastName;
	}
	public void setAdLastName(String adLastName) {
		this.adLastName = adLastName;
	}
	public String getAdGender() {
		return adGender;
	}
	public void setAdGender(String adGender) {
		this.adGender = adGender;
	}
	public String getAdEmail() {
		return adEmail;
	}
	public void setAdEmail(String adEmail) {
		this.adEmail = adEmail;
	}
	public String getAdPhone() {
		return adPhone;
	}
	public void setAdPhone(String adPhone) {
		this.adPhone = adPhone;
	}
	public String getAdAddress() {
		return adAddress;
	}
	public void setAdAddress(String adAddress) {
		this.adAddress = adAddress;
	}
	
	

}
