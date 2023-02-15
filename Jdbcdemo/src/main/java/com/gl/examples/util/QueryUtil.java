package com.gl.examples.util;

public class QueryUtil {
	public static String insertGameQuery() {
		return "insert into game (game_name,number_of_players) values (?,?)";
	}
	
	public static String selectAllGameQuery() {
		return "select * from game";
	}
	
	public static String selectGameById(int gameId) {
		return "select * from game where game_id = " +gameId;
	}
	
	public static String deleteGameById(int gameId) {
		return "delete from game where game_id = " +gameId;
	}
	
	public static String updateGameById(int gameId) {
		return "update game set game_name=?,number_of_players=? where game_id = " +gameId;
	}
}
