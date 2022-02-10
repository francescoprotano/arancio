package it.exolab.exception;

import java.util.List;

import it.exolab.model.Presenza;

public class RispostaPresenza extends Risposta<Presenza> {

	private static final long serialVersionUID = 1L;

	private Integer id_presenza;
	private List<Presenza> presenze;
	
	
	public void setData(Integer id_presenza) {
		this.id_presenza=id_presenza;
	}
	
	public Integer getId_presenaza() {
		return id_presenza;
	}

	public void setData(List<Presenza> presenze) {
		this.presenze=presenze;
	}

	public List<Presenza> getPresenze() {
		return presenze;
	}
	
	

}
