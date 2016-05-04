
import java.util.ArrayList;


public class Grid {

	int numberOfRows = 0;
	int numberOfColumns = 0;

	public Grid(int numberOfRows, int numberOfColumns) {

		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;

	}

	public void BuildGrid(int numberOfRows, int numberOfColumns,
			ArrayList<Ship> ships) {

		int rowLabel = 0;
		int columnLabel = 0;
		
		System.out.println("Below is the base grid;");
		
		for (int x = 0; x < numberOfRows; x++) {
			System.out.print(rowLabel++);

			for (int y = 0; y < numberOfColumns; y++) {
				
					System.out.print("\t [ ]");
			}
			System.out.println();
		}
		for (int x = 0; x < numberOfColumns; x++) {
			System.out.print("\t" + "  " + columnLabel++);
		}
		System.out.println("");
	}

	public ArrayList<Coordinates> setGridCoordinates(
			ArrayList<Coordinates> gridCoordinatesList) {

		for (int x = 0; x < numberOfRows; x++) {
			for (int y = 0; y < numberOfColumns; y++) {
				Coordinates gridCoords = new Coordinates(x, y);
				gridCoordinatesList.add(gridCoords);
			}
		}
		return gridCoordinatesList;

	}

	public static void UpdatePlayerGrid(int numberOfRows, int numberOfColumns,
			ArrayList<Ship> ships, ArrayList<Coordinates> gridCoordinatesList,
			ArrayList<Coordinates> computerAttackCoords) {
		
		try {
		    Thread.sleep(1000);   
		    
		} catch(InterruptedException e) {
		    Thread.currentThread().interrupt();
		}
		
		System.out.println("\t \t -----PLAYER GRID-----              ");

		int rowLabel = 0;
		int columnLabel = 0;
		for (int x = 0; x < numberOfRows; x++) {
			System.out.print(rowLabel++);

			for (int y = 0; y < numberOfColumns; y++) {
				boolean hit = false;
				boolean shotFired = false;
				boolean shipCoordinate = false;

				for (Ship ship : ships) {
					if (ship.getShipCoordinates().getxLocation() == x
							&& ship.getShipCoordinates().getyLocation() == y) {
						shipCoordinate = true;
					}
					for (Coordinates attack5 : computerAttackCoords) {
						if (attack5.getxLocation() == x
								&& attack5.getyLocation() == y) {
							shotFired = true;
						}
					
						for (Coordinates attack1 : computerAttackCoords) {
							for (Ship ship1 : ships) {
								if (attack1.getxLocation() == x
										&& attack1.getyLocation() == y
										&& attack1.getxLocation() == ship1
												.getShipCoordinates().getxLocation()
										&& attack1.getyLocation() == ship1
												.getShipCoordinates().getyLocation()) {
									hit = true;

								}
							}
						}
					}
				}

				if (hit) {
					System.out.print("\t [X]");
				}else if (shotFired && hit == false) {
					System.out.print("\t [o]");
				} else if (shipCoordinate == true) {
					System.out.print("\t [B]");
				}  else {
					System.out.print("\t [ ]");
				}

			}
			System.out.println();
		}
		for (int x = 0; x < numberOfColumns; x++) {
			System.out.print("\t" + "  " + columnLabel++);
		}
		System.out.println("");

	}
	
	
	
	
	
	public static void UpdateComputerGrid(int numberOfRows, int numberOfColumns,
			ArrayList<Ship> computerShips, ArrayList<Coordinates> gridCoordinatesList,
			ArrayList<Coordinates> playerAttackCoords) {
		
		try {
		    Thread.sleep(1000);   
		    
		} catch(InterruptedException e) {
		    Thread.currentThread().interrupt();
		}
		
		System.out.println("\t \t ----COMPUTER GRID-----             ");

		int rowLabel = 0;
		int columnLabel = 0;
		for (int x = 0; x < numberOfRows; x++) {
			System.out.print(rowLabel++);

			for (int y = 0; y < numberOfColumns; y++) {
				boolean hit = false;
				boolean shotFired = false;

				for (Coordinates attack4 : playerAttackCoords) {
					if (attack4.getxLocation() == x
							&& attack4.getyLocation() == y) {
						shotFired = true;
					}
					

						for (Coordinates attack3 : playerAttackCoords) {
							for (Ship ship2 : computerShips) {
								if (attack3.getxLocation() == x&& attack3.getyLocation() == y
&& attack3.getxLocation() == ship2.getShipCoordinates().getxLocation()&& attack3.getyLocation() == ship2.getShipCoordinates().getyLocation()) {
									hit = true;

								}

							}
						}
					
				}

				if (shotFired && hit == false) {
					System.out.print("\t [o]");
				}else if (hit) {
					System.out.print("\t [X]");
				} else {
					System.out.print("\t [ ]");
				}

			}
			System.out.println();
			
		}
		for (int x = 0; x < numberOfColumns; x++) {
			System.out.print("\t" + "  " + columnLabel++);
		}
		System.out.println("");

	}
	
	
	
	

}
