package com.example.demo.card;

public class Card {
	
	private String pan;
	private int exp_year;
	private int exp_month;
	
	public Card() {
	}
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getExp_year() {
		return exp_year;
	}
	public void setExp_year(int exp_year) {
		this.exp_year = exp_year;
	}
	public int getExp_month() {
		return exp_month;
	}
	public void setExp_month(int exp_month) {
		this.exp_month = exp_month;
	}

	@Override
	public String toString() {
		return "Card [pan=" + pan + ", exp_year=" + exp_year + ", exp_month=" + exp_month + "]";
	}
	
	
	
	

}
