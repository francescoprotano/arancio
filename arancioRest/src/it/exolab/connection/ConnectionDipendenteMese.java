package it.exolab.connection;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.exolab.ejb.DipendenteEJBRemote;
import it.exolab.ejb.DipendenteMeseEJBRemote;

public class ConnectionDipendenteMese {

	private static DipendenteMeseEJBRemote ejb;

	private ConnectionDipendenteMese() {
	}

	public static DipendenteMeseEJBRemote getConnection() {
		if (ejb == null) {
			ejb = ConnectionDipendenteMese.openConnection();
		}
		return ejb;
	}

	private static DipendenteMeseEJBRemote openConnection() {
		Properties properties = new Properties();
		InitialContext initialContext;

		try {
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");

			initialContext = new InitialContext(properties);
			String mystring = "java:global/arancioEJBEAR/arancioEJB/DipendenteEJB!it.exolab.ejb.DipendenteMeseEJBRemote";
			ejb = (DipendenteMeseEJBRemote) initialContext.lookup(mystring);

		} catch (NamingException namingException) {
			namingException.printStackTrace();
		}

		return ejb;
	}

}
