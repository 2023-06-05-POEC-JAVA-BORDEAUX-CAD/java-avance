package TP_solo;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;



import jakarta.ejb.Stateless;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Qualifier;




public class TPService {
	
	private static final String NOM_INTERDIT = "dangereux";

	@Inject
	private TpSoloDao tpDao;

	public void setPojoDao(TpSoloDao tpDao) {
		this.tpDao = tpDao;
	}

	public void save(TPSolo tp) {
		// ... ne fait rien
	}

	public TPSolo get(Integer id) {
		
		TPSolo tp = tpDao.getTPSolo(id);
		if (tp == null) {
			return null;
		}
		if (tp.getName() != null
				&& tp.getName().equals(NOM_INTERDIT)) {
			//équivaut à	if(Objects.equals(pojo.getName(), NOM_INTERDIT)) {
			throw new IllegalArgumentException("Un pojo dangereux a été chargé, ce qui est interdit");
		}
		return tp;
	}



}
