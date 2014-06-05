package eu.aniketos.srcm;

import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import eu.aniketos.srcm.interfaces.ICompliance;


/**
 * @author Mattia Salnitri
 *
 *This class is used by CFX-DOSGi, in order to publish the SRCM bundle as an external service
 *
 */
public class Activator implements BundleActivator {

	private ServiceRegistration registration;
	private static BundleContext context;

	/**
	 * method called by DOSGi engine to setup the SRCM service
	 * @return context
	 */
	static BundleContext getContext() {
		return context;
	}

	/**
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception 
	{
		Activator.context = bundleContext;

		Dictionary props = new Hashtable();
		   
		props.put("service.exported.interfaces", "*");
		props.put("service.exported.configs", "org.apache.cxf.ws");
		props.put("org.apache.cxf.ws.address", "http://localhost:9090/SRCM");
		 
		registration = bundleContext.registerService(ICompliance.class.getName(), new SRCM(), props);
	}

	/**
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
