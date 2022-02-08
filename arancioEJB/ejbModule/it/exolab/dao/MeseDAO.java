package it.exolab.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.mapper.MeseMapper;
import it.exolab.model.Dipendente;
import it.exolab.model.DipendenteMese;
import it.exolab.model.Mese;
import it.exolab.util.MyBatisUtils;

public class MeseDAO extends BaseDAO<MeseMapper>{
	
	private static MeseDAO istanza=null;
	
	private MeseDAO() {
	}
	
	public static MeseDAO getIstanza() {
		if(istanza==null) {
			istanza=new MeseDAO();
		}
		return istanza;
	}

	public void insert(Mese mese) throws CampoRichiesto, ErroreGenerico {
		validaMese(mese);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		mapper.insert(mese);
		sqlSession.commit();
		inserisciDipendeti_Mesi();
	}
	
	public void inserisciDipendeti_Mesi() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		Integer id_mese = mapper.selectLastID();
		List<Dipendente> id_dipendenti=mapper.selectAllID();
		DipendenteMese dipMes = new DipendenteMese();
		dipMes.setId_mese_fk(id_mese);
		for (Dipendente id_dipendente : id_dipendenti) {
			dipMes.setId_dipendente_fk(id_dipendente.getId_dipendente());
			mapper.inserisciDipendenti_Mesi(dipMes);
			sqlSession.commit();
		}
	}

	public void update(Mese mese) throws CampoRichiesto, ErroreGenerico {
		validaMese(mese);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		mapper.update(mese);
		sqlSession.commit();
	}

	public void delete(Integer id_mese) throws CampoRichiesto, ErroreGenerico {
		validaID(id_mese);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		mapper.delete(id_mese);
		sqlSession.commit();
	}

	public Mese selectByMese(Date mese) throws CampoRichiesto, ErroreGenerico {
		validaData(mese);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		return mapper.selectByMese(mese);
	}

	public List<Mese> selectAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		return mapper.selectAll();
	}

	// ------------------------VALIDAZIONI----------------------------------//

	private void validaID(Integer id_mese) throws CampoRichiesto {
		if (id_mese == null || id_mese.equals("")) {
			throw new CampoRichiesto("id mese");
		}
	}

	private void validaData(Date mese) throws CampoRichiesto {
		if (mese == null || mese.equals("")) {
			throw new CampoRichiesto("mese");
		}
	}

	private void validaMese(Mese mese) throws CampoRichiesto {
		validaData(mese.getMese());
	}

}
