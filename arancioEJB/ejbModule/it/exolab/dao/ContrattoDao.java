package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.mapper.ContrattoMapper;
import it.exolab.model.Contratto;
import it.exolab.util.MyBatisUtils;

public class ContrattoDao {
	public static void insert(Contratto model) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.insert(model);
		sqlSession.commit();
		System.out.println("Contratto inserito");

	}

	public static void delete(int id) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.delete(id);
		sqlSession.commit();
		System.out.println("Contratto eliminato");
	}

	public static void update(Contratto model) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.update(model);
		sqlSession.commit();
		System.out.println("Contratto modificato");
	}

	public static List<Contratto> all() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		return mapper.all();

	}
	

}
