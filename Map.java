package map;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Map {

	private List<Element> mMap;
	private int mHeight;
	private int mWidth;
	private List<Coordinates> allCoordinates;
	private final Semaphore semaphore;

	public List<Element> getMap() {
		return mMap;
	}

	private void initCoordinates() {
		allCoordinates = new ArrayList<>();
		for(int x = 0; x < mHeight; x++){
			for(int y = 0; y < mWidth; y++){
				allCoordinates.add(new Coordinates(x, y));
			}
		}
	}
	
	public Map(int height, int width) {
		mMap = new ArrayList<>();
		mHeight = height;
		mWidth = width;
		semaphore = new Semaphore(1);
		initCoordinates();
	}
	
	/**
	 * Add Element on map
	 * 
	 * @param element
	 */
	public void addElementToMap(Element element) {
		if(!mMap.contains(element)){
			mMap.add(element);
		}
	}

	/**
	 * Removes the Element from map. P.S. The type of Element to delete from the
	 * specified coordinates should match
	 * 
	 * @param coordinates 
	 *            represents the coordinates where from where to delete the
	 *            Element
	 */
	public void removeElementFromMap(Element element) {
		boolean elementFound = false;
		for (Element elem : mMap) {
			if (elem.getCoordinates().getX() == element.getCoordinates().getX()
					&& elem.getCoordinates().getY() == element.getCoordinates().getY()) {
				elementFound = true;
				if (element.getElementType().equals(elem.getElementType())) {
					System.out.println("Element " + elem.getElementType() + " has been removed!");
					try {
						semaphore.acquire();
						mMap.remove(element);
						semaphore.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("Cannot delete Element because the ElementType doesn't match!");
				}
			}
		}
		if (!elementFound) {
			System.out.println("There is nothing at those coordinates!");
		}
	}

	/**
	 * Method for checking if at the specified coordinates is a free spot
	 * 
	 * @param x
	 * @param y
	 * @return true if there is nothing at the coordinates
	 */
	public boolean isCoordinateFree(int x, int y) {
		Coordinates coord = new Coordinates(x, y);
		if(allCoordinates.get(allCoordinates.indexOf(coord)).isAvailable()){
			return true;
		}
		return false;
	}

	/**
	 * Method to return a 3x3 map around a specified element to see its
	 * neighbors
	 * 
	 * @param element
	 *            reference for constructing the map
	 * @return list of elements around given element
	 */
	public List<Element> get5x5MapAroundPlayer(Element element) {
		if (!mMap.contains(element)) {
			System.out.println("This element is not on map");
			return null;
		}
		final int x = element.getCoordinates().getX();
		final int y = element.getCoordinates().getY();
		List<Element> returnList = new ArrayList<>();
		int xDiff = 0; // distance on x axis between given element and elements
						// on map
		int yDiff = 0; // distance on y axis between given element and elements
						// on map

		for (Element elem : mMap) {
			xDiff = Math.abs(elem.getCoordinates().getX() - x);
			yDiff = Math.abs(elem.getCoordinates().getY() - y);
			if (xDiff <= 2 && yDiff <= 2) {
				returnList.add(elem);
			}
		}
		return returnList;
	}
	
	/**
	 * Method to check if the Coordinate is available and mark it as occupied
	 * @param coord is the coordinate which could be occupied
	 * @return true if the coordinate can be occupied, false otherwise
	 */
	public boolean occupyCoordinate(Coordinates coord) {
		if(allCoordinates.contains(coord)){
			Coordinates c = allCoordinates.get(allCoordinates.indexOf(coord));
			if(c.isAvailable()){
				if(c.occupyCoordinate()) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * Method to check if the Coordinate is available and mark it as occupied
	 * @param coord is the coordinate which could be occupied
	 * @return true if the coordinate can be occupied, false otherwise
	 */
	public void releaseCoordinate(Coordinates coord) {
		if(allCoordinates.contains(coord)){
			Coordinates c = allCoordinates.get(allCoordinates.indexOf(coord));
			c.releaseCoordinate();
		}
	}
}
