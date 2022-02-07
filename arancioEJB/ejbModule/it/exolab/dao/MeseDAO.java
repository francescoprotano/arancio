package it.exolab.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.mapper.MeseMapper;
import it.exolab.model.Mese;
import it.exolab.service.MeseService;
import it.exolab.util.MyBatisUtils;

public class MeseDAO {

	public static void insert(Mese mese) throws CampoRichiesto {
		MeseService.validaMese(mese);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		mapper.insert(mese);
		sqlSession.commit();
	}

	public static void update(Mese mese) throws CampoRichiesto {
		MeseService.validaMese(mese);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		mapper.update(mese);
		sqlSession.commit();
	}

	public static void delete(Integer id_mese) throws CampoRichiesto {
		MeseService.validaID(id_mese);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		mapper.delete(id_mese);
		sqlSession.commit();
	}

	public static Mese selectByMese(Date mese) throws CampoRichiesto {
		MeseService.validaData(mese);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		return mapper.selectByMese(mese);
	}
	
	public static List<Mese> selectAll(){
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		return mapper.selectAll();
	}

}
