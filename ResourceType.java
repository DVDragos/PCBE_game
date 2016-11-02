package resource;

/**
 * @author Teo Interface for ResourceType
 */
public interface ResourceType {

	/**
	 * @return The total number of the resource type on the map
	 * 
	 */
	public int getNrOfResourceOnMap();

	/**
	 * @return The total number of the resource type that MUST be on the map
	 * 
	 */
	public int getNrMUstOnMap();

	/**
	 * @return The X position on the Map of the created resource type
	 */
	public int getPositionXOnMap();

	/**
	 * @return The Y position on the Map of the created resource type
	 */
	public int getPositionYOnMap();

	/**
	 * After The Resource was created and it's coordinates where validated for
	 * populating the map the number of the resource type on the map increases
	 */
	public void addResourceToTheMap();

	/**
	 * After The Resource was collected by one of the teams, it disappears from
	 * the map therefore the number of this recourse types needs to be
	 * decremented
	 */
	public void removeResourceToTheMap();
}
