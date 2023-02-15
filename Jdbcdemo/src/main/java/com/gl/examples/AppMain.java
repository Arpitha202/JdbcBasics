package com.gl.examples;

import java.util.Scanner;

import com.gl.examples.entity.Game;
import com.gl.examples.service.DatabaseService;

public class AppMain {

	public static void main(String[] args) {
		DatabaseService service = new DatabaseService();

		try (Scanner sc = new Scanner(System.in);) {
			boolean isRunning = true;
			while (isRunning) {
				System.out.println("1.Insert data");
				System.out.println("2.Select All");
				System.out.println("3.Select ById");
				System.out.println("4.delete");
				System.out.println("5.update ");
				System.out.println("6.exit");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					System.out.println("Enter name and number of players");
					service.insertGame(new Game(sc.nextLine(), Integer.parseInt(sc.nextLine())));
					break;
				case 2:
					service.getAllGame();
					break;
				case 3:
					System.out.println("Enter id ");
					service.getGameById(Integer.parseInt(sc.nextLine()));
					break;
				case 4:
					System.out.println("Enter id ");
					service.deleteGame(Integer.parseInt(sc.nextLine()));
					break;
				case 5:
					System.out.println("Enter id ");
					int updateId = Integer.parseInt(sc.nextLine());
					boolean isFound = service.getGameById(updateId);
					if (isFound) {
						System.out.println("enter name and number of players");
						Game game = new Game(updateId, sc.nextLine(), Integer.parseInt(sc.nextLine()));

						service.updateGame(game);
					}
					break;
				case 6:
					isRunning = false;

					break;

				default:
					System.out.println("Incorrect choice");
					break;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong" + e.getMessage());
		}
	}

}
