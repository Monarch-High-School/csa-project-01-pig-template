import java.util.Scanner;

public class Pig {

    /**
     * A helper method for rolling a six-sided die.
     * Returns a random integer from 1 through 6
     * Preconditions: None
     */
    public static int rollDie() {
        // TODO: Replace 0 with an expression that generates
        // a random integer from 1 through 6.
        //
        // Build your expression in three steps:
        // 1. Math.random() produces a decimal from 0 up to, but not including, 1.
        //    What should you multiply by to create six possible outcomes?
        // 2. Cast the result of the multiplication to int to remove the decimal.
        //    Be careful: casting Math.random() BEFORE multiplying always gives 0!
        // 3. Shift the range so the lowest possible result is 1, not 0.

        int die = 0; // Temporary placeholder; 0 is not a valid die roll.

        return die;
    }

    /*
    * In iteration 1, we just want to let one user play
    * and keep track of how many turns it takes to win.
    * finish the TODOs to implement this!
    */
    public static void main(String[] args) {

        // let's declare some important things up front
        Scanner input = new Scanner(System.in);
        int WINNING_SCORE = 100;
        int overallScore = 0;
        int turnNumber = 1; // for tracking how many turns the user has taken

        // TODO: Print a welcome message with some basic instructions
        // to the user on how to play

        // OUTER LOOP: each loop is a new round
        // Keeps going until the player's overall score reaches the winning score.
        while (overallScore < WINNING_SCORE) {

            System.out.println();

            // TODO: Display the turn number and overall score.
            // Example: Turn 3, Overall score: 24

            // These variables belong to ONE turn.
            // Because of this they are inside the outer loop, each new turn
            int turnScore = 0;
            boolean stillRolling = true;

            // INNER LOOP: repeats for each decision within this turn.
            while (stillRolling) {

                System.out.println();
                System.out.println("1 = Roll");
                System.out.println("2 = Bank");
                System.out.print("Enter your choice: ");

                // TODO: use the Scanner 'input' to read in the user choice
                // into an int variable called 'choice'

                if (choice == 1) {

                    int die = rollDie();
                    System.out.println("You rolled a " + die + ".");

                    if (die == 1) {

                        System.out.println("You lost your points!");

                        // TODO: Set the turn score back to zero.
                        // Do NOT change overallScore: banked points are safe.

                        // TODO: End this turn.
                        // Which boolean variable controls the INNER loop?
                        // Give it the value that will stop that loop.
                        // Do not stop the entire program.

                    } else {

                        // TODO: Add the die result to the turn score.
                        // Keep the points already earned during this turn.
                        // Example: a turn score of 8 and a roll of 5
                        // should produce a turn score of 13.
                        //
                        // Do NOT add these points to overallScore yet.


                    }

                    // TODO: Display the updated turn score.
                    // This helps the player decide whether to risk
                    // another roll or bank their points.

                } else if (choice == 2) {

                    // TODO: Bank the points.
                    // Add turnScore to the existing overallScore.
                    // Example: 20 banked points plus 12 turn points
                    // should produce an overall score of 32.
                    //
                    // Do not replace overallScore with just turnScore.

                    // TODO: End this turn and display the new overall score.
                    // Stop the INNER loop so the same points cannot
                    // be banked again during this turn.
                    //
                    // You do not need to reset turnScore here:
                    // where does the next turn set it back to zero?


                } else {
                    // We get here if the user inputs something not a 1 or 2
                    // An invalid number should not end the turn
                    // or change either score.
                    System.out.println("Please enter 1 or 2.");
                }
            }

            // We reach this point only after a turn has ended.

            // TODO: Increase the turn number by one.
            // This happens ONCE per completed turn, not once per roll.
        }

        // We reach this point only when the outer loop has finished.

        // TODO: Display a winning message, the final overall score,
        // and the number of turns used.
        //
        // Think carefully about the turn count:
        // The turn-number TODO above advances turnNumber after the final turn too.
        // If the player won on turn 4, what is turnNumber now?
        // What should you display instead?


        input.close();
    }
}
