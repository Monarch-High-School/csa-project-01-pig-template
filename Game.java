/** A Pig game with players, turn state, scoring, and dice rolls. */
public class Game {

    /** The die used by the interactive turn. */
    private Die die = new Die();

    /** Whether console input ended before a player won. */
    private boolean inputEnded = false;

    /** The score a player must reach to win. */
    private int winningScore = 100;

    /** The first player. In a one-player game this is the only player. */
    private Player player1;

    /** The second player, or null in a one-player game. */
    private Player player2 = null;

    /** The player whose turn it is now. */
    private Player currentPlayer;

    /** The number of the turn being played. The first turn is turn 1. */
    private int turnNumber = 1;

    /** Points earned during this turn and not yet banked. */
    private int turnScore = 0;

    /** Whether this turn has ended. */
    private boolean turnOver = false;

    /**
     * Starts a one-player game. Turn 1 begins immediately with a turn score of 0.
     *
     * @param player the player
     */
    public Game(Player player) {
        player1 = player;
        currentPlayer = player;
    }

    /**
     * Starts a two-player game. Turn 1 belongs to the first player.
     *
     * @param player1 the player who takes the first turn
     * @param player2 the other player
     */
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    // ------------------------------------------------------------------
    // Group 2 · Turn scoring
    // ------------------------------------------------------------------

    /**
     * Returns the points earned during this turn and not yet banked.
     *
     * @return the turn score
     */
    public int getTurnScore() {
        // TODO (Group 2 · Turn scoring): return the turn score.
        return 0; // placeholder so the file compiles
    }

    /**
     * Reports whether this turn has ended. A turn ends when it is banked or
     * when its points are lost.
     *
     * @return true if this turn is over, false while it is still being played
     */
    public boolean isTurnOver() {
        // TODO (Group 2 · Turn scoring): return whether the turn is over.
        return false; // placeholder so the file compiles
    }

    /**
     * Adds points to the turn score. Nothing is added once the turn is over.
     *
     * @param points the points to add to the turn score
     */
    public void addToTurnScore(int points) {
        // TODO (Group 2 · Turn scoring): if the turn is not over, add points
        // to the turn score.
    }

    /**
     * Loses the points earned during this turn and ends the turn. The current
     * player's overall score does not change.
     * Postcondition: getTurnScore() returns 0 and isTurnOver() returns true.
     */
    public void loseTurnScore() {
        // TODO (Group 2 · Turn scoring): clear the turn score and end the turn.
    }

    /**
     * Banks this turn: adds the turn score to the current player's overall
     * score and ends the turn. A turn can only be banked once, so calling this
     * method again before the next turn does nothing.
     * Postcondition: getTurnScore() returns 0 and isTurnOver() returns true.
     */
    public void bank() {
        // TODO (Group 2 · Turn scoring): if the turn is not over, give the
        // turn score to the current player, clear it, and end the turn.
    }

    // ------------------------------------------------------------------
    // Group 3 · Turns & game end
    // ------------------------------------------------------------------

    /**
     * Returns the player whose turn it is.
     *
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Returns the number of the turn being played. The first turn is turn 1.
     *
     * @return the current turn number
     */
    public int getTurnNumber() {
        return turnNumber;
    }

    /**
     * Returns the score a player must reach to win.
     *
     * @return the winning score, which is 100
     */
    public int getWinningScore() {
        return winningScore;
    }

    /**
     * Reports whether play has ended, either with a winner or because input ended.
     *
     * @return true if a player won or console input ended
     */
    public boolean isOver() {
        if (inputEnded) {
            return true;
        }
        if (player1.getScore() >= winningScore) {
            return true;
        }
        if (player2 != null && player2.getScore() >= winningScore) {
            return true;
        }
        return false;
    }

    /**
     * Starts the next turn: the other player takes over in a two-player game,
     * the turn number goes up by one, and the turn score starts at 0. Any points
     * still in the turn score are lost. Once the game is over this method does
     * nothing, so the turn number and the current player stay as they were when
     * the game was won.
     */
    public void nextTurn() {
        if (!isOver()) {
            if (player2 != null) {
                if (currentPlayer == player1) {
                    currentPlayer = player2;
                } else {
                    currentPlayer = player1;
                }
            }
            turnNumber = turnNumber + 1;
            turnScore = 0;
            turnOver = false;
        }
    }

    // ------------------------------------------------------------------
    // Group 4 · Results & display
    // ------------------------------------------------------------------

    /**
     * Returns the player who reached the winning score.
     *
     * @return the winner, or null if no player has reached the winning score yet
     */
    public Player getWinner() {
        if (player1.getScore() >= winningScore) {
            return player1;
        }
        if (player2 != null && player2.getScore() >= winningScore) {
            return player2;
        }
        return null;
    }

    /** Displays the welcome message. */
    public void welcome() {
        System.out.println("Welcome to PIG!");
    }

    /** Displays the rules and the winning score. */
    public void rules() {
        System.out.println("Roll to build a turn score. Bank to keep it.");
        System.out.println("Rolling 1 loses this turn's points and ends the turn.");
        System.out.println("First to bank " + winningScore + " points wins.");
    }

    /**
     * Displays the winner and the number of turns, or explains that the game
     * is unfinished, then shows the banked scores.
     */
    public void displayResult() {
        System.out.println();
        Player winner = getWinner();
        if (winner != null) {
            System.out.println(winner.getName() + " wins in " + turnNumber + " turns!");
        } else if (inputEnded) {
            System.out.println("Input ended. Game unfinished.");
        } else {
            System.out.println("Game unfinished.");
        }
        displayScores();
    }

    /** Displays each player's name and banked score on one line. */
    private void displayScores() {
        System.out.print(player1.getName() + ": " + player1.getScore());
        if (player2 != null) {
            System.out.print("   " + player2.getName() + ": " + player2.getScore());
        }
        System.out.println();
    }

    // ------------------------------------------------------------------
    // Supplied. Do not edit.
    // ------------------------------------------------------------------

    /**
     * Plays one complete turn, then prepares the next player's turn.
     * Gets choices from the current player and applies rolling and banking rules.
     * Does nothing once the game is over. If input ends, isOver() becomes true
     * without declaring a winner.
     */
    public void playTurn() {
        if (isOver()) {
            return;
        }
        if (turnOver) {
            nextTurn();
        }
        System.out.println();
        System.out.println("Turn " + turnNumber + ": "
                + currentPlayer.getName() + " to play.");
        displayScores();

        while (!turnOver) {
            System.out.println("Turn score: " + turnScore);
            int choice = currentPlayer.getChoice();
            if (choice == 0) {
                inputEnded = true;
                turnOver = true;
                return;
            }
            if (choice == 1) {
                int roll = die.roll();
                System.out.println("You rolled a " + roll + ".");
                if (roll == 1) {
                    loseTurnScore();
                    System.out.println("Turn lost. Banked points stay safe.");
                } else {
                    addToTurnScore(roll);
                }
            } else if (choice == 2) {
                bank();
                System.out.println("Banked. " + currentPlayer.getName()
                        + " overall score: " + currentPlayer.getScore());
            }
        }
        nextTurn();
    }
}
