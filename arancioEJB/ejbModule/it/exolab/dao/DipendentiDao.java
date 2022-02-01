package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.mapper.DipendenteMapper;

import it.exolab.model.Dipendente;

import it.exolab.util.MyBatisUtilsDipendente;

public class DipendentiDao {
	public static void insert(Dipendente model) {
		SqlSession sqlSession = MyBatisUtilsDipendente.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.insert(model);
		sqlSession.commit();
		System.out.println("Dipendente inserito");

	}

	public static void delete(int id) {
		SqlSession sqlSession = MyBatisUtilsDipendente.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.delete(id);
		sqlSession.commit();
		System.out.println("Dipendente eliminato");
	}

	public static void update(int id) {
		SqlSession sqlSession = MyBatisUtilsDipendente.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.update(id);
		sqlSession.commit();
		System.out.println("Dipendente modificato");
	}

	public static List<Dipendente> all() {
		SqlSession sqlSession = MyBatisUtilsDipendente.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		return mapper.all();

	}

}
