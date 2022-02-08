package it.exolab.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.mapper.PresenzaMapper;
import it.exolab.model.Presenza;
import it.exolab.util.MyBatisUtils;

public class PresenzaDao extends BaseDAO<PresenzaMapper>{
	
	private static PresenzaDao istanza=null;
	
	private PresenzaDao() {
	}
	
	public static PresenzaDao getIstanza() {
		if(istanza==null) {
			istanza=new PresenzaDao();
		}
		return istanza;
	}

	public void insert(Presenza presenza) throws CampoRichiesto, ErroreGenerico {
		validaPresenza(presenza);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.insert(presenza);
		sqlSession.commit();

	}

	public void update(Presenza presenza) throws CampoRichiesto, ErroreGenerico {
		validaPresenza(presenza);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.update(presenza);
		sqlSession.commit();

	}

	public void delete(Integer id_presenza) throws CampoRichiesto, ErroreGenerico {
		validaID(id_presenza);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.delete(id_presenza);
		sqlSession.commit();

	}

	public List<Presenza> selectByData(Date data) throws CampoRichiesto, ErroreGenerico {
		validaData(data);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return mapper.selectByData(data);
	}

	public List<Presenza> selectByMese(Integer id_mese_fk) throws CampoRichiesto, ErroreGenerico {
		validaIdMese(id_mese_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return mapper.selectByMese(id_mese_fk);

	}

	public List<Presenza> selectByDipendente(Integer id_dipendente_fk) throws CampoRichiesto, ErroreGenerico {
		validaIdDipendente(id_dipendente_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return mapper.selectByDipendente(id_dipendente_fk);

	}

	public List<Presenza> selectByAssenza(String motivazione_assenza_fk) throws CampoRichiesto, ErroreGenerico {
		validaMotivazioneAssenza(motivazione_assenza_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return mapper.selectByAssenza(motivazione_assenza_fk);

	}

	public List<Presenza> selectAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return mapper.selectAll();

	}

	// ------------------------VALIDAZIONI----------------------------------//

	private void validaID(Integer id_presenza) throws CampoRichiesto {
		if (id_presenza == null || id_presenza.equals("")) {
			throw new CampoRichiesto("id presenza");
		}
	}

	private void validaData(Date data) throws CampoRichiesto {
		if (data == null || data.equals("")) {
			throw new CampoRichiesto("data");
		}
	}

	private void validaIdMese(Integer id_mese_fk) throws CampoRichiesto {
		if (id_mese_fk == null || id_mese_fk.equals("")) {
			throw new CampoRichiesto("mese");
		}
	}

	private void validaIdDipendente(Integer id_dipendente_fk) throws CampoRichiesto {
		if (id_dipendente_fk == null || id_dipendente_fk.equals("")) {
			throw new CampoRichiesto("dipendente");
		}
	}

	private void validaMotivazioneAssenza(String motivazione_assenza_fk) throws CampoRichiesto {
		if (motivazione_assenza_fk == null || motivazione_assenza_fk.equals("")) {
			throw new CampoRichiesto("motivazione assenza");
		}
	}

	private void validaPresenza(Presenza presenza) throws CampoRichiesto {
		validaIdDipendente(presenza.getId_dipendente_fk());
		validaData(presenza.getData());
		if (presenza.getOre_lavorate() == null || presenza.getOre_lavorate().equals("")) {
			throw new CampoRichiesto("ore lavorate, se 0 scrivere 0");
		}
		if (presenza.getOre_assenza() == null || presenza.getOre_assenza().equals("")) {
			throw new CampoRichiesto("ore assenza, se 0 scrivere 0");
		}
		validaMotivazioneAssenza(presenza.getMotivazione_assenza_fk());
		validaIdMese(presenza.getId_mese_fk());
	}

}
