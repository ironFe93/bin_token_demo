package com.example.demo.services;

import org.springframework.web.client.RestTemplate;

import com.example.demo.card.Card;
import com.example.demo.cardMetadata.CardMetadata;
import com.example.demo.token.Token;

public class TokenGenerator {
	
	public Token getToken(Card card) throws Exception{
		//1. extract bin from card, 2. request for cardMetadata, 3. generate token
		try {
			String bin = this.getBin(card.getPan());
			CardMetadata cardMetadata = this.getCardMetadata(bin);
			Token token = new Token(card.getPan(), card.getExp_month(), card.getExp_year(), cardMetadata.getScheme());
			return token;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private String getBin(String pan) throws Exception{
		return pan.substring(0, 5);
	}
	
	private CardMetadata getCardMetadata(String bin) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://lookup.binlist.net/" + bin, CardMetadata.class);
	}

}
