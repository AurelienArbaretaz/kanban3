package org.rygn.kanban.controller;

import java.util.List;

import org.rygn.kanban.dao.DeveloperRepository;
import org.rygn.kanban.dao.TaskTypeRepository;
import org.rygn.kanban.domain.Developer;
import org.rygn.kanban.service.impl.DeveloperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/")
public class DeveloperController {
	
	@Autowired
	private DeveloperServiceImpl developerServiceImpl;
	
	@GetMapping(value="/developers" , produces = "application/json")
	public List<Developer> connexionGet() {
		List<Developer> alldevs = developerServiceImpl.findAllDevelopers();
		return alldevs;
	}

}
