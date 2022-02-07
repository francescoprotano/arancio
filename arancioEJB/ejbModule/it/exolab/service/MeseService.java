package it.exolab.service;

public class MeseService {
	
	private static MeseService istanza=null;
	
	private MeseService() {
	}
	
	public static MeseService getIstanza() {
		if (istanza == null) {
			istanza = new MeseService();
		}
		return istanza;
	}

}