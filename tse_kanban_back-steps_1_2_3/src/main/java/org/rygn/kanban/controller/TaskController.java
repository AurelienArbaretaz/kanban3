package org.rygn.kanban.controller;

import java.util.Collection;
import java.util.List;

import org.rygn.kanban.dao.TaskRepository;
import org.rygn.kanban.dao.TaskTypeRepository;
import org.rygn.kanban.domain.Developer;
import org.rygn.kanban.domain.Task;
import org.rygn.kanban.service.impl.DeveloperServiceImpl;
import org.rygn.kanban.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/")
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping(value="/tasks" , produces = "application/json")
	public Collection<Task> connexionGet() {
		Collection<Task> alltasks = taskServiceImpl.findAllTasks();
		return alltasks;
	}

	@PostMapping(value="/tasks" , produces = "application/json")
	public Task connexionPost() {
		Task task = new Task();
		taskServiceImpl.createTask(task);
		return task;
	}
	
	@PatchMapping(value="/tasks/{id}" , produces = "application/json")
	public Task connexionPatch(@PathVariable long id) {
		Task task = taskServiceImpl.findTask(id);
		task= taskServiceImpl.moveRightTask(task);
		return task;
	}
}