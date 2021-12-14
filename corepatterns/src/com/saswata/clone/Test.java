package com.saswata.clone;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		Game game1 = new Game();
		game1.setGameName("xxx");
		game1.setId(1);
		game1.setMem(new MemberShip());
		
		Game game2 = game1.clone();
		System.out.println(game1);
		System.out.println(game2);
		

	}

}
