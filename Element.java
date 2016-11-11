package map;

public class Element {

	private Coordinates mCoordinates;
	private ElementType mElementType;
	private ElementContainer mElementContainer;

	public Element(ElementType elem, Coordinates coordinates) {
		mCoordinates = coordinates;
		mElementType = elem;
		mElementContainer = new ElementContainer(elem);
	}

	public Coordinates getCoordinates() {
		return mCoordinates;
	}

	public void setNewCoordinates(Coordinates coord) {
		mCoordinates = coord;
	}
	
	public String getElementType() {
		return mElementType.name();
	}

	public synchronized ElementContainer getElementContainer() {
		return mElementContainer;
	}
}
