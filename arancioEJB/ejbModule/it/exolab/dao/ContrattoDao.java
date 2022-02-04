package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.mapper.ContrattoMapper;
import it.exolab.model.Contratto;
import it.exolab.service.ContrattoService;
import it.exolab.util.MyBatisUtils;

public class ContrattoDao {
	public static void insert(Contratto contratto) throws CampoRichiesto {
		ContrattoService.validaContratto(contratto);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.insert(contratto);
		sqlSession.commit();
		System.out.println("Contratto inserito");

	}

	public static void update(Contratto contratto) throws CampoRichiesto {
		ContrattoService.validaContratto(contratto);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.update(contratto);
		sqlSession.commit();
		System.out.println("Contratto modificato");
	}

	public static void delete(Integer id_contratto) throws CampoRichiesto {
		ContrattoService.validaID(id_contratto);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.delete(id_contratto);
		sqlSession.commit();
		System.out.println("Contratto eliminato");
	}

	public static Contratto selectByID(Integer id_contratto) throws CampoRichiesto {
		ContrattoService.validaID(id_contratto);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		return null;
	}

	public static Contratto selectByID(Integer id_contratto) throws CampoRichiesto {
		ContrattoService.validaID(id_contratto);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		return mapper.selectByID(id_contratto);
	}

	public static List<Contratto> selectByTipologia(String tipologia) throws CampoRichiesto {
		ContrattoService.validaTipologia(tipologia);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		return mapper.selectByTipologia(tipologia);
	}

	public static List<Contratto> selectAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		return mapper.selectAll();

	}

}
