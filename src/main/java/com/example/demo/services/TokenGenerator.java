package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.example.demo.card.Card;
import com.example.demo.cardMetadata.CardMetadata;
import com.example.demo.token.Token;

public class TokenGenerator {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Token getToken(Card card) throws Exception{
		//1. extract bin from card, 2. request for cardMetadata, 3. generate token
		try {
			String bin = this.getBin(card.getPan());
			log.info("result bin: " + bin);
			CardMetadata cardMetadata = this.getCardMetadata(bin);
			log.info("card Scheme: " + cardMetadata.getScheme());
			Token token = new Token(card.getPan(), card.getExp_month(), card.getExp_year(), cardMetadata.getScheme());
			return token;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
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
