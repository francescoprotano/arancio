package it.exolab.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.mapper.PresenzaMapper;
import it.exolab.model.Presenza;
import it.exolab.service.PresenzaService;
import it.exolab.util.MyBatisUtils;

public class PresenzaDao {
	
	public static void insert(Presenza presenza) throws CampoRichiesto {
		PresenzaService.validaPresenza(presenza);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.insert(presenza);
		sqlSession.commit();
		System.out.println("Presenza inserita");

	}

	public static void update(Presenza presenza) throws CampoRichiesto {
		PresenzaService.validaPresenza(presenza);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.update(presenza);
		sqlSession.commit();
		System.out.println("Presenza modificata");
	}

	public static void delete(Integer id_presenza) throws CampoRichiesto {
		PresenzaService.validaID(id_presenza);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.delete(id_presenza);
		sqlSession.commit();
		System.out.println("Presenza eliminata");
	}

	public static List<Presenza> selectByData(Date data) throws CampoRichiesto {
		PresenzaService.validaData(data);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return null;
	}

	public static List<Presenza> selectByMese(Integer id_mese_fk) throws CampoRichiesto {
		PresenzaService.validaIdMese(id_mese_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return null;

	}

	public static List<Presenza> selectByDipendente(Integer id_dipendente_fk) throws CampoRichiesto {
		PresenzaService.validaIdDipendente(id_dipendente_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return null;

	}

	public static List<Presenza> selectByAssenza(String motivazione_assenza_fk) throws CampoRichiesto {
		PresenzaService.validaMotivazioneAssenza(motivazione_assenza_fk);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return null;

	}

	public static List<Presenza> selectAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return mapper.selectAll();

	}

}
