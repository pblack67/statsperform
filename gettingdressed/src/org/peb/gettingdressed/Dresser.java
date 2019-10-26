package org.peb.gettingdressed;

import java.util.*;

public class Dresser {
	private static final String HAT = "1";
	private static final String PANTS = "2";
	private static final String SHIRT = "3";
	private static final String SHOES = "4";
	private static final String SOCKS = "5";
	private static final String LEAVE = "6";
	
	private Set<String> state = new HashSet<String>();
	
	public Dresser() {
		super();
	}
	
	private boolean isPantsOn() {
		return state.contains(PANTS);
	}

	private boolean isSocksOn() {
		return state.contains(SOCKS);
	}

	private boolean isShirtOn() {
		return state.contains(SHIRT);
	}
	
	private boolean isShoesOn() {
		return state.contains(SHOES);
	}

	private void putOnShoes() throws DressingOutOfOrderException
	{
		if (isSocksOn() && isPantsOn()) {
			state.add(SHOES);
		} else {
			throw new DressingOutOfOrderException("Must put on socks and pants before shoes");
		}
	}

	private void putOnPants() {
		state.add(PANTS);
	}
	
	private void putOnSocks() {
		state.add(SOCKS);
	}
	
	private void putOnShirt() {
		state.add(SHIRT);
	}

	private boolean isFullyDressed() {
		return isPantsOn() && isShirtOn() && isShoesOn() && isSocksOn();
	}
	
	private void leaveHouse() throws DressingOutOfOrderException {
		if (!isFullyDressed()) {
			throw new DressingOutOfOrderException("Must be fully dressed before leaving house");
		}
	}
	
	private void putOnHat() throws DressingOutOfOrderException {
		if (isShirtOn()) {
			state.add(HAT);
		} else {
			throw new DressingOutOfOrderException("Must put on shirt before hat");
		}
	}

	private String putOnClothingItem(String item) throws DressingOutOfOrderException {
		switch (item) {
			case PANTS: 
				putOnPants();
				return "pants";
	
			case SHOES: 
				putOnShoes();
				return "shoes";
	
			case SOCKS: 
				putOnSocks();
				return "socks";
				
			case SHIRT:
				putOnShirt();
				return "shirt";
				
			case HAT:
				putOnHat();
				return "hat";
				
			case LEAVE: 
				leaveHouse();
				return "leave";
		}

		return "Not Implemented";
	}
	
	public String getDressed(List<String> input) {
		boolean firstTime = true;
		String commaspace = "";
		
		StringBuilder builder = new StringBuilder();
		try {
			for (String s : input) {
				builder.append(commaspace);
				builder.append(putOnClothingItem(s));
				if (firstTime) {
					firstTime = false;
					commaspace = ", ";
				}
			}
		} catch (DressingOutOfOrderException e) {
			builder.append("fail");
		}
		
		return builder.toString();
	}
	
	public String getDressed(String input) {
		return getDressed(Arrays.asList(input.split(" ")));
	}
	
	
}
