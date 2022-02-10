package it.exolab.exception;

import java.util.List;

import it.exolab.model.Contratto;

public class RispostaContratto extends Risposta<Contratto> {

	private static final long serialVersionUID = 1L;

	private List<Contratto> contratti;
	private Integer id_contratto;

	public void setData(List<Contratto> selectByTipologia) {
		contratti = selectByTipologia;
	}

	public List<Contratto> getContratti() {
		return contratti;
	}

	public void setData(Integer id_contratto) {
		this.id_contratto = id_contratto;
	}

	public Integer getId_contratto() {
		return id_contratto;
	}

}
