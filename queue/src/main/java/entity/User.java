package entity;

import java.io.Serializable;

import org.springframework.util.DigestUtils;

public class User implements Serializable{
	
	// 用户混淆MD5
	private final static String slat = "innauhixowauhoahsuw";

	private static final long serialVersionUID = 1L;

	private String account;
	
	private String password;
	
	private String name; 
	
	private Byte gender;
	
	private String telephone;
	
	private Byte permission;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Byte getPermission() {
		return permission;
	}

	public void setPermission(Byte permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", telephone=" + telephone + ", permission=" + permission + "]";
	}
	
	/**
	 * md5加密算法	 
	 * @param password
	 * @return
	 */
	public static String getMD5(String password) {
		String base = password + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
	
}
