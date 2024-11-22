package com.coasterreviewer.model.services;


public class ServiceFactory {
	
	private ServiceFactory() {
	}
	
	private static ServiceFactory serviceFactory = new ServiceFactory();
	
	public static ServiceFactory getInstance() {
		return serviceFactory;
	}
	
	/**
	 * @param serviceName the name of the service as it appears in the config properties.txt file.
	 * @return a new instance of the specified service as an IService interface from which all service
	 * implementations extend from.
	 * @throws Exception
	 */
	public IService getService(String serviceName) throws Exception {
		try {
			Class<?> c = Class.forName(getImplName(serviceName));
			return (IService) c.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception thrown.");
			throw new Exception(e);
		}
	}
	
	private String getImplName(String serviceName) throws Exception {
		java.util.Properties props = new java.util.Properties();
		java.io.FileInputStream fis = new java.io.FileInputStream("config/properties.txt");
		props.load(fis);
		fis.close();
		return props.getProperty(serviceName);
	}

}
