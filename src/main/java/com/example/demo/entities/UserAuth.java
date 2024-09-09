package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.operation.Generation;


@Entity
@Table(name="tbl_user_auth")
public class UserAuth {
	
	@Id	
	private String tokenId = Generation.generateRandomID();
	private Long userId;
	private Date loginTime;
	private Date expiredTime;
	private String loginip;
	private String login_useragent;
	private String firstName;
	private String lastName;
	private Date logoutTime;
    private int status;
    private String email;
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getExpiredTime() {
		return expiredTime;
	}
	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public String getLogin_useragent() {
		return login_useragent;
	}
	public void setLogin_useragent(String login_useragent) {
		this.login_useragent = login_useragent;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
   
   
	
}
