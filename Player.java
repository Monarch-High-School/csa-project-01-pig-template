import java.util.Scanner;

/** A Pig player with a name, banked score, and console input. */
public class Player {
    private static Scanner consoleInput;

    private String name;
    private int score = 0;
    private Scanner input;

    /** Creates a player using the shared console reader. */
    public Player(String name) {
        this.name = name;
    }

    /** Creates a player using the supplied reader, which remains open. */
    public Player(String name, Scanner input) {
        this.name = name;
        this.input = input;
    }

    /**
     * Returns this player's name.
     *
     * @return the name given when this player was created
     */
    public String getName() {
        // TODO (Group 1 · Die & Player): return the name.
        return ""; // placeholder so the file compiles
    }

    /**
     * Returns this player's overall score: banked points only.
     *
     * @return the banked score, 0 for a new player
     */
    public int getScore() {
        // TODO (Group 1 · Die & Player): return the banked score.
        return 0; // placeholder so the file compiles
    }

    /**
     * Prompts until the player chooses 1 (roll) or 2 (bank); returns 0 at end of input.
     * Supplied. Do not edit.
     */
    public int getChoice() {
        if (input == null) {
            if (consoleInput == null) {
                consoleInput = new Scanner(System.in);
            }
            input = consoleInput;
        }
        while (true) {
            System.out.print(name + ", enter 1 to roll or 2 to bank: ");
            if (!input.hasNextLine()) {
                return 0;
            }
            String choice = input.nextLine().trim();
            if (choice.equals("1")) {
                return 1;
            }
            if (choice.equals("2")) {
                return 2;
            }
            System.out.println("Please enter 1 or 2.");
        }
    }

    /**
     * Adds points to the overall score. Game.bank() calls this method.
     * Postcondition: getScore() is larger by points.
     *
     * @param points the points to add, 0 or more
     */
    public void addToScore(int points) {
        // TODO (Group 1 · Die & Player): increase score by points.
    }
}
