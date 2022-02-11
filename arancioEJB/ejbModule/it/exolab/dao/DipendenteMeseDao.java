package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.mapper.DipendenteMeseMapper;
import it.exolab.model.DipendenteMese;
import it.exolab.util.MyBatisUtils;

public class DipendenteMeseDao extends BaseDAO<DipendenteMeseMapper> {

	private static DipendenteMeseDao istanza = null;

	private DipendenteMeseDao() {
	}

	public static DipendenteMeseDao getIstanza() {
		if (istanza == null) {
			istanza = new DipendenteMeseDao();
		}
		return istanza;
	}

	public void update(Integer id_dipendente_fk, Integer id_mese_fk) throws CampoRichiesto, ErroreGenerico {
		validaMeseEDip(id_dipendente_fk, id_mese_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		mapper.update(id_dipendente_fk, id_mese_fk);
	}

	public void delete(Integer id_dipendente_fk, Integer id_mese_fk) throws CampoRichiesto, ErroreGenerico {
		validaMeseEDip(id_dipendente_fk, id_mese_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		mapper.delete(id_dipendente_fk, id_mese_fk);
	}

	public DipendenteMese selectOne(Integer id_dipendente_fk, Integer id_mese_fk) throws CampoRichiesto, ErroreGenerico {
		validaMeseEDip(id_dipendente_fk, id_mese_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectOne(id_dipendente_fk, id_mese_fk);
	}

	public List<DipendenteMese> selectAll() throws ErroreGenerico {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectAll();
	}

	public List<DipendenteMese> selectByDipendente(Integer id_dipendente_fk) throws CampoRichiesto, ErroreGenerico {
		validaIdDipendente(id_dipendente_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectByDipendente(id_dipendente_fk);
	}

	public List<DipendenteMese> selectByMese(Integer id_mese_fk) throws CampoRichiesto, ErroreGenerico {
		validaIdMese(id_mese_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectByMese(id_mese_fk);
	}

	public List<DipendenteMese> selectByStato(Integer stato) throws CampoRichiesto, ErroreGenerico {
		validaStato(stato);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectByStato(stato);
	}

	// ------------------------VALIDAZIONI----------------------------------//

	private void validaIdDipendente(Integer id_dipendente_fk) throws CampoRichiesto {
		if (id_dipendente_fk == null || id_dipendente_fk.equals("")) {
			throw new CampoRichiesto("dipendente");
		}
	}

	private void validaIdMese(Integer id_mese_fk) throws CampoRichiesto {
		if (id_mese_fk == null || id_mese_fk.equals("")) {
			throw new CampoRichiesto("mese");
		}
	}

	private void validaStato(Integer stato) throws CampoRichiesto {
		if (stato == null || stato.equals("")) {
			throw new CampoRichiesto("stato");
		}
	}

	private void validaMeseEDip(Integer id_dipendente_fk, Integer id_mese_fk) throws CampoRichiesto {
		validaIdDipendente(id_dipendente_fk);
		validaIdMese(id_mese_fk);
	}

}
