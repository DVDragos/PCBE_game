package resource;

/**
 * @author Teo Resource type Quarry
 */
public class Quarry implements ResourceType {

	private int x;
	private int y;

	private static int nrOfResourceOnMap = 0;
	private final int nrMustOnMap = 10;

	/**
	 * Constructor On each new Quarry Resource created, the number of quarries
	 * present on the map increases
	 * 
	 * @param x
	 *            the X position on the map of the quarry resource when created
	 * 
	 * @param y
	 *            the Y position on the map of the quarry resource when created
	 */

	public Quarry(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getNrOfResourceOnMap() {
		return Quarry.nrOfResourceOnMap;
	}

	@Override
	public int getNrMUstOnMap() {
		return this.nrMustOnMap;
	}

	@Override
	public int getPositionXOnMap() {
		return this.x;
	}

	@Override
	public int getPositionYOnMap() {
		return this.y;
	}

	@Override
	public void addResourceToTheMap() {
		Quarry.nrOfResourceOnMap++;
	}

	@Override
	public void removeResourceToTheMap() {
		Quarry.nrOfResourceOnMap--;
		
	}
}
