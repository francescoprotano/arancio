package it.exolab.connection;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.DipendenteEJBRemote;



public class ConnectionDipendenteEJB {
	
	private static DipendenteEJBRemote ejb;
	
	private ConnectionDipendenteEJB() { }
	
	public static DipendenteEJBRemote getConnection() {
		if (ejb == null) {
			ejb = ConnectionDipendenteEJB.openConnection();
		}
		
		return ejb;		
	}
	
	private static DipendenteEJBRemote openConnection() {
		
		Properties properties = new Properties();
		InitialContext initialContext;

		try {
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			initialContext = new InitialContext(properties);
			String mystring = "java:global/arancioEJBEAR/arancioEJB/DipendenteEJB!it.exolab.ejb.DipendenteEJBRemote";
			ejb = (DipendenteEJBRemote) initialContext.lookup(mystring);
			
		} catch (NamingException namingException) {
			namingException.printStackTrace();
		}
		
		return ejb;
	}

	

}