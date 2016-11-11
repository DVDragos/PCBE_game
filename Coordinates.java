package map;

import java.util.concurrent.Semaphore;

public class Coordinates {

	private int x;
	private int y;
	private boolean available = true;
	private final Semaphore semaphore;

	public boolean isAvailable() {
		return available;
	}

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
		semaphore = new Semaphore(1);
	}
	
	/**
	 * Method to release the current coordinate
	 */
	public void releaseCoordinate() {
		available = true;
	}
	
	/**
	 * Method to occupy the current coordinate
	 * @return true if current Coordinate was free and now occupied,
	 * 			false if current Coordinate is not free
	 */
	public boolean occupyCoordinate() {
		boolean canBeOcupy = false;
		
		try {
			semaphore.acquire();
			if(available) {
				available = false;
				canBeOcupy = true;
			}
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return canBeOcupy;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	/**
	 * Method to return the distance between current element and the desired element
	 * @param x desired coordinate
	 * @param y desired coordinate
	 * @return distance from current object to desired element
	 */
	public double getDistance(int x, int y) {
		return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
	}
}