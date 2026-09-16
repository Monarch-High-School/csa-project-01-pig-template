import java.util.Scanner;

/** A two-player console game of Pig. */
public class TwoPlayerPig {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Player 1 name: ");
        if (!input.hasNextLine()) {
            return;
        }
        String name1 = input.nextLine().trim();
        System.out.print("Player 2 name: ");
        if (!input.hasNextLine()) {
            return;
        }
        String name2 = input.nextLine().trim();

        Player player1 = new Player(name1, input);
        Player player2 = new Player(name2, input);
        Game game = new Game(player1, player2);

        game.welcome();
        game.rules();

        while (!game.isOver()) {
            game.playTurn();
        }

        game.displayResult();
    }
}
