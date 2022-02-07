package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.mapper.DipendenteMapper;

import it.exolab.model.Dipendente;
import it.exolab.service.DipendenteService;
import it.exolab.util.MyBatisUtils;

public class DipendenteDao {

	public static void insert(Dipendente dip) throws CampoRichiesto {
		DipendenteService.validaInsert(dip);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.insert(dip);
		sqlSession.commit();
	}

	public static void update(Dipendente dip) throws CampoRichiesto {
		DipendenteService.validaUpdate(dip);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.update(dip);
		sqlSession.commit();
	}
	
	public static void updatePassword(Dipendente dip) throws CampoRichiesto {
		DipendenteService.validaPassword(dip);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.updatePassword(dip);
		sqlSession.commit();
	}

	public static void delete(Integer id_dipendente) throws CampoRichiesto {
		DipendenteService.validaID(id_dipendente);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.delete(id_dipendente);
		sqlSession.commit();
	}

	public static Dipendente selectByEmail(String email) throws CampoRichiesto {
		DipendenteService.validaEmail(email);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.selectByEmail(email);
	}

	public static List<Dipendente> selectByRuolo(String ruolo) throws CampoRichiesto {
		DipendenteService.validaRuolo(ruolo);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.selectByRuolo(ruolo);
	}

	public static List<Dipendente> selectAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.selectAll();

	}
	
	public static List<Dipendente> allJoinDipendentiEContratti(){
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.allJoinDipendentiEContratti();
	}

}
