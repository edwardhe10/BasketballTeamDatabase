public class Player extends TeamMember{
    private int jerseyNumber;
    private int threePointersMade;
    private int threePointersAttempted;
    private int twoPointBasketsMade;
    private int twoPointBasketsAttempted;
    private int freeThrowsMade;
    private int freeThrowsAttempted;

    /**
     * Initializes the Player object.
     *
     * @param memberID The player's ID
     * @param lastName The player's last name
     * @param firstName The player's first name
     * @param age The player's age
     * @param role The player's role
     * @param jerseyNumber The player's jersey number
     * @param threePointersMade The amount of three pointers the player made
     * @param threePointersAttempted The amount of three pointers the player attempted
     * @param twoPointBasketsMade The amount of two point baskets the player made
     * @param twoPointBasketsAttempted The amount of two point baskets the player attempted
     * @param freeThrowsMade The amount of free throws the player made
     * @param freeThrowsAttempted The amount of free throws the player attempted
     */
    public Player(String memberID, String lastName, String firstName, int age, String role, int jerseyNumber, int threePointersMade, int threePointersAttempted, int twoPointBasketsMade, int twoPointBasketsAttempted, int freeThrowsMade, int freeThrowsAttempted){
        super(memberID, lastName, firstName, age, role);
        this.jerseyNumber = jerseyNumber;
        this.threePointersMade = threePointersMade;
        this.threePointersAttempted = threePointersAttempted;
        this.twoPointBasketsMade = twoPointBasketsAttempted;
        this.twoPointBasketsAttempted = twoPointBasketsAttempted;
        this.freeThrowsMade = freeThrowsMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    /**
     * Returns the player's jersey number.
     *
     * @return The jersey number
     */
    public int getJerseyNumber(){
        return jerseyNumber;
    }

    /**
     * Returns the amount of three pointers the player made.
     *
     * @return The amount of three pointers made
     */
    public int getThreeMade(){
        return threePointersMade;
    }

    /**
     * Returns the amount of two point baskets the player made.
     *
     * @return The amount of two point baskets made
     */
    public int getTwoMade(){
        return twoPointBasketsMade;
    }

    /**
     * Returns the amount of free throws the player made.
     *
     * @return The amount of free throws made
     */
    public int getFreeMade(){
        return freeThrowsMade;
    }

    /**
     * Returns the amount of three pointers the player attempted.
     *
     * @return The amount of three pointers attempted
     */
    public int getThreeAttempted(){
        return threePointersAttempted;
    }

    /**
     * Returns the amount of two point baskets the player attempted.
     *
     * @return The amount of two point baskets attempted
     */
    public int getTwoAttempted(){
        return twoPointBasketsAttempted;
    }

    /**
     * Returns the amount of free throws the player attempted.
     *
     * @return The amount of free throws attempted
     */
    public int getFreeAttempted(){
        return freeThrowsAttempted;
    }

    /**
     * Adds a certain amount of three pointers made for a player.
     *
     * @param amountThreeMade The amount of three pointers made added
     */
    public void useThree(int amountThreeMade){
        threePointersMade += amountThreeMade;
    }

    /**
     * Adds a certain amount of two point baskets made for a player.
     *
     * @param amountTwoMade The amount of two point baskets made added
     */
    public void useTwo(int amountTwoMade){
        twoPointBasketsMade += amountTwoMade;
    }

    /**
     * Adds a certain amount of free throws made for a player.
     *
     * @param amountFreeMade The amount of free throws made added
     */
    public void useFree(int amountFreeMade){
        freeThrowsMade += amountFreeMade;
    }

    /**
     * Adds a certain amount of three pointers attempted for a player.
     *
     * @param amountThreeAttempted The amount of three pointers attempted added
     */
    public void attemptedThree(int amountThreeAttempted){
        threePointersAttempted += amountThreeAttempted;
    }

    /**
     * Adds a certain amount of two point baskets attempted for a player.
     *
     * @param amountTwoAttempted The amount of two point baskets attempted added
     */
    public void attemptedTwo(int amountTwoAttempted){
        twoPointBasketsAttempted += amountTwoAttempted;
    }

    /**
     * Adds a certain amount of free throws attempted for a player.
     *
     * @param amountFreeAttempted The amount of free throws attempted added
     */
    public void attemptedFree(int amountFreeAttempted){
        freeThrowsAttempted += amountFreeAttempted;
    }

    /**
     * Calculates and returns the three pointer percentage for a player.
     *
     * @return The three pointer percentage
     */
    public double calculateThreesPercent(){
        if (threePointersMade == 0 && threePointersAttempted == 0){
            return 0;
        }
        else{
            return ((double) threePointersMade / threePointersAttempted) * 100;
        }
    }

    /**
     * Calculates and returns the two point basket percentage for a player.
     *
     * @return The two point basket percentage
     */
    public double calculateTwosPercent(){
        if (twoPointBasketsMade == 0 && twoPointBasketsAttempted == 0){
            return 0;
        }
        else{
            return ((double) twoPointBasketsMade / twoPointBasketsAttempted) * 100;
        }
    }

    /**
     * Calculates and returns the free throw percentage for a player.
     *
     * @return The free throw percentage
     */
    public double calculateFreesPercent(){
        if (freeThrowsMade == 0 && freeThrowsAttempted == 0){
            return 0;
        }
        else{
            return ((double) freeThrowsMade / freeThrowsAttempted) * 100;
        }
    }

    /**
     * Resets all the types of points made and attempted for a player.
     */
    public void reset(){
        threePointersMade = 0;
        twoPointBasketsMade = 0;
        freeThrowsMade = 0;
        threePointersAttempted = 0;
        twoPointBasketsAttempted = 0;
        freeThrowsAttempted = 0;
    }

    /**
     * Prints the player's information.
     */
    public void printInfo(){
        System.out.println("\n---------------------------------------");
        System.out.println(this);
        System.out.println("Jersey Number: " + jerseyNumber);
        System.out.println("Threes Made: " + threePointersMade + "  Threes Attempted: " + threePointersAttempted);
        System.out.printf("Threes Percentage: %.2f%%\n", calculateThreesPercent());
        System.out.println("Twos Made: " + twoPointBasketsMade + "  Twos Attempted: " + twoPointBasketsAttempted);
        System.out.printf("Twos Percentage: %.2f%%\n", calculateTwosPercent());
        System.out.println("Frees Made: " + freeThrowsMade + "  Frees Attempted: " + freeThrowsAttempted);
        System.out.printf("Frees Percentage: %.2f%%\n", calculateFreesPercent());
        System.out.println("---------------------------------------\n");
    }

    /**
     * Returns the string representation of the object.
     *
     * @return The player's information
     */
    @Override
    public String toString(){
        return super.toString() + ", Player";
    }
}