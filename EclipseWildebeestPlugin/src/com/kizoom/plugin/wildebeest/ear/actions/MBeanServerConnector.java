package com.kizoom.plugin.wildebeest.ear.actions;

import java.io.IOException;
import java.util.Properties;

import javax.management.MBeanServerConnection;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.kizoom.plugin.KizoomPlugin;

class MBeanServerConnector {

	private Properties properties;

	MBeanServerConnection getConnection() throws NamingException {

		InitialContext ctx = new InitialContext(getProperties());
		String jndiUrl = "localhost:1099";
		KizoomPlugin.logInfo("Using JNDI at " + jndiUrl, null);
		ctx.addToEnvironment("java.naming.provider.url", jndiUrl);
		MBeanServerConnection server = (MBeanServerConnection) ctx
				.lookup("jmx/invoker/RMIAdaptor");
		return server;
	}

	private Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(getClass().getResourceAsStream(
						"jndi.properties"));
			} catch (IOException e) {
				KizoomPlugin.logError(e);
			}
		}
		return properties;
	}
}
