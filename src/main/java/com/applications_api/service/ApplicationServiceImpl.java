package com.applications_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applications_api.exceptions.ResourceNotFoundException;
import com.applications_api.model.Application;
import com.applications_api.repositories.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository appRep;

	@Override
	public Application addApplication(Application app) {
		Application newapp = appRep.saveAndFlush(app);
		return newapp;
	}

	@Override
	public List<Application> delete(long id) {
		Application app = appRep.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Applicaton", "id", id));
		appRep.deleteById(app.getId());
		return appRep.findAll();
	}

	@Override
	public List<Application> getAll() {
		return appRep.findAll();
	}

	@Override
	public List<Application> refuseApplication(long id) {
		Application app = appRep.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Applicaton", "id", id));
		appRep.refuseApp(app.getId());
		return appRep.findAll();
	}

	@Override
	public List<Application> executeApplication(long id) {
		Application app = appRep.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Applicaton", "id", id));
		appRep.executeApp(app.getId());
		return appRep.findAll();
	}

	@Override
	public Application getApplication(Long id) {
		return appRep.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Applicaton", "id", id));
	}

	@Override
	public double showStatisticExecutedApplication() {
		return (double) (appRep.countExecutedApp()) / (appRep.count()) *100;
	}

	@Override
	public double showStatisticRefusedApplication() {
		return (double) (appRep.countRefusedApp()) / (appRep.count()) *100;
	}
	


}
