import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipSystem {
	static int numberOfRows;
	static int numberOfColumns;
	static int compLives = 4;
	static int playerLives = 4;
	static int turn = 2;
	static ArrayList<Ship> ships = new ArrayList<Ship>();
	static ArrayList<Ship> computerShips = new ArrayList<Ship>();
	static ArrayList<Coordinates> playerAttackCoords = new ArrayList<Coordinates>();
	static ArrayList<Coordinates> computerAttackCoords = new ArrayList<Coordinates>();
	static ArrayList<Coordinates> gridCoordinatesList = new ArrayList<Coordinates>();

	static Grid playerGrid = new Grid(0, 0);

	public static void main(String[] args) {

		BattleshipSystem.gridSetup();
		Ship.createComputerShipAndSetLocation(computerShips, numberOfColumns,numberOfRows);
		Ship.createPlayerShipAndSetLocation(ships);
		
		

		while (compLives > 0 && playerLives > 0) {
			
			if (turn % 2 == 0) {
				System.out.println("Players Turn:");
				Ship.PlayerAttack(playerAttackCoords, numberOfRows, numberOfColumns);
				compLives = Ship.CompHit(numberOfRows, numberOfColumns, computerShips,playerAttackCoords, compLives);
				Grid.UpdateComputerGrid(numberOfRows, numberOfColumns,computerShips, gridCoordinatesList, playerAttackCoords);
				Grid.UpdatePlayerGrid(numberOfRows, numberOfColumns, ships, gridCoordinatesList, computerAttackCoords);
			
				turn++;
					
				
			} else if (turn % 2 != 0) {
				System.out.print("Computers Turn: ");
				Ship.ComputerAttack(computerAttackCoords, numberOfColumns, numberOfRows);
				playerLives = Ship.PlayerHit(numberOfRows, numberOfColumns, ships, computerAttackCoords, playerLives);
				Grid.UpdateComputerGrid(numberOfRows, numberOfColumns, computerShips, gridCoordinatesList, playerAttackCoords);
				Grid.UpdatePlayerGrid(numberOfRows, numberOfColumns, ships,	gridCoordinatesList, computerAttackCoords);
				
				turn++;
			}
		}
		
		if (compLives == 0){
			
			System.out.println("You Win!! Well done!");
			
		}else if (playerLives == 0) {
			
			System.out.println("The Computer has won! Unlucky.");		
			}
		
	}

	public static void gridSetup() {

		Scanner rows = new Scanner(System.in);
		System.out.print("Please enter your desired number of rows: ");
		numberOfRows = rows.nextInt();

		Scanner columns = new Scanner(System.in);
		System.out.print("Please enter your desired number of columns: ");
		numberOfColumns = columns.nextInt();
		System.out.println();
		playerGrid = new Grid(numberOfRows, numberOfColumns);
		playerGrid.setGridCoordinates(gridCoordinatesList);
		playerGrid.BuildGrid(numberOfRows, numberOfColumns, ships);

	}

}
