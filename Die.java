/** A six-sided die. Its value is 0 until the first roll. */
public class Die {

    /** The number showing on top of the die. 0 before the first roll. */
    private int value = 0;

    /**
     * Makes a new six-sided die that has not been rolled yet.
     * Postcondition: getValue() returns 0.
     */
    public Die() {
    }

    /**
     * Rolls this die.
     * Postcondition: the die shows a new random number from 1 through 6.
     *
     * @return the number rolled, from 1 through 6
     */
    public int roll() {
        // TODO (Group 1 · Die & Player): store a random number from 1 through 6
        // in value, then return it.
        return 0; // placeholder so the file compiles
    }

    /**
     * Returns the number showing on this die without rolling it.
     *
     * @return the number rolled most recently, or 0 if this die has never been rolled
     */
    public int getValue() {
        // TODO (Group 1 · Die & Player): return the number showing now.
        return 0; // placeholder so the file compiles
    }
}
