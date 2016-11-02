package resource;

/**
 * @author Teo Resource type Goldmine
 */
public class Goldmine implements ResourceType {

	private static int nrOfResourceOnMap = 0;
	private final int nrMustOnMap = 10;

	private int x;
	private int y;

	/**
	 * Constructor On each new Goldmine Resource created, the number of quarries
	 * present on the map increases
	 * 
	 * @param x
	 *            the X position on the map of the Goldmine resource when
	 *            created
	 * 
	 * @param y
	 *            the Y position on the map of the Goldmine resource when
	 *            created
	 */

	public Goldmine(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getNrOfResourceOnMap() {
		return Goldmine.nrOfResourceOnMap;
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
		Goldmine.nrOfResourceOnMap++;
	}

	@Override
	public void removeResourceToTheMap() {
		Goldmine.nrOfResourceOnMap--;
		
	}
}
