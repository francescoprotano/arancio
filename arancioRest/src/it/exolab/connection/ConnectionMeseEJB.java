package it.exolab.connection;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.MeseEJBRemote;

public class ConnectionMeseEJB {

	private static MeseEJBRemote ejb;

	private ConnectionMeseEJB() {
	}

	public static MeseEJBRemote getConnection() {
		if (ejb == null) {
			ejb = ConnectionMeseEJB.openConnection();
		}
		return ejb;
	}

	private static MeseEJBRemote openConnection() {
		Properties properties = new Properties();
		InitialContext initialContext;

		try {
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			initialContext = new InitialContext(properties);
			String mystring = "java:global/arancioEJBEAR/arancioEJB/MeseEJB!it.exolab.ejb.MeseEJBRemote";
			ejb = (MeseEJBRemote) initialContext.lookup(mystring);

		} catch (NamingException namingException) {
			namingException.printStackTrace();
			System.out.println("----------------------------------------------------------------");
			System.out.println("controllare stringa di connessione all'EJB");
			System.out.println("----------------------------------------------------------------");
		}
		return ejb;
	}

}
