package it.exolab.connection;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.PresenzaEJBRemote;





public class ConnectionPresenzaEJB {
	
	private static PresenzaEJBRemote ejb;
	
	private ConnectionPresenzaEJB() { }
	
	public static PresenzaEJBRemote getConnection() {
		if (ejb == null) {
			ejb = ConnectionPresenzaEJB.openConnection();
		}
		
		return ejb;		
	}
	
	private static PresenzaEJBRemote openConnection() {
		
		Properties properties = new Properties();
		InitialContext initialContext;

		try {
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			initialContext = new InitialContext(properties);
			String mystring = "java:global/arancioEJBEAR/arancioEJB/PresenzaEJB!it.exolab.ejb.PresenzaEJBRemote";
			ejb = (PresenzaEJBRemote) initialContext.lookup(mystring);
			
		} catch (NamingException namingException) {
			namingException.printStackTrace();
		}
		
		return ejb;
	}

	

}