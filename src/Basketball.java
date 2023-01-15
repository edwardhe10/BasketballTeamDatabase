import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Basketball {
    private ArrayList<TeamMember> teamList;

    /**
     * Initializes the teamList array.
     */
    public Basketball(){
        teamList = new ArrayList<>();
    }

    /**
     * Loads the team list from a given file.
     *
     * @param filename The given filename to load
     * @return If loading the team list was successful or not
     */
    public boolean loadTeamList(String filename){
        BufferedReader reader;
        String line;
        try{
            reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();
            // null is the end of a line
            while (line != null){
                // Split at commas
                String[] info = line.split(",");
                if (info[5].equals("Player")){
                    teamList.add(new Player(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], Integer.parseInt(info[6]), Integer.parseInt(info[7]), Integer.parseInt(info[8]), Integer.parseInt(info[9]), Integer.parseInt(info[10]), Integer.parseInt(info[11]), Integer.parseInt(info[12])));
                }
                else if (info[5].equals("Coach")){
                    teamList.add(new Coach(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], Integer.parseInt(info[6]), Integer.parseInt(info[7])));
                }
                else{
                    // For invalid filename and format
                    throw new IOException();
                }
                line = reader.readLine();
            }
            reader.close();
            return true;
        }
        catch (IOException iox){
            System.out.println("Problem reading file.");
            return false;
        }
    }

    /**
     * Saves the team list to a file with a given filename.
     *
     * @param filename The filename to save to
     * @return If saving the team list was successful or not
     */
    public boolean saveTeamList(String filename){
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            for (TeamMember temp : teamList){
                out.write(temp.getMemberID() + "," + temp.getLastName() + "," + temp.getFirstName() + "," + temp.getAge() + "," + temp.getRole());
                // Check if team member is a player
                if (temp instanceof Player){
                    out.write(",Player," + ((Player) temp).getJerseyNumber() + "," + ((Player) temp).getThreeMade() + "," + ((Player) temp).getThreeAttempted() + "," + ((Player) temp).getTwoMade() + "," + ((Player) temp).getTwoAttempted() + "," + ((Player) temp).getFreeMade() + "," + ((Player) temp).getFreeAttempted() + "\n");
                }
                else{
                    out.write(",Coach," + ((Coach) temp).getNumGamesWon() + "," + ((Coach) temp).getNumGamesLost() + "\n");
                }
            }
            out.close();
            return true;
        }
        catch (IOException iox){
            System.out.println("Problem writing " + filename);
            return false;
        }
    }

    /**
     * Prints a list of all team members with their information.
     */
    public void listTeam(){
        System.out.println("All Team Members:");
        for (TeamMember temp : teamList) {
            System.out.println(temp);
        }
        System.out.println();
    }

    /**
     * Returns a team member given an ID if they are found.
     *
     * @param memberID The given ID to look for
     * @return The team member if they are found
     */
    public TeamMember getTeamMember(String memberID){
        for (TeamMember temp : teamList) {
            // If given ID matches an ID that exists in the team list
            if (temp.getMemberID().equals(memberID)) {
                return temp;
            }
        }
        return null;
    }

    /**
     * Adds a team member to the team list with given information.
     *
     * @param input The information for either player or coach
     */
    public void addTeamMember(Scanner input){
        String option;
        String[] info = new String[12];
        boolean match;
        boolean valid = true;

        while(valid){
            // Menu to choose what type of team member to add
            System.out.println("\nChoose an option");
            System.out.println("  1. Player");
            System.out.println("  2. Coach");
            System.out.print("> ");
            option = input.nextLine();

            switch (option){
                // Player
                case "1":{
                    System.out.println("Please enter player details:");
                    do{
                        match = false;
                        System.out.print("Team Member ID: ");
                        info[0] = input.nextLine();
                        // Check if the ID given already exists
                        for (TeamMember temp : teamList){
                            if (temp.memberID.equals(info[0])){
                                // If the ID exists, tell user to try again
                                match = true;
                                System.out.println("Member ID unavailable. Please try again.");
                            }
                        }
                    } while(match);
                    System.out.print("Last Name: ");
                    info[1] = input.nextLine();
                    System.out.print("First Name: ");
                    info[2] = input.nextLine();
                    System.out.print("Age: ");
                    info[3] = input.nextLine();
                    System.out.print("Role (Point Guard/Center/Shooting Guard/Small Forward/Power Forward): ");
                    info[4] = input.nextLine();
                    System.out.print("Jersey Number: ");
                    info[5] = input.nextLine();
                    System.out.print("Three Pointers Made: ");
                    info[6] = input.nextLine();
                    System.out.print("Three Pointers Attempted: ");
                    info[7] = input.nextLine();
                    System.out.print("Two Point Baskets Made: ");
                    info[8] = input.nextLine();
                    System.out.print("Two Point Baskets Attempted: ");
                    info[9] = input.nextLine();
                    System.out.print("Free Throws Made: ");
                    info[10] = input.nextLine();
                    System.out.print("Free Throws Attempted: ");
                    info[11] = input.nextLine();

                    teamList.add(new Player(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], Integer.parseInt(info[5]), Integer.parseInt(info[6]), Integer.parseInt(info[7]), Integer.parseInt(info[8]), Integer.parseInt(info[9]), Integer.parseInt(info[10]), Integer.parseInt(info[11])));
                    System.out.println("\nPlayer Team Member Added.\n");
                    valid = false;
                    break;
                }
                // Coach
                case "2":{
                    System.out.println("Please enter coach details:");
                    do{
                        match = false;
                        System.out.print("Team Member ID: ");
                        info[0] = input.nextLine();
                        // Check if the ID given already exists
                        for (TeamMember temp : teamList){
                            if (temp.memberID.equals(info[0])){
                                // If the ID exists, tell user to try again
                                match = true;
                                System.out.println("Member ID unavailable. Please try again.");
                            }
                        }
                    } while(match);
                    System.out.print("Last Name: ");
                    info[1] = input.nextLine();
                    System.out.print("First Name: ");
                    info[2] = input.nextLine();
                    System.out.print("Age: ");
                    info[3] = input.nextLine();
                    System.out.print("Role (Head Coach/Assistant Coach): ");
                    info[4] = input.nextLine();
                    System.out.print("Number of Games Won: ");
                    info[5] = input.nextLine();
                    System.out.print("Number of Games Lost: ");
                    info[6] = input.nextLine();

                    teamList.add(new Coach(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], Integer.parseInt(info[5]), Integer.parseInt(info[6])));
                    System.out.println("\nCoach Team Member Added.\n");
                    valid = false;
                    break;
                }
                default:{
                    System.out.println("\nInvalid option!");
                }
            }
        }
    }

    /**
     * Removes a team member of the given ID.
     *
     * @param memberID The ID of the team member to remove
     */
    public void removeTeamMember(String memberID){
        TeamMember temp = getTeamMember(memberID);
        if (temp != null){
            teamList.remove(temp);
        }
    }

    /**
     * Searches for a team member with given ID.
     *
     * @param memberID The ID to search for
     */
    public void searchID(String memberID){
        for (TeamMember temp : teamList){
            if (temp.getMemberID().equals(memberID)){
                System.out.println(temp);
            }
        }
    }

    /**
     * Searches for team members with the given role.
     *
     * @param role The role to search for
     */
    public void searchRole(String role){
        for (TeamMember temp : teamList){
            // If given role matches role of a team member, print
            // Uppercase and lowercase do not matter
            if (temp.getRole().equalsIgnoreCase(role)){
                System.out.println(temp);
            }
        }
    }

    /**
     * Sorts the team list by age in ascending order using insertion sort
     */
    public void sortAge(){
        // Insertion Sort
        int pos;
        TeamMember currValue;

        for (int i = 1; i < teamList.size(); i++) {
            pos = i;
            currValue = teamList.get(i);
            while (pos > 0 && (currValue.age < teamList.get(pos - 1).age)) {
                teamList.set(pos, teamList.get(pos - 1));
                pos--;
            }
            teamList.set(pos, currValue);
        }
    }

    /**
     * Sorts the team list by first name (A-Z)
     */
    public void sortFirstName(){
        Collections.sort(teamList);
    }

    /**
     * Prints the information of a team member of the given ID.
     *
     * @param memberID The ID of the team member to print
     */
    public void printTeamMemberInfo(String memberID){
        // If the team member does not exist
        if (getTeamMember(memberID) == null){
            System.out.println("Team Member " + memberID + " not found!\n");
        }
        // If the team member exists
        else{
            getTeamMember(memberID).printInfo();
        }
    }

    /**
     * Prints information for all the team members.
     */
    public void printAllInfo(){
        System.out.println("All Team Member Info:");
        for (TeamMember temp : teamList) {
            temp.printInfo();
        }
    }

    /**
     * Adds a certain amount of each type of point made and attempted for a player.
     *
     * @param memberID The ID of the player to add number of points made and attempted
     * @param amountThreeMade The amount of three pointers made
     * @param amountThreeAttempted The total amount of three pointers attempted
     * @param amountTwoMade The amount of two point baskets made
     * @param amountTwoAttempted The total amount of two point baskets attempted
     * @param amountFreeMade The amount of free throws made
     * @param amountFreeAttempted The total amount of free throws attempted
     */
    public void enterPoints(String memberID, int amountThreeMade, int amountThreeAttempted, int amountTwoMade, int amountTwoAttempted, int amountFreeMade, int amountFreeAttempted){
        // If the player exists
        if (getTeamMember(memberID) != null){
            ((Player) getTeamMember(memberID)).useThree(amountThreeMade);
            ((Player) getTeamMember(memberID)).attemptedThree(amountThreeAttempted);
            ((Player) getTeamMember(memberID)).useTwo(amountTwoMade);
            ((Player) getTeamMember(memberID)).attemptedTwo(amountTwoAttempted);
            ((Player) getTeamMember(memberID)).useFree(amountFreeMade);
            ((Player) getTeamMember(memberID)).attemptedFree(amountFreeAttempted);

            System.out.println("Information Updated.");
            System.out.println();
        }
        // If the player does not exist
        else{
            System.out.println("Player " + memberID + " not found!\n");
        }
    }

    /**
     * Adds a certain number of games won and lost for a coach.
     *
     * @param memberID The ID of the coach to add number of games won and lost
     * @param amountWon The amount of games won
     * @param amountLost The amount of games lost
     */
    public void addGame(String memberID, int amountWon, int amountLost){
        // If the coach exists
        if (getTeamMember(memberID) != null){
            ((Coach) getTeamMember(memberID)).addGamesWon(amountWon);
            ((Coach) getTeamMember(memberID)).addGamesLost(amountLost);

            System.out.println("Information Updated.");
            System.out.println();
        }
        else{
            // If the coach does not exist
            System.out.println("Coach " + memberID + " not found!\n");
        }
    }

    /**
     * Resets all the points made and attempted for all players to 0.
     */
    public void gamePointsReset(){
        for (TeamMember temp : teamList){
            // If the team member is a player
            if (temp instanceof Player){
                temp.reset();
            }
        }
    }

    /**
     * Resets all the games won and lost for all coaches to 0.
     */
    public void seasonGamesReset(){
        for (TeamMember temp : teamList){
            // If the team member is a coach
            if (temp instanceof Coach){
                temp.reset();
            }
        }
    }
}