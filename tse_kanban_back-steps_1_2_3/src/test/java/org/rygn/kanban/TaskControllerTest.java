package org.rygn.kanban;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rygn.kanban.service.impl.DeveloperServiceImpl;
import org.rygn.kanban.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TaskControllerTest { 
	@Autowired
	private TaskServiceImpl taskServiceImpl;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		MvcResult mvcresult = mockMvc.perform(MockMvcRequestBuilders.get("/tasks").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	
		String content = mvcresult.getResponse().getContentAsString();
		//String devs = taskServiceImpl.findAllDevelopers().toString();
		/*ObjectMapper mapper = new ObjectMapper(); 
		String newsLetterJSON = mapper.writeValueAsString(devs); 
		System.out.println(newsLetterJSON);*/
		Assert.assertTrue(content.contains("remy.girodon@gmail.com"));
	}
}
