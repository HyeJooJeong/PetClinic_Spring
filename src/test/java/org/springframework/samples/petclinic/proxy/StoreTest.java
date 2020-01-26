package org.springframework.samples.petclinic.proxy;

import org.junit.jupiter.api.Test;

public class StoreTest {

	@Test
	public void testPay() {
		Payment cash = new Cash();
		Store store = new Store(cash);
		store.buySomething(100);
	}

}
