package com.applications_api.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.applications_api.model.Application;
import com.applications_api.service.ApplicationService;

@Transactional
@Configuration
@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ApplicationService appSer;
	
	@RequestMapping("/")
    @ResponseBody
    public String welcome1() {
        return "Please enter your request and bid for register or id No your application for checking.";
    }

	@PostMapping("/register_app")
	@ResponseBody
	public Application createApp(@Valid @RequestBody Application app) {
		Application newapp = appSer.addApplication(app);
		return newapp;
	}

	@GetMapping("/check_status/{id}")
	@ResponseBody
	public Application showApp(@PathVariable(value = "id") long id) {
		return appSer.getApplication(id);
	}

}
