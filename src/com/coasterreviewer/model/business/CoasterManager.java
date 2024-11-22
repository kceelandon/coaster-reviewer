package com.coasterreviewer.model.business;

import com.coasterreviewer.model.services.IService;
import com.coasterreviewer.model.services.ServiceFactory;

public abstract class CoasterManager {
	private ServiceFactory factory = ServiceFactory.getInstance();
	
	protected IService getService(String name) throws Exception {
		return factory.getService(name);
	}
}
