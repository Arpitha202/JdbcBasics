package com.gl.examples.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gl.examples.entity.Game;
import com.gl.examples.util.DatabaseUtil;

class DataBaseServiceTest {

	static DatabaseService service = new DatabaseService();
	

	@Test
	@DisplayName("Testing insertMathod")
	void addGameTest() throws SQLException {

		Game game = new Game(2, "football", 20);

		Game game1 = service.insertGame(game);
		assertEquals(game.getGameName(), game1.getGameName());
	}

	@Test
	@DisplayName("Testing getMathod")
	void getGameTest() throws SQLException {

		Game game = new Game(1, "football", 20);
		assertEquals(true, service.getGameById(game.getGameId()));

	}

	@Test
	@DisplayName("Testing deleteMathod")
	void deleteGameTest() throws SQLException {

		Game game = new Game(1, "football", 20);
		String verification = service.deleteGame(game.getGameId());
		assertEquals("data deleted", verification);

	}

	@Test
	@DisplayName("Testing updateMathod")
	void updateGameTest() throws SQLException {

		Game game = new Game(1, "football", 20);
		Game verification = service.updateGame(game);
		assertEquals(game, verification);
	}

	@Test
	@DisplayName("Testing getAllMathod")
	void getAllGameTest() throws SQLException {

		assertEquals(2, service.getAllGame().size());
	}

}
