package entity;

import java.io.Serializable;

public class Desktype implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String deskcode;
	
	private String desktype;
	
	private String personNum;
	
	private Integer deskNum;
	
	private Integer freeDeskNum;	

	public String getDeskcode() {
		return deskcode;
	}

	public void setDeskcode(String deskcode) {
		this.deskcode = deskcode;
	}

	public String getDesktype() {
		return desktype;
	}

	public void setDesktype(String desktype) {
		this.desktype = desktype;
	}

	public String getPersonNum() {
		return personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

	public Integer getDeskNum() {
		return deskNum;
	}

	public void setDeskNum(Integer deskNum) {
		this.deskNum = deskNum;
	}

	public Integer getFreeDeskNum() {
		return freeDeskNum;
	}

	public void setFreeDeskNum(Integer freeDeskNum) {
		this.freeDeskNum = freeDeskNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Desktype [desktype=" + desktype + ", personNum=" + personNum + ", deskNum=" + deskNum + ", freeDeskNum="
				+ freeDeskNum + "]";
	}
	
	
}
