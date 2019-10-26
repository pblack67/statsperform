package org.peb.gettingdressed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DresserTest {

	@Test
	void testSocksNegative() {
		Dresser dresser = new Dresser();
		assertEquals("fail", dresser.getDressed("4 5"));
	}

}
