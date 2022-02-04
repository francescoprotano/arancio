package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.mapper.DipendenteMapper;

import it.exolab.model.Dipendente;
import it.exolab.service.DipendenteService;
import it.exolab.util.MyBatisUtils;

public class DipendenteDao {
	
	public static void insert(Dipendente dip) {
		DipendenteService.validaInsert(dip);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.insert(dip);
		sqlSession.commit();
		System.out.println("Dipendente inserito");

	}

	public static void delete(Integer id) {
		DipendenteService.validaID(id);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.delete(id);
		sqlSession.commit();
		System.out.println("Dipendente eliminato");
	}

	public static void update(Dipendente dip) {
		DipendenteService.validaUpdate(dip);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.update(dip);
		sqlSession.commit();
		System.out.println("Dipendente modificato");
	}

	public static List<Dipendente> all() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.all();

	}

	public static Dipendente selectByEmail(String email) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.selectByEmail(email);
	}
	

}
