package com.applications_api.service;

import java.util.List;

import com.applications_api.model.Application;

public interface ApplicationService {

	Application addApplication(Application app);

	List<Application> delete(long id);

	List<Application> refuseApplication(long id);

	List<Application> executeApplication(long id);

	Application getApplication(Long id);

	List<Application> getAll();

	double showStatisticRefusedApplication();

	double showStatisticExecutedApplication();
}
