package TP_solo;


import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class TPDaoTest {
	
	
	
	@EJB
	private TpSoloDao tpDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(TpSoloDao.class));
		return ejbJar;
	}

	@Test
	public void test1() throws Exception {
		TPSolo tp = tpDao.getTPSolo(1);
		Assertions.assertNotNull(tp);
		Assertions.assertEquals("Hey!", tp.getName());
	}

}
	


