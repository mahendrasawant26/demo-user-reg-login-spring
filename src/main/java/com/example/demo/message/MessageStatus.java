package com.example.demo.message;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class MessageStatus<T> {

	@JsonInclude(Include.NON_NULL)
	private int StatusCode;
	@JsonInclude(Include.NON_NULL)
	private String message;
	@JsonInclude(Include.NON_NULL)
	private String tokenId;
	

	@JsonInclude(Include.NON_NULL)
	private T data;
	
	
	public MessageStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MessageStatus(String message,int statusCode) {
		super();
		this.StatusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}