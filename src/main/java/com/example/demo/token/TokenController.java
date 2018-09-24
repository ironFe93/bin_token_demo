package com.example.demo.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.card.Card;
import com.example.demo.services.TokenGenerator;
import com.example.demo.token.Token;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TokenController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/tokens")
    public Token getToken(@RequestBody Card card) {
		log.info("TOKEN CONTROLLER");
		log.info("Input is: " + card.toString());
		
		TokenGenerator bs = new TokenGenerator();
		Token token;
		try {
			log.info("attempting to retrieve token...");
			token = bs.getToken(card);
			log.info("Token is: " + token.toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			token = null;
		}
		
		return token;
    }
}
