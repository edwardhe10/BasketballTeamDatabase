import java.util.Scanner;

public class Main {
    static final String FILE_PATH = "src/";
    static Scanner INPUT = new Scanner(System.in);
    static Basketball basketball = null;

    public static void main(String[] args) {
        String filename = "";
        String option;
        boolean success;

        boolean running = true;

        while (running){
            printMenu();

            if (basketball != null){
                System.out.print("> ");
                option = INPUT.nextLine();
            }
            else{
                System.out.println("There is no file loaded!");
                option = "1";
            }

            switch (option){
                // Exit
                case "0":{
                    System.out.println("Exiting...\n");
                    running = false;
                    break;
                }
                // Load team list
                case "1":{
                    boolean loaded;
                    basketball = new Basketball();
                    do{
                        System.out.printf("Enter a filename to load (default location: %s): ", FILE_PATH);
                        filename = INPUT.nextLine();
                        loaded = basketball.loadTeamList(FILE_PATH + filename);
                        if (loaded){
                            System.out.println("Team list in file \'" + filename + "\' loaded.");
                            System.out.println();
                        }
                        else{
                            System.out.println("Team list not loaded!");
                        }
                    }
                    while (!loaded);
                    break;
                }
                // Save team list
                case "2":{
                    System.out.print("Do you want to use the same filename (" + filename + ")? (y/n) ");
                    option = INPUT.nextLine();
                    if (!option.equals("y")){
                        System.out.print("Enter a filename to save: ");
                        filename = INPUT.nextLine();
                    }
                    System.out.println("Saving file...");
                    basketball.saveTeamList(FILE_PATH + filename);
                    System.out.println();
                    break;
                }
                // Add team member
                case "3":{
                    basketball.addTeamMember(INPUT);
                    break;
                }
                // Remove team member
                case "4":{
                    success = false;
                    String memberID;
                    do{
                        System.out.print("Enter a member ID to remove: ");
                        memberID = INPUT.nextLine();
                        if (basketball.getTeamMember(memberID) != null){
                            success = true;
                        }
                        else{
                            System.out.println("\nInvalid ID. Please try again.\n");
                        }
                    }
                    while (!success);
                    basketball.removeTeamMember(memberID);
                    System.out.println("Team member removed.\n");
                    break;
                }
                // Add points to a player
                case "5":{
                    System.out.println("Add Points (Scored/Attempted)");
                    System.out.print("Enter a member ID: ");
                    String memberID = INPUT.nextLine();

                    System.out.print("Enter three pointers made: ");
                    int threeMade = Integer.parseInt(INPUT.nextLine());
                    System.out.print("Enter three pointers attempted: ");
                    int threeAttempted = Integer.parseInt(INPUT.nextLine());

                    System.out.print("Enter two point baskets made: ");
                    int twoMade = Integer.parseInt(INPUT.nextLine());
                    System.out.print("Enter two point baskets attempted: ");
                    int twoAttempted = Integer.parseInt(INPUT.nextLine());

                    System.out.print("Enter free throws made: ");
                    int freeMade = Integer.parseInt(INPUT.nextLine());
                    System.out.print("Enter free throws attempted: ");
                    int freeAttempted = Integer.parseInt(INPUT.nextLine());

                    basketball.enterPoints(memberID, threeMade, threeAttempted, twoMade, twoAttempted, freeMade, freeAttempted);
                    break;
                }
                // Add games to a coach
                case "6":{
                    System.out.println("Add Games (Won/Lost)");
                    System.out.print("Enter a member ID: ");
                    String memberID = INPUT.nextLine();

                    System.out.print("Enter number of games won: ");
                    int won = Integer.parseInt(INPUT.nextLine());
                    System.out.print("Enter number of games lost: ");
                    int lost = Integer.parseInt(INPUT.nextLine());

                    basketball.addGame(memberID, won, lost);
                    break;
                }
                // List all team members
                case "7":{
                    basketball.listTeam();
                    break;
                }
                // Print info for one team member
                case "8":{
                    System.out.println("Information of one team member");
                    System.out.print("Enter a member ID: ");
                    String memberID = INPUT.nextLine();

                    basketball.printTeamMemberInfo(memberID);
                    break;
                }
                // Print info for all team members
                case "9":{
                    System.out.println("Information of all teams members");
                    basketball.printAllInfo();
                    break;
                }
                // Search for a team member by ID
                case "10":{
                    System.out.print("Enter a member ID to search for: ");
                    String memberID = INPUT.nextLine();

                    System.out.println("Search Results:");
                    basketball.searchID(memberID);
                    System.out.println();
                    break;
                }
                // Search for team members by role
                case "11":{
                    System.out.print("Enter a role to search for: ");
                    String role = INPUT.nextLine();

                    System.out.println("Search Results:");
                    basketball.searchRole(role);
                    System.out.println();
                    break;
                }
                // Sort team members by age (ascending order)
                case "12":{
                    System.out.println("Sort by age (ascending order)");
                    basketball.sortAge();
                    System.out.println("Sorted!\n");
                    break;
                }
                // Sort team members by first name (A-Z)
                case "13":{
                    System.out.println("Sort by first name (A-Z)");
                    basketball.sortFirstName();
                    System.out.println("Sorted!\n");
                    break;
                }
                // Reset all points for players
                case "14":{
                    System.out.println("Reset All Player Points");
                    basketball.gamePointsReset();
                    System.out.println("Done!\n");
                    break;
                }
                // Reset all games for coaches
                case "15":{
                    System.out.println("Reset All Coach Games");
                    basketball.seasonGamesReset();
                    System.out.println("Done!\n");
                    break;
                }
                default:{
                    System.out.println("\nInvalid option!\n");
                }
            }
            System.out.print("Press Enter to continue...");
            INPUT.nextLine();
            System.out.println();
        }
    }

    public static void printMenu(){
        System.out.println("Basketball Tracking Database");
        System.out.println("----------------------------");
        System.out.println("Choose an option from the menu:");
        System.out.println("  1. Load team list from file");
        System.out.println("  2. Save team list to file");
        System.out.println("  3. Add a team member");
        System.out.println("  4. Remove a team member");
        System.out.println("  5. Add Points Scored/Attempted to a player");
        System.out.println("  6. Add Games Won/Lost to a coach");
        System.out.println("  7. List all team members");
        System.out.println("  8. Print Info for a team member");
        System.out.println("  9. Print Info for all team members");
        System.out.println("  10. Search for a team member by ID");
        System.out.println("  11. Search for team members by role");
        System.out.println("  12. Sort team members by age in ascending order");
        System.out.println("  13. Sort team members by first name (A-Z)");
        System.out.println("  14. Reset All Player Points");
        System.out.println("  15. Reset All Coach Games");
        System.out.println("  0. Exit");
    }
}