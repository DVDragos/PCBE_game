package map;

public class Coordinates {

	private int x;
	private int y;
	private ObjectType mObjectType;

	public Coordinates(int x, int y, ObjectType objectType) {
		this.x = x;
		this.y = y;
		mObjectType = objectType;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ObjectType getObjectType() {
		return mObjectType;
	}

}