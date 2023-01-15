public class Coach extends TeamMember{
    private int numGamesWon;
    private int numGamesLost;

    /**
     * Initializes the Coach object.
     *
     * @param memberID The coach's ID
     * @param lastName The coach's last name
     * @param firstName The coach's first name
     * @param age The coach's age
     * @param role The coach's role
     * @param numGamesWon The coach's number of games won
     * @param numGamesLost The coach's number of games lost
     */
    public Coach(String memberID, String lastName, String firstName, int age, String role, int numGamesWon, int numGamesLost){
        super(memberID, lastName, firstName, age, role);
        this.numGamesWon = numGamesWon;
        this.numGamesLost = numGamesLost;
    }

    /**
     * Returns the coach's number of games won.
     *
     * @return The number of games won
     */
    public int getNumGamesWon(){
        return numGamesWon;
    }

    /**
     * Returns the coach's number of games lost.
     *
     * @return The number of games lost
     */
    public int getNumGamesLost(){
        return numGamesLost;
    }

    /**
     * Adds a certain amount of games won for a coach.
     *
     * @param amountWon The amount of games won added
     */
    public void addGamesWon(int amountWon){
        numGamesWon += amountWon;
    }

    /**
     * Adds a certain amount of games lost for a coach.
     *
     * @param amountLost The amount of games lost added
     */
    public void addGamesLost(int amountLost){
        numGamesLost += amountLost;
    }

    /**
     * Calculates and returns the win rate for a coach.
     *
     * @return The win rate
     */
    public double calculateWinLoss(){
        if (numGamesWon == 0 && numGamesLost == 0){
            return 0;
        }
        else{
            return ((double) numGamesWon / (numGamesWon + numGamesLost)) * 100;
        }
    }

    /**
     * Resets the number of games won and lost for a coach.
     */
    public void reset(){
        numGamesWon = 0;
        numGamesLost = 0;
    }

    /**
     * Prints the coach's information.
     */
    public void printInfo(){
        System.out.println("\n---------------------------------------");
        System.out.println(this);
        System.out.println("Games Won: " + numGamesWon);
        System.out.println("Games Lost: " + numGamesLost);
        System.out.printf("Win Rate: %.2f%%\n", calculateWinLoss());
        System.out.println("---------------------------------------\n");
    }

    /**
     * Returns the string representation of the object.
     *
     * @return The coach's information
     */
    @Override
    public String toString(){
        return super.toString() + ", Coach";
    }
}