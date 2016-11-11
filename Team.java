package player;

import java.util.ArrayList;
import java.util.List;
import resource.Building;

public class Team extends Thread{

	private String mName;
	private List<Player> mTeamMember;
	private List<Building> mBuilding;
	private int mWoodResource;
	private int mStoneResource;
	private int mGoldResource;
	private int mPoints;

	public int getPoints() {
		return mPoints;
	}
	
	@Override
	public void run(){
		addResourceFromBuilding();
	}
	
	/**
	 * Method for adding resources from building. This method add resources from all buildings
	 * from the current team list.
	 */
	private void addResourceFromBuilding() {
		for (Building b : mBuilding) {
			switch (b.getBuildingType()) {
				case LUMBERMILL: {
					mWoodResource = b.addResourceFromBuilding(mWoodResource);
					break;
				}
				case GOLDMINE: {
					mStoneResource = b.addResourceFromBuilding(mStoneResource);
					break;
				}
				case QUARRY: {
					mGoldResource = b.addResourceFromBuilding(mGoldResource);
					break;
				}
			}
		}
	}
	
	public void addBuildingToTeam(Building building) {
		mBuilding.add(building);
	}
	
	/**
	 * Method to add points to the team. Points can be added if player gathers a
	 * mine, kills another player, constructs a building or reaches the opposite
	 * end of the map.
	 * 
	 * @param points
	 */
	public synchronized void addPoints(int points) {
		mPoints += points;
	}

	public int getWoodResource() {
		return mWoodResource;
	}

	public int getStoneResource() {
		return mStoneResource;
	}

	public int getGoldResource() {
		return mGoldResource;
	}

	/**
	 * Add the specified amount of wood to team
	 * 
	 * @param wood
	 */
	public synchronized void addWoodToStorage(int wood) {
		mWoodResource += wood;
	}

	/**
	 * Add the specified amount of stone to team
	 * 
	 * @param stone
	 */
	public synchronized void addStoneToStorage(int stone) {
		mStoneResource += stone;
	}

	/**
	 * Add the specified amount of gold to team
	 * 
	 * @param gold
	 */
	public synchronized void addGoldToStorage(int gold) {
		mGoldResource += gold;
	}

	/**
	 * Remove the specified amount of wood from team
	 * 
	 * @param wood
	 */
	public synchronized void removeWoodToStorage(int wood) {
		if (mWoodResource >= wood) {
			mWoodResource -= wood;
		}
	}

	/**
	 * Remove the specified amount of stone from team
	 * 
	 * @param stone
	 */
	public synchronized void removeStoneToStorage(int stone) {
		if (mStoneResource >= stone) {
			mStoneResource -= stone;
		}
	}

	/**
	 * Remove the specified amount of gold from team
	 * 
	 * @param gold
	 */
	public synchronized void removeGoldToStorage(int gold) {
		if (mGoldResource > gold) {
			mGoldResource -= gold;
		}
	}

	public Team(String name) {
		mTeamMember = new ArrayList<>();
		mBuilding = new ArrayList<>();
		mName = name;
		mGoldResource = 0;
		mStoneResource = 0;
		mWoodResource = 0;
	}

	public String getTeamName() {
		return mName;
	}

	/**
	 * Method for adding players to team
	 * 
	 * @param player
	 */
	public synchronized void addPlayerToTeam(Player player) {
		if (!mTeamMember.contains(player)) {
			mTeamMember.add(player);
			System.out.println("Player added to team " + mName);
		} else {
			System.out.println("Player already exists in this team.");
		}
	}

	/**
	 * Method for removing player from team
	 * 
	 * @param player
	 */
	public synchronized void removePlayerFromTeam(Player player) {
		if (mTeamMember.contains(player)) {
			mTeamMember.remove(player);
			System.out.println("Player removed from team " + mName);
		} else {
			System.out.println("This player doesn't exist.");
		}
	}

	public List<Player> getTeamMembers() {
		return mTeamMember;
	}
}
