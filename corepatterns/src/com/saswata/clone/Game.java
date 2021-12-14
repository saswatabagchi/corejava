package com.saswata.clone;

public class Game implements Cloneable {
	
	private int id;
	private String gameName;
	private MemberShip mem;
	protected Game clone() throws CloneNotSupportedException {
		//return (Game) super.clone(); shallow copy not a has a relation ship 
		// Deeep copy 
		Game game = (Game) super.clone();
		game.setMem(new MemberShip());
		return game;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", gameName=" + gameName + ", mem=" + mem + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public MemberShip getMem() {
		return mem;
	}

	public void setMem(MemberShip mem) {
		this.mem = mem;
	}
	
	
	

}
