package it.exolab.connection;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.ContrattoEJBRemote;




public class ConnectionContrattoEJB {
	
	private static ContrattoEJBRemote ejb;
	
	private ConnectionContrattoEJB() { }
	
	public static ContrattoEJBRemote getConnection() {
		if (ejb == null) {
			ejb = ConnectionContrattoEJB.openConnection();
		}
		
		return ejb;		
	}
	
	private static ContrattoEJBRemote openConnection() {
		
		Properties properties = new Properties();
		InitialContext initialContext;

		try {
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			initialContext = new InitialContext(properties);
			String mystring = "java:global/arancioEJBEAR/arancioEJB/ContrattoEJB!it.exolab.ejb.ContrattoEJBRemote";
			ejb = (ContrattoEJBRemote) initialContext.lookup(mystring);
			
		} catch (NamingException namingException) {
			namingException.printStackTrace();
		}
		
		return ejb;
	}

	

}