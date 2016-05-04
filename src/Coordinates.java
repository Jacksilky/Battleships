public class Coordinates {

	private int yLocation = 0;
	private int xLocation = 0;

	public Coordinates(int yLocation, int xLocation) {

		this.yLocation = yLocation;
		this.xLocation = xLocation;

	}

	public int getyLocation() {
		return yLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

	public int getxLocation() {
		return xLocation;
	}

	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	@Override
	public String toString() {
		return this.yLocation + "," + this.xLocation;
	}


}
