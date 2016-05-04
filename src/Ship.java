import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.tools.DocumentationTool.Location;

public class Ship {

	String name = "";
	int size = 0;
	Coordinates shipCoordinates = new Coordinates(0, 0);

	public Ship(String name, int size, Coordinates shipCoordinates) {

		this.name = name;
		this.size = size;
		this.shipCoordinates = shipCoordinates;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Coordinates getShipCoordinates() {
		return shipCoordinates;
	}

	public void setShipCoordinates(Coordinates shipCoordinates) {
		this.shipCoordinates = shipCoordinates;
	}

	public static ArrayList<Ship> createPlayerShipAndSetLocation(
			ArrayList<Ship> ships) {

		System.out
				.println("Please place your ships within the base grid, this will then become your grid.");
		System.out
				.println("The computer is currently placing ships on another grid which you must attack!");

		for (int i = 1; i < 5; i++) {

			Scanner shipInput = new Scanner(System.in);
			System.out.print("Please choose your ship number " + i + " name: ");
			String shipName = shipInput.nextLine();

			System.out.print("Please enter the X coordinate for " + shipName
					+ ": ");
			int shipXLocation = shipInput.nextInt();

			System.out.print("Please enter the Y coordinate for " + shipName
					+ ": ");
			int shipYLocation = shipInput.nextInt();

			Coordinates shipCoordinates = new Coordinates(shipXLocation,
					shipYLocation);

			Ship newPlayerShip = new Ship(shipName, i, shipCoordinates);

			ships.add(newPlayerShip);

		}

		System.out.println();
		System.out
				.println("Player ships placed. Computer ships placed. TIME TO PLAY!");
		return ships;

	}

	public static ArrayList<Ship> createComputerShipAndSetLocation(
			ArrayList<Ship> computerShips, int numberOfColumns, int numberOfRows) {

		for (int i = 1; i < 5; i++) {

			Random rXNumber = new Random();
			int xlocation = (int) (rXNumber.nextInt(numberOfColumns));

			Random rYNumber = new Random();
			int ylocation = (int) (rYNumber.nextInt(numberOfRows));

			Coordinates compterShipCoordinates = new Coordinates(ylocation,
					xlocation);

			Ship newComputerShip = new Ship("1", i, compterShipCoordinates);

			computerShips.add(newComputerShip);

		}
		System.out.println(computerShips);
		return computerShips;

	}

	public static ArrayList<Coordinates> PlayerAttack(
			ArrayList<Coordinates> playerAttackCoords, int numberOfRows,
			int numberOfColumns) {

		int attackXLocation = 0;
		int attackYLocation = 0;
		boolean isInt = true;

		Scanner attackInput = new Scanner(System.in);
		System.out.print("Please enter the X coordinate for your attack: ");
		String XLocationInput = attackInput.nextLine();

		System.out.print("Please enter the Y coordinate for your attack: ");
		System.out.println();
		String YLocationInput = attackInput.nextLine();

		try {

			attackYLocation = Integer.parseInt(YLocationInput);

		} catch (Exception e) {

			System.out.println("This is not a number, please enter a number.");
			isInt = false;
		}

		Coordinates attackCoordinates = new Coordinates(attackXLocation,
				attackYLocation);

		playerAttackCoords.add(attackCoordinates);
		return playerAttackCoords;
	}

	public static ArrayList<Coordinates> ComputerAttack(
			ArrayList<Coordinates> computerAttackCoords, int numberOfColumns,
			int numberOfRows) {

		Random rXNumber = new Random();
		int attackXLocation = (int) (rXNumber.nextInt(numberOfColumns));

		Random rYNumber = new Random();
		int attackYLocation = (int) (rYNumber.nextInt(numberOfRows));

		Coordinates computerAttackCoordinates = new Coordinates(
				attackXLocation, attackYLocation);

		computerAttackCoords.add(computerAttackCoordinates);

		return computerAttackCoords;
	}

	public static int CompHit(int numberOfRows, int numberOfColumns,
			ArrayList<Ship> computerShips,
			ArrayList<Coordinates> playerAttackCoords, int compLives) {

		try {
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(". ");

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		Collections.reverse(playerAttackCoords);
		Coordinates lastAttack = playerAttackCoords.get(0);

		for (Ship compShip : computerShips) {

			if (lastAttack.getxLocation() == compShip.getShipCoordinates()
					.getxLocation()
					&& lastAttack.getyLocation() == compShip
							.getShipCoordinates().getyLocation()) {
				System.out.println("You Hit the computer!");
				compLives--;
				System.out.println("Computer has " + compLives
						+ " ships remaining!");
				return compLives;

			}

		}

		System.out.println("You Missed");
		return compLives;
	}

	public static int PlayerHit(int numberOfRows, int numberOfColumns,
			ArrayList<Ship> ships, ArrayList<Coordinates> computerAttackCoords,
			int playerLives) {
		try {
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(". ");

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		Collections.reverse(computerAttackCoords);
		Coordinates lastCAttack = computerAttackCoords.get(0);

		for (Ship playerShip : ships) {
			if (lastCAttack.getxLocation() == playerShip.getShipCoordinates()
					.getxLocation()
					&& lastCAttack.getyLocation() == playerShip
							.getShipCoordinates().getyLocation()) {
				System.out.println("The Computer Hit! ");
				System.out.println(playerShip.getName() + " Has been sunk!");
				playerLives--;
				System.out.println("You have " + playerLives
						+ " ships remaining!");
				return playerLives;

			}
		}

		System.out.println("Computer Missed");
		return playerLives;
	}

	@Override
	public String toString() {
		return name + " : " + size + " : " + shipCoordinates;
	}

}
