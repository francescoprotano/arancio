package it.exolab.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.mapper.MeseMapper;
import it.exolab.model.Dipendente;
import it.exolab.model.DipendenteMese;
import it.exolab.model.Mese;
import it.exolab.model.Presenza;
import it.exolab.util.MyBatisUtils;

public class MeseDAO extends BaseDAO<MeseMapper> {

	private static MeseDAO istanza = null;

	private MeseDAO() {
	}

	public static MeseDAO getIstanza() {
		if (istanza == null) {
			istanza = new MeseDAO();
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
		inserisciPresenzeDelMese(mese.getMese());
	}

	private void inserisciDipendeti_Mesi() throws ErroreGenerico {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		Integer id_mese = mapper.selectLastID();
		List<Dipendente> id_dipendenti = mapper.selectAllID();
		DipendenteMese dipMes = new DipendenteMese();
		dipMes.setId_mese_fk(id_mese);
		for (Dipendente id_dipendente : id_dipendenti) {
			dipMes.setId_dipendente_fk(id_dipendente.getId_dipendente());
			mapper.inserisciDipendenti_Mesi(dipMes);
			sqlSession.commit();
		}
	}

	private void inserisciPresenzeDelMese(Date data) throws ErroreGenerico {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		List<Dipendente> id_dipendenti = mapper.selectAllID();
		Presenza presMes = new Presenza();
		presMes.setId_mese_fk(mapper.selectLastID());
		SimpleDateFormat giorno = new SimpleDateFormat("dd");
		SimpleDateFormat mese = new SimpleDateFormat("MM");
		SimpleDateFormat anno = new SimpleDateFormat("yyyy");
		LocalDate localDate = LocalDate.of(Integer.parseInt(anno.format(data)), Integer.parseInt(mese.format(data)), Integer.parseInt(giorno.format(data)));
		Calendar cal = Calendar.getInstance();
		Integer res = cal.getActualMaximum(Calendar.DATE);
		for (Dipendente id_dipendente : id_dipendenti) {
			presMes.setId_dipendente_fk(id_dipendente.getId_dipendente());
			for (Integer i = 0; i <= res; i++) {
				presMes.setData(Date.valueOf(localDate));
				mapper.inserisciPresenzeMese(presMes);
				sqlSession.commit();
				localDate = localDate.plusDays(1);
			}
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

	public void delete(Mese mese) throws CampoRichiesto, ErroreGenerico {
		validaID(mese.getId_mese());
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		mapper.delete(mese.getId_mese());
		sqlSession.commit();
	}

	public Mese selectByMese(Date mese) throws CampoRichiesto, ErroreGenerico {
		validaData(mese);
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		return mapper.selectByMese(mese);
	}

	public List<Mese> selectAll() throws ErroreGenerico {
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
