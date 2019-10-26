package org.peb.gettingdressed;

import java.util.*;

public class Dresser {
	private static String SHOES = "4";
	private static String SOCKS = "5";
	
	private Set<String> state = new HashSet<String>();
	
	public Dresser() {
		super();
	}
	
	private boolean isSocksOn() {
		return state.contains(SOCKS);
	}
	
	private void putOnShoes() throws DressingOutOfOrderException
	{
		if (isSocksOn()) {
			state.add(SHOES);
		} else {
			throw new DressingOutOfOrderException("Must put on socks before shoes");
		}
	}

	private void putOnSocks()
	{
		state.add(SOCKS);
	}
	
	public String getDressed(List<String> input) {
		StringBuilder builder = new StringBuilder();
		try {
		for (String s : input) {
			switch (s) {
				case "4": 
					putOnShoes();
					builder.append("shoes");
					break;
	
				case "5": 
					putOnSocks();
					builder.append("socks");
					break;
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
