package com.example.demo.cardMetadata;

public class CardMetadata {
	
	private String scheme;
	private String type;
	private String brand;
	private boolean prepaid;
	
	private Number number;
	private Country country;
	private Bank bank;
	
	public CardMetadata() {
		
	}

	public String getScheme() {
		return scheme;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	public boolean isPrepaid() {
		return prepaid;
	}

	public Number getNumber() {
		return number;
	}

	public Country getCountry() {
		return country;
	}

	public Bank getBank() {
		return bank;
	}

}
