package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.mapper.DipendenteMeseMapper;
import it.exolab.model.Dipendente;
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

	public void update(DipendenteMese dipendenteMese, Dipendente dipendente) throws CampoRichiesto, ErroreGenerico {
		validaMeseEDip( dipendenteMese.getId_dipendente_fk() ,dipendenteMese.getId_mese_fk());
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		mapper.update(dipendenteMese.getId_dipendente_fk() ,dipendenteMese.getId_mese_fk());
	}

	public void delete(DipendenteMese dipendenteMese, Dipendente dipendente) throws CampoRichiesto, ErroreGenerico {
		validaMeseEDip(dipendenteMese.getId_dipendente_fk() ,dipendenteMese.getId_mese_fk());
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		mapper.delete(dipendenteMese.getId_dipendente_fk() ,dipendenteMese.getId_mese_fk());
	}

	public DipendenteMese selectOne(DipendenteMese dipendenteMese, Dipendente dipendente) throws CampoRichiesto, ErroreGenerico {
		validaMeseEDip(dipendenteMese.getId_dipendente_fk() ,dipendenteMese.getId_mese_fk());
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectOne(dipendenteMese.getId_dipendente_fk() ,dipendenteMese.getId_mese_fk());
	}

	public List<DipendenteMese> selectAll(Dipendente dipendente) throws ErroreGenerico {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectAll();
	}

	public List<DipendenteMese> selectByDipendente(DipendenteMese dipendenteMese,Dipendente dipendente) throws CampoRichiesto, ErroreGenerico {
		validaIdDipendente(dipendenteMese.getId_dipendente_fk());
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectByDipendente(dipendenteMese.getId_dipendente_fk());
	}

	public List<DipendenteMese> selectByMese(DipendenteMese dipendenteMese,Dipendente dipendente) throws CampoRichiesto, ErroreGenerico {
		validaIdMese(dipendenteMese.getId_mese_fk());
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectByMese(dipendenteMese.getId_mese_fk());
	}

	public List<DipendenteMese> selectByStato(DipendenteMese dipendenteMese,Dipendente dipendente) throws CampoRichiesto, ErroreGenerico {
		validaStato(dipendenteMese.getStato());
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		return mapper.selectByStato(dipendenteMese.getStato());
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
