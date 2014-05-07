package org.wiperdog.demo.bundle.test.pax.exam;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wiperdog.demo.bundle.test.pax.exam.service.Service;
import org.wiperdog.demo.bundle.test.pax.exam.service.impl.ServiceImpl;

public class Activator implements BundleActivator{

	public void start(BundleContext context) throws Exception {
		System.out.println("Start bundle osgi!");
		context.registerService(Service.class.getName(), new ServiceImpl(),null);
			
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop bundle!");
		context.ungetService(context.getServiceReference(Service.class.getName()));
	}
}
