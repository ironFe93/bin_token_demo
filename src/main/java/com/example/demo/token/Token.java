package com.example.demo.token;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Token {
	
	private String token;
	private String brand;
	private String creation_dt;
	
	public Token(String cardNum, int exp_month, int exp_year, String brand) {
		this.token = "tkn_live_" + cardNum + "-" + exp_year + "-" + exp_month;
		this.brand = brand;
		
		LocalDateTime now = LocalDateTime.now().withMinute(0).withSecond(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
		this.creation_dt = formatDateTime;
	}
	
	public Token() {
		
	}
	
	public String getToken() {
		return token;
	}

	public String getBrand() {
		return brand;
	}

	public String getCreation_dt() {
		return creation_dt;
	}

	@Override
	public String toString() {
		return "Token [token=" + token + ", brand=" + brand + ", creation_dt=" + creation_dt + "]";
	}
	
	

}
