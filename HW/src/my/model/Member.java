package my.model;

import java.util.Date;

public class Member {
	private int memberId;
	private String userId;
	private String password;
	private String name;
	private Date birthDate;
	public Member(){};
	
	public Member( String userId, String password, String name, Date birthDate) {
		super();
	
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
