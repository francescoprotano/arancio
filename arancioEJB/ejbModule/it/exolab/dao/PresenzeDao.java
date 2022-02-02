package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.mapper.PresenzaMapper;
import it.exolab.model.Presenza;
import it.exolab.util.MyBatisUtilsDipendente;

public class PresenzeDao {
	public static void insert(Presenza model) {
		SqlSession sqlSession = MyBatisUtilsDipendente.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.insert(model);
		sqlSession.commit();
		System.out.println("Presenza inserita");

	}

	public static void delete(int id) {
		SqlSession sqlSession = MyBatisUtilsDipendente.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.delete(id);
		sqlSession.commit();
		System.out.println("Presenza eliminata");
	}

	public static void update(Presenza model) {
		SqlSession sqlSession = MyBatisUtilsDipendente.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.update(model);
		sqlSession.commit();
		System.out.println("Presenza modificata");
	}

	public static List<Presenza> all() {
		SqlSession sqlSession = MyBatisUtilsDipendente.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		return mapper.all();

	}
	

}
