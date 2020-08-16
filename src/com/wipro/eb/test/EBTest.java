package com.wipro.eb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.wipro.eb.service.ConnectionService;

class EBTest {

	@Test
	void test1() {
		assertEquals(23, new ConnectionService().calculateBillAmt(100,110,"Domestic"));
	}
	@Test
	void test2() {
		assertEquals(157, new ConnectionService().calculateBillAmt(100,160,"Domestic"));
	}
	@Test
	void test3() {
		assertEquals(380, new ConnectionService().calculateBillAmt(100,210,"Domestic"));
	}
	@Test
	void test4() {
		assertEquals((float)53.04, new ConnectionService().calculateBillAmt(100,110,"Commercial"));
	}
	@Test
	void test5() {
		assertEquals((float) 334.56, new ConnectionService().calculateBillAmt(100,160,"Commercial"));
	}
	@Test
	void test6() {
		assertEquals((float) 7674.4, new ConnectionService().calculateBillAmt(100,1000,"Commercial"));
	}
	@Test
	void test7() {
		assertEquals((float) 16,938.6, new ConnectionService().calculateBillAmt(100,2000,"Commercial"));
	}
	@Test
	void test8() {
		assertEquals("Incorrect Reading", new ConnectionService().generateBill(2100,2000,"Commercial"));
	}
	@Test
	void test9() {
		assertEquals("Invalid ConnectionType", new ConnectionService().generateBill(100,2000,"Com"));
	}
	

}
