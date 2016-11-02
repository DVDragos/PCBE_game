package player;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String mName;
	private List<Player> mTeamMember;

	public Team(String name) {
		mTeamMember = new ArrayList<>();
		mName = name;
	}

	public String getName() {
		return mName;
	}

	/**
	 * Method for adding players to team
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

	public List<Player> getTeamMember() {
		return mTeamMember;
	}
}
