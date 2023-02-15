package com.gl.examples.service;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gl.examples.entity.Game;
import com.gl.examples.util.DatabaseUtil;
import com.gl.examples.util.QueryUtil;

public class DatabaseService {
	DatabaseUtil util = new DatabaseUtil();
	private Connection conn;

	public DatabaseService() {
		try {
			conn = util.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DatabaseService(Connection connection) {
		super();
		conn = connection;
	}

	// public void insertGame(Game game) throws SQLException {
//		try (Connection conn = util.getConnection();
//				PreparedStatement ps = conn.prepareStatement(QueryUtil.insertGameQuery())) {
//			
//			ps.setString(1, game.getGameName());
//			ps.setInt(2, game.getNoOfPlayers());
//			int rows = ps.executeUpdate();
//			if (rows > 0) {
//				System.out.println("Record inserted successfully");
//			} else {
//				System.out.println("Insert failed");
//			}
//		}
//	}
//
//	public void getAllGame() throws SQLException {
//		try (Connection conn = util.getConnection();
//			Statement st = conn.createStatement();
//				ResultSet rs = st.executeQuery(QueryUtil.selectAllGameQuery());) {
//			while (rs.next()) {
//				printGame(new Game(rs.getInt("game_id"), rs.getString("game_name"), rs.getInt("number_of_players")));
//			}
//		}
//	}// end of getAll
//
//	private void printGame(Game game) {
//		System.out.println("game id " + game.getGameId());
//		System.out.println("game name " + game.getGameName());
//		System.out.println("number of players " + game.getNoOfPlayers());
//		System.out.println("----------------------------");
//	}
//
//	public boolean getGameById(int id) throws SQLException {
//		boolean isFound = false;
//		try (Connection conn = util.getConnection();
//				Statement st = conn.createStatement();
//				ResultSet rs = st.executeQuery(QueryUtil.selectGameById(id));) {
//				if (rs.next()) {
//				isFound = true;
//				printGame(new Game(rs.getInt("game_id"), rs.getString("game_name"), rs.getInt("number_of_players")));
//
//			} else {
//				System.out.println("Record not found for id " + id);
//			}
//		}
//		return isFound;
//	}// end of getById
//
//	public void deleteGame(int id) throws SQLException {
//		try (Connection conn = util.getConnection(); Statement st = conn.createStatement();) {
//			int rows = st.executeUpdate(QueryUtil.deleteGameById(id));
//			if (rows > 0) {
//				System.out.println("record deleted successfully");
//			} else {
//				System.out.println("Something went wrong");
//			}
//		}
//	}// end of delete
//
//	public void updateGame(Game game) throws SQLException {
//		try (Connection conn = util.getConnection();
//				PreparedStatement ps = conn.prepareStatement(QueryUtil.updateGameById(game.getGameId()));) {
//			ps.setString(1, game.getGameName());
//			ps.setInt(2, game.getNoOfPlayers());
//
//			int rows = ps.executeUpdate();
//			if (rows > 0) {
//				System.out.println("Record updated successfully...");
//			} else {
//				System.out.println("Failed to update record");
//			}
//		}
//	}// end of update
	public Game insertGame(Game game) throws SQLException {

		try (Connection conn = util.getConnection();

				CallableStatement ps = conn.prepareCall("{call insert_game(?,?)}");) {
			ps.setString(1, game.getGameName());
			ps.setInt(2, game.getNoOfPlayers());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Record inserted successfully");
			} else {
				System.out.println("Insert failed");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return game;
	}

	public List<Game> getAllGame() throws SQLException {
		List<Game> gamelist = new ArrayList<>();
		try (Connection conn = util.getConnection();

				CallableStatement st = conn.prepareCall("{call findAll_game()}");
				ResultSet rs = st.executeQuery();) {
			while (rs.next()) {
				//printGame(new Game(rs.getInt("game_id"), rs.getString("game_name"), rs.getInt("number_of_players")));
				
				gamelist.add(new Game(rs.getInt("game_id"), rs.getString("game_name"), rs.getInt("number_of_players")));
			}

		}
		for (Game game : gamelist) {
			System.out.println(game);
		}
		return gamelist;

	}// end of getAll

	private void printGame(Game game) {
		System.out.println("game id " + game.getGameId());
		System.out.println("game name " + game.getGameName());
		System.out.println("number of players " + game.getNoOfPlayers());
		System.out.println("----------------------------");

	}

	public boolean getGameById(int id) throws SQLException {
		boolean isFound = false;
		try (Connection conn = util.getConnection(); CallableStatement st = conn.prepareCall("{call find_game(?)}");) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				isFound = true;
				printGame(new Game(rs.getInt("game_id"), rs.getString("game_name"), rs.getInt("number_of_players")));

			} else {
				System.out.println("Record not found for id " + id);
			}
		}
		return isFound;
	}// end of getById

	public String deleteGame(int id) throws SQLException {
		try (Connection conn = util.getConnection();
				CallableStatement st = conn.prepareCall("{call delete_game(?)}");) {
			st.setInt(1, id);
			int rows = st.executeUpdate();
//			if (rows > 0) {
//				System.out.println("record deleted successfully");
//			} else {
//				System.out.println("Something went wrong");
//			}
		}
		return "data deleted";
	}// end of delete

	public Game updateGame(Game game) throws SQLException {
		try (Connection conn = util.getConnection();
				CallableStatement ps = conn.prepareCall("{call update_game(?,?,?)}");) {
			ps.setInt(1, game.getGameId());
			ps.setString(2, game.getGameName());
			ps.setInt(3, game.getNoOfPlayers());

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Record updated successfully...");
			} else {
				System.out.println("Failed to update record");
			}
		}
		return game;
	}// end of update
}
