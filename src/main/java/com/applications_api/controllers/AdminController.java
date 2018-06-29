package com.applications_api.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.applications_api.model.Application;
import com.applications_api.service.ApplicationService;

@Transactional
@Configuration
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ApplicationService appSer;

	@GetMapping("/")
	@ResponseBody
	public List<Application> getApplicaionts() {
		return appSer.getAll();
	}

	@PutMapping("/execute_app/{id}")
	public List<Application> agreedApp(@PathVariable(value = "id") long id) {
		appSer.executeApplication(id);
		return appSer.getAll();
	}

	@PutMapping("/refuse_app/{id}")
	public List<Application> disagreedApp(@PathVariable(value = "id") long id) {
		appSer.refuseApplication(id);
		return appSer.getAll();
	}

	@DeleteMapping("/delete_app/{id}")
	public List<Application> deleteApp(@PathVariable(value = "id") long id) {
		appSer.delete(id);
		return appSer.getAll();
	}

	@GetMapping("/get_statistic")
	public String showStat() {
		return "Executed applications account for " + appSer.showStatisticExecutedApplication() + " %;"
				+ "\nRefused applications account for " + appSer.showStatisticRefusedApplication() + " %.";
	}

}
