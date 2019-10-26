package org.peb.gettingdressed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DresserTest {

	@Test
	void testShoesBeforeSocks() {
		Dresser dresser = new Dresser();
		assertEquals("pants, fail", dresser.getDressed("2 4 5"));
	}

	@Test
	void testShoesBeforePants() {
		Dresser dresser = new Dresser();
		assertEquals("socks, fail", dresser.getDressed("5 4 2"));
	}

	@Test
	void testHatBeforeShirt() {
		Dresser dresser = new Dresser();
		assertEquals("socks, pants, shoes, fail", dresser.getDressed("5 2 4 1"));
	}

}
