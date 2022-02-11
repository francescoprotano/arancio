package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.mapper.DipendenteMapper;

import it.exolab.model.Dipendente;
import it.exolab.util.MyBatisUtils;

public class DipendenteDao extends BaseDAO<DipendenteMapper>{
	
	private static DipendenteDao istanza=null;
	
	private DipendenteDao() {
	}
	
	public static DipendenteDao getIstanza() {
		if(istanza==null) {
			istanza=new DipendenteDao();
		}
		return istanza;
	}

	public void insert(Dipendente dip) throws CampoRichiesto, ErroreGenerico {
		validaInsert(dip);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.insert(dip);
		sqlSession.commit();
	}

	public void update(Dipendente dip) throws CampoRichiesto, ErroreGenerico {
		validaUpdate(dip);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.update(dip);
		sqlSession.commit();
	}

	public void updatePassword(Dipendente dip) throws CampoRichiesto, ErroreGenerico {
		validaPassword(dip.getPassword());
		validaEmail(dip.getEmail());
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.updatePassword(dip);
		sqlSession.commit();
	}

	public void delete(Integer id_dipendente) throws CampoRichiesto, ErroreGenerico {
		validaID(id_dipendente);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.delete(id_dipendente);
		sqlSession.commit();
	}

	public Dipendente login(Dipendente dipendente) throws CampoRichiesto, ErroreGenerico {
		validaEmail(dipendente.getEmail());
		validaPassword(dipendente.getPassword());
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		dipendente=mapper.login(dipendente);
		dipendente.setPassword(null);
		return dipendente;
	}

	public List<Dipendente> selectByRuolo(String ruolo) throws CampoRichiesto, ErroreGenerico {
		validaRuolo(ruolo);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.selectByRuolo(ruolo);
	}

	public List<Dipendente> selectAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.selectAll();

	}

	public List<Dipendente> allJoinDipendentiEContratti() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.allJoinDipendentiEContratti();
	}

	public List<Dipendente> allJoinDipendentiEPresenze() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.allJoinDipendentiEPresenze();
	}

	// ------------------------VALIDAZIONI----------------------------------//

	private void validaID(Integer id_dipendente) throws CampoRichiesto {
		if (id_dipendente == null || id_dipendente.equals("")) {
			throw new CampoRichiesto("id dipendente");
		}
	}

	private void validaEmail(String email) throws CampoRichiesto {
		if (email == null || email.equals("")) {
			throw new CampoRichiesto("email");
		}
	}
	
	private void validaPassword(String password) throws CampoRichiesto {
		if (password == null || password.equals("")) {
			throw new CampoRichiesto("password");
		}
	}

	private void validaRuolo(String ruolo) throws CampoRichiesto {
		if (ruolo == null || ruolo.equals("")) {
			throw new CampoRichiesto("ruolo");
		}
	}

	private void validaInsert(Dipendente dip) throws CampoRichiesto {
		validaEmail(dip.getEmail());
		validaPassword(dip.getPassword());
		validaRuolo(dip.getRuolo_fk());
	}

	private void validaUpdate(Dipendente dip) throws CampoRichiesto {
		if (dip.getId_dipendente() == null || dip.getId_dipendente().equals("")) {
			throw new CampoRichiesto("id dipendente");
		}
		if (dip.getNome() == null || dip.getNome().equals("")) {
			throw new CampoRichiesto("nome");
		}
		if (dip.getCognome() == null || dip.getCognome().equals("")) {
			throw new CampoRichiesto("cognome");
		}
		if (dip.getData_nascita() == null || dip.getData_nascita().equals("")) {
			throw new CampoRichiesto("data di nascita");
		}
		validaInsert(dip);
	}

}
