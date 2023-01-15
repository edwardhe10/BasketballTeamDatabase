public abstract class TeamMember implements Comparable<TeamMember>{
    protected String memberID;
    protected String lastName;
    protected String firstName;
    protected int age;
    protected String role;

    /**
     * Initializes the TeamMember object.
     *
     * @param memberID The team member's ID
     * @param lastName The team member's last name
     * @param firstName The team member's first name
     * @param age The team member's age
     * @param role The team member's role
     */
    public TeamMember(String memberID, String lastName, String firstName, int age, String role){
        this.memberID = memberID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.role = role;
    }

    /**
     * Returns the team member's ID.
     *
     * @return The ID
     */
    public String getMemberID(){
        return memberID;
    }

    /**
     * Returns the team member's last name.
     *
     * @return The last name
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Returns the team member's first name.
     *
     * @return The first name
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Returns the team member's age.
     *
     * @return The age
     */
    public int getAge(){
        return age;
    }

    /**
     * Returns the team member's role.
     *
     * @return The role
     */
    public String getRole(){
        return role;
    }

    /**
     * Returns the string representation of the object.
     *
     * @return The team member's information
     */
    @Override
    public String toString(){
        return "Team Member: " + memberID + ", " + firstName + " " + lastName + ", " + age + ", " + role;
    }

    /**
     * Returns if this object is less than, equal to, or greater than the other object and sorts the team list alphabetically.
     *
     * @param other The other object to compare with
     * @return If the object is less than, equal to, or greater than the other object
     */
    public int compareTo(TeamMember other){
        // Sort by first name (A-Z)
        return this.firstName.compareTo(other.firstName);
    }

    /**
     * Abstract method that resets points for players or games for coaches.
     */
    abstract void reset();

    /**
     * Abstract method that prints information for a player or coach.
     */
    abstract void printInfo();
}