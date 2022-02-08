package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.mapper.ContrattoMapper;
import it.exolab.model.Contratto;
import it.exolab.util.MyBatisUtils;

public class ContrattoDao extends BaseDAO<ContrattoMapper> {
	
	private static ContrattoDao istanza=null;
	
	private ContrattoDao() {
	}
	
	public static ContrattoDao getIstanza() {
		if(istanza==null) {
			istanza=new ContrattoDao();
		}
		return istanza;
	}

	public void insert(Contratto contratto) throws CampoRichiesto, ErroreGenerico {
		validaContratto(contratto);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.insert(contratto);
		sqlSession.commit();
	}

	public void update(Contratto contratto) throws CampoRichiesto, ErroreGenerico {
		validaContratto(contratto);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.update(contratto);
		sqlSession.commit();
	}

	public void delete(Integer id_contratto) throws CampoRichiesto, ErroreGenerico {
		validaID(id_contratto);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.delete(id_contratto);
		sqlSession.commit();
	}

	public Contratto selectByID(Integer id_contratto) throws CampoRichiesto, ErroreGenerico {
		validaID(id_contratto);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		return mapper.selectByID(id_contratto);
	}

	public List<Contratto> selectByTipologia(String tipologia) throws CampoRichiesto, ErroreGenerico {
		validaTipologia(tipologia);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		return mapper.selectByTipologia(tipologia);
	}

	public List<Contratto> selectAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		return mapper.selectAll();
	}

	// ------------------------VALIDAZIONI----------------------------------//

	private void validaID(Integer id_contratto) throws CampoRichiesto {
		if (id_contratto == null || id_contratto.equals("")) {
			throw new CampoRichiesto("id contratto");
		}
	}

	private void validaTipologia(String tipologia) throws CampoRichiesto {
		if (tipologia == null || tipologia.equals("")) {
			throw new CampoRichiesto("tipologia");
		}
	}

	private void validaContratto(Contratto contratto) throws CampoRichiesto {
		if (contratto.getData_assunzione() == null || contratto.getData_assunzione().equals("")) {
			throw new CampoRichiesto("Data assunzione");
		}
		validaTipologia(contratto.getTipologia());
		if (!contratto.getTipologia().equals("indeterminato")) {
			if (contratto.getData_scadenza() == null || contratto.getData_scadenza().equals("")) {
				throw new CampoRichiesto("data scadenza");
			}
		}
		if (contratto.getId_dipendente_fk() == null || contratto.getId_dipendente_fk().equals("")) {
			throw new CampoRichiesto("id dipendente");
		}
	}

}
