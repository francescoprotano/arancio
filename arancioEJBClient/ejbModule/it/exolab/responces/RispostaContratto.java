package it.exolab.responces;

import java.util.List;

import it.exolab.model.Contratto;

public class RispostaContratto extends Risposta<Contratto> {

	@Override
	public String toString() {
		return "RispostaContratto [contratti=" + contratti + ", id_contratto=" + id_contratto + "]";
	}

	private static final long serialVersionUID = 1L;

	private List<Contratto> contratti;
	private Integer id_contratto;

	public void setData(List<Contratto> contratti) {
		this.contratti = contratti;
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
