package fr.maboite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStringSum {

	@Test
	public void test0() {
		StringSum stringSum = new StringSum();
		Assertions.assertEquals(1, stringSum.compute("1"));
	}

	@Test
	public void test1() {
		StringSum stringSum = new StringSum();
		Assertions.assertEquals(2, stringSum.compute("1,1"));
	}

	@Test
	public void test2() {
		StringSum stringSum = new StringSum();
		Assertions.assertEquals(16, stringSum.compute("2,1,5,8"));
	}

	@Test
	public void test3() {
		StringSum stringSum = new StringSum();
		Assertions.assertEquals(1148, stringSum.compute("1000,125,23"));
	}

	@Test
	public void test4() {
		StringSum stringSum = new StringSum();
		Assertions.assertEquals(85, stringSum.compute("12,5,68"));
	}

	@Test
	public void test7() {
		StringSum stringSum = new StringSum();
		Assertions.assertEquals(98, stringSum.compute("1,8,,6,78,5"));
	}

	@Test
	public void test12() {
		StringSum stringSum = new StringSum();
		Assertions.assertEquals(10, stringSum.compute("7,3"));
	}

}
