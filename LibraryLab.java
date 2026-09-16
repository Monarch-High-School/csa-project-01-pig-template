public class LibraryLab {
    public static void main(String[] args) {
        System.out.println("A: die");
        Die die = new Die();
        System.out.println(die.getValue());
        int rolled = die.roll();
        System.out.println(rolled);
        System.out.println(die.getValue());

        System.out.println("B: players");

        System.out.println("C: game");
        Player scorer = new Player("Sam");
        Game game = new Game(scorer);
        showState("Start", game, scorer);

        showState("After adding 4", game, scorer);
        showState("After adding 6", game, scorer);
        showState("After banking", game, scorer);
        showState("After next turn", game, scorer);
        showState("After adding 3", game, scorer);
        showState("After losing the turn", game, scorer);

    }

    public static void showState(String label, Game game, Player player) {
        System.out.println(label + ": " + game.getTurnScore() + ", "
                + player.getScore() + ", " + game.isTurnOver());
    }
}
