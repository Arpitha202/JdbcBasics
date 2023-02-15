package com.gl.examples.entity;

public class Game {
	private int gameId;
	private String gameName;
	private int noOfPlayers;

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(int gameId, String gameName, int noOfPlayers) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.noOfPlayers = noOfPlayers;
	}

	public Game(String gameName, int noOfPlayers) {
		super();
		this.gameName = gameName;
		this.noOfPlayers = noOfPlayers;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameName=" + gameName + ", noOfPlayers=" + noOfPlayers + "]";
	}
	
	

}
