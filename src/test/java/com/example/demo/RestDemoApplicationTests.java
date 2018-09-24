package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.example.demo.token.TokenController;


@RunWith(SpringRunner.class)
@WebMvcTest(TokenController.class)
public class RestDemoApplicationTests {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void getTokenTest() throws Exception{
		
		MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
		MockHttpServletRequestBuilder request = post("/tokens");
		request.content("{\"pan\": \"4444333322221111\", \"exp_year\": 2020, \"exp_month\": 10}");
		request.accept(MEDIA_TYPE_JSON_UTF8);
		request.contentType(MEDIA_TYPE_JSON_UTF8);
		
		//If timestamp included seconds and milis, this wouldn't work
		LocalDateTime now = LocalDateTime.now().withMinute(0).withSecond(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
		
		this.mvc.perform(request)
		.andDo(print()).andExpect(status().isOk())
		.andExpect(content()
				.string("{\"token\":\"tkn_live_4444333322221111-2020-10\","
						+ "\"brand\":\"visa\",\"creation_dt\":\""+ formatDateTime + "\"}"));
	}

}
