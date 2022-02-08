package it.exolab.dao;

import org.apache.ibatis.session.SqlSession;

import it.exolab.util.MyBatisUtils;

public class BaseDAO<T> {
	
	protected T getMapper(Class<T> theClass) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		return sqlSession.getMapper(theClass);
	}

}
