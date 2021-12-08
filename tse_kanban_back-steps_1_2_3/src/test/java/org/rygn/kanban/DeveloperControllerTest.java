package org.rygn.kanban;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rygn.kanban.controller.DeveloperController;
import org.rygn.kanban.dao.DeveloperRepository;
import org.rygn.kanban.domain.Developer;
import org.rygn.kanban.service.impl.DeveloperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class DeveloperControllerTest { 
	@Autowired
	private DeveloperServiceImpl developerServiceImpl;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		MvcResult mvcresult = mockMvc.perform(MockMvcRequestBuilders.get("/developers").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	
		String content = mvcresult.getResponse().getContentAsString();
		String devs = developerServiceImpl.findAllDevelopers().toString();
		/*ObjectMapper mapper = new ObjectMapper(); 
		String newsLetterJSON = mapper.writeValueAsString(devs); 
		System.out.println(newsLetterJSON);*/
		Assert.assertTrue(content.contains("remy.girodon@gmail.com"));
	}
}