package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String telephone;
	
	private String deskcode;
	
	private String queueNum;
	
	private Timestamp queueDate;	
	
	private Byte status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDeskcode() {
		return deskcode;
	}

	public void setDeskcode(String deskcode) {
		this.deskcode = deskcode;
	}

	public String getQueueNum() {
		return queueNum;
	}

	public void setQueueNum(String queueNum) {
		this.queueNum = queueNum;
	}

	public Timestamp getQueueDate() {
		return queueDate;
	}

	public void setQueueDate(Timestamp queueDate) {
		this.queueDate = queueDate;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Desktype [id=" + id + ", telephone=" + telephone + ", deskcode=" + deskcode + ", queueNum=" + queueNum
				+ ", queueDate=" + queueDate + ", status=" + status + "]";
	}
}
