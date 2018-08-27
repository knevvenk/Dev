import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PickTeams {

	public static void main(String[] args) {
		BufferedReader reader = null;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader("C:\\Dev\\pickteams.txt"));
			line = reader.readLine();
			while (line != null && !"0".equals(line)) {
				solve(line, reader);
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void solve(String runSize, BufferedReader reader) {
		List<Team> runList = new ArrayList<Team>();
		int size = Integer.parseInt(runSize);
		String team = null;
		for (int i = 0; i < size; i++) {
			try {
				team = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			runList.add(new Team(team));
		}

		Team team1 = null;
		Team team2 = null;
		Integer minSum = -1;
		
		for (int i = 0; i < runList.size() - 1; i++) {
			for (int j = i + 1; j < runList.size(); j++) {
				team1 = runList.get(i);
				team2 = runList.get(j);

				if (!disJoint(team1, team2)) {
					Integer teamSum = team1.getTime() + team2.getTime();
					if (minSum == -1)
						minSum = teamSum;
					else
						minSum = Math.min(teamSum, minSum);
				}
			}
		}
		System.out.println(minSum);
	}

	private static boolean disJoint(Team team1, Team team2) {
		List<Integer> team1List = team1.playersList;
		List<Integer> team2List = team2.playersList;
		for (int i = 0; i < team1List.size(); i++) {
			for (int j = 0; j < team2List.size(); j++) {
				if (team1List.get(i) == team2List.get(j))
					return true;
			}

		}
		return false;
	}

}


class Team {
	List<Integer> playersList = new ArrayList<Integer>();
	int time;

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	Team(String team) {
		String[] teamArray = team.split(" ");
		for (int i = 0; i < teamArray.length - 1; i++) {
			this.playersList.add(Integer.parseInt(teamArray[i]));
		}
		this.time = Integer.parseInt(teamArray[teamArray.length - 1]);
	}

}
