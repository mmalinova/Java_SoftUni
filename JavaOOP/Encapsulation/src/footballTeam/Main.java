package footballTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Team> teams = new ArrayList<>();

        String command = scan.nextLine();
        while (!"END".equals(command)) {
            String[] tokens = command.split(";");
            String teamName = tokens[1];
            switch (tokens[0]) {
                //•	"Team;<TeamName>" – add a new team
                //•	"Add;<TeamName>;<PlayerName>;<Endurance>;<Sprint>;<Dribble>;<Passing>;<Shooting>"
                // – add a new player to the team
                //•	"Remove;<TeamName>;<PlayerName>" – remove the player from the team
                //•	"Rating;<TeamName>" – print the team rating, rounded to a closest integer
                case "Team":
                    try {
                        Team team = new Team(teamName);
                        teams.add(team);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Add":
                    String playerName = tokens[2];
                    int endurance = Integer.parseInt(tokens[3]);
                    int sprint = Integer.parseInt(tokens[4]);
                    int dribble = Integer.parseInt(tokens[5]);
                    int passing = Integer.parseInt(tokens[6]);
                    int shooting = Integer.parseInt(tokens[7]);
                    try {
                        Team team = getTeam(teams, teamName);
                        if (team != null) {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            team.addPlayer(player);
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Remove":
                    playerName = tokens[2];
                    try {
                        Team team = getTeam(teams, teamName);
                        if (team != null) {
                            team.removePlayer(playerName);
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Rating":
                    Team team = getTeam(teams, teamName);
                    if (team != null) {
                        System.out.println(teamName + " - " + Math.round(team.getRating()));
                    }
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static Team getTeam(List<Team> teams, String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        System.out.println("Team " + teamName + " does not exist.");
        return null;
    }
}