package com.skilldistillery.cards.common;

public enum Suit {
	
	HEARTS("♡"), SPADES("♤"), CLUBS("♧"), DIAMONDS("♢");
	
	private String name;

	Suit(String n){
		setName(n); 
	}
	
	@Override
	public String toString() {
		return this.name();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}



