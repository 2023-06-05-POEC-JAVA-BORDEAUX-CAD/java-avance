package dev.loicmoreaux.dayservlet;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class DayServiceTest {
	
	@EJB
	private DayService dayService;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(DayService.class));
		return ejbJar;
	}

	@Test
	public void getDayOfWeekWorkDay() {
		Assertions.assertEquals(dayService.getDayOfWeek(4, 7, 2023), "C'est un jour travaillé :(");	
	}
	
	@Test
	public void getDayOfWeekWeekend() {
		Assertions.assertEquals(dayService.getDayOfWeek(1, 7, 2023), "C'est le weekend ! :)");
	}
}
