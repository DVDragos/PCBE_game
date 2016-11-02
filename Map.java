package map;

import java.util.ArrayList;
import java.util.List;

public class Map {

	private List<Coordinates> mMap;
	private int mHeight;
	private int mWidth;

	public List<Coordinates> getMap() {
		return mMap;
	}

	public Map(int height, int width) {
		mMap = new ArrayList<>();
		mHeight = height;
		mWidth = width;
	}

	/**
	 * Add object on map
	 * @param coordinates represents the coordinates where to add the new object
	 */
	public synchronized void addObjectToMap(Coordinates coordinates) {
		if (!checkCoordinates(coordinates.getX(), coordinates.getY())) {
			return;
		}
		if(isCoordinateFree(coordinates.getX(), coordinates.getY())){
			mMap.add(coordinates);
			System.out.println(coordinates.getObjectType().name() + " added on map at coordinates: "
					+ coordinates.getX() + ", " + coordinates.getY());
		} else {
			System.out.println("There is something on the map on coordinates " + coordinates.getX() + ", "
					+ coordinates.getY());
		}
	}

	/**
	 * Removes the object from map. 
	 * P.S. The type of object to delete from the specified coordinates should match
	 * @param coordinates represents the coordinates where from where to delete the object
	 */
	public synchronized void removeObjectFromMap(Coordinates coordinates) {
		if (!checkCoordinates(coordinates.getX(), coordinates.getY())) {
			return;
		}
		if(!isCoordinateFree(coordinates.getX(), coordinates.getY())){
			if (coordinates.getObjectType().name().equals(coordinates.getObjectType().name())) {
				mMap.remove(coordinates);
			} else {
				System.out.println("Cannot delete object because the object type doesn't match!");
			}
		} else {
			System.out.println("There is nothing at those coordinates!");
		}
	}

	/**
	 * Helper method for checking if coordinates are inside the map
	 * @param x
	 * @param y
	 * @return true if the coordinates are inside the map
	 */
	private boolean checkCoordinates(int x, int y) {
		if (x < 0 || x > mHeight) {
			System.out.println("The X coordinate is outside the map.");
			return false;
		}
		if (y < 0 || y > mWidth) {
			System.out.println("The Y coordinate is outside the map.");
			return false;
		}
		return true;
	}

	/**
	 * Method for checking if at the specified coordinates is a free spot 
	 * @param x
	 * @param y
	 * @return true if there is nothing at the coordinates
	 */
	public boolean isCoordinateFree(int x, int y) {
		for (Coordinates coord : mMap) {
			if(coord.getX() == x && coord.getY() == y) {
				return false;
			}
		}
		return true;
	}
}
