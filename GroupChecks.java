import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Supplied check tool for the shared Pig build. Run it after compiling:
 *
 *   javac *.java
 *   java GroupChecks dieplayer      (or scoring, turns, display, all)
 *
 * Each group's check works on its own: it reads the private fields directly,
 * so it does not depend on another group's methods being finished.
 * You are not asked to read or edit this file.
 */
public class GroupChecks {

    private static void expect(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static Object get(Object o, String name) throws Exception {
        Field f = o.getClass().getDeclaredField(name);
        f.setAccessible(true);
        return f.get(o);
    }

    private static void set(Object o, String name, Object value) throws Exception {
        Field f = o.getClass().getDeclaredField(name);
        f.setAccessible(true);
        f.set(o, value);
    }

    private static int score(Player p) throws Exception {
        return (int) get(p, "score");
    }

    /** True once Group 1's Player.getScore() and addToScore() work. */
    private static boolean playerReady() throws Exception {
        Player probe = new Player("probe");
        probe.addToScore(3);
        return score(probe) == 3 && probe.getScore() == 3 && "probe".equals(probe.getName());
    }

    private static void waiting(String what) {
        System.out.println("  (waiting on Group 1: Player.getName/getScore/addToScore are not finished, so " + what + " is not checked yet)");
    }

    private static String capture(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString();
    }

    // ---------------------------------------------------------------- Group 1

    private static void dieplayer() throws Exception {
        Die d = new Die();
        expect(d.getValue() == 0, "A new die must report 0 before its first roll.");
        for (int i = 0; i < 1000; i++) {
            int rolled = d.roll();
            expect(rolled >= 1 && rolled <= 6, "roll() must return an integer from 1 to 6 (got " + rolled + ").");
            expect(d.getValue() == rolled, "getValue() must report the most recent roll.");
            expect(d.getValue() == rolled, "getValue() must not roll again.");
        }
        boolean sawSix = false, sawOne = false;
        for (int i = 0; i < 1000; i++) {
            int r = d.roll();
            if (r == 6) sawSix = true;
            if (r == 1) sawOne = true;
        }
        expect(sawOne && sawSix, "In 1000 rolls both 1 and 6 should appear. Check the range formula.");

        Player a = new Player("A"), b = new Player("B");
        expect("A".equals(a.getName()) && "B".equals(b.getName()), "getName() must return the name supplied to the constructor.");
        expect(a.getScore() == 0 && b.getScore() == 0, "New players must start at 0.");
        a.addToScore(5);
        a.addToScore(2);
        a.addToScore(0);
        expect(a.getScore() == 7, "addToScore(5), (2), (0) must leave the score at 7 (got " + a.getScore() + ").");
        expect(b.getScore() == 0, "Only the receiving player's score may change.");
    }

    // ---------------------------------------------------------------- Group 2

    private static void scoring() throws Exception {
        Player a = new Player("A"), b = new Player("B");
        Game g = new Game(a, b);
        expect(g.getTurnScore() == 0 && !g.isTurnOver(), "A new game starts with turn score 0 and the turn not over.");
        set(g, "turnScore", 9);
        set(g, "turnOver", true);
        expect(g.getTurnScore() == 9 && g.isTurnOver(), "getTurnScore() and isTurnOver() must read the actual fields.");
        set(g, "turnScore", 0);
        set(g, "turnOver", false);

        g.addToTurnScore(4);
        g.addToTurnScore(6);
        expect((int) get(g, "turnScore") == 10, "Two additions of 4 and 6 must give a turn score of 10.");
        g.bank();
        expect((int) get(g, "turnScore") == 0 && (boolean) get(g, "turnOver"), "bank() must clear the turn score and end the turn.");
        // bank() credits the player through Player.addToScore, which Group 1 writes.
        boolean addToScoreWorks = playerReady();
        if (addToScoreWorks) {
            expect(score(a) == 10, "bank() must give the turn score to the current player (A should have 10).");
            expect(score(b) == 0, "bank() must not change the other player.");
        } else {
            waiting("the bank credit");
        }
        g.bank();
        if (addToScoreWorks) {
            expect(score(a) == 10, "A second bank() before the next turn must change nothing.");
        }
        g.addToTurnScore(8);
        expect((int) get(g, "turnScore") == 0, "addToTurnScore() must add nothing once the turn is over.");

        set(g, "turnOver", false);
        set(g, "turnScore", 9);
        g.loseTurnScore();
        expect((int) get(g, "turnScore") == 0 && (boolean) get(g, "turnOver"), "loseTurnScore() must clear the points and end the turn.");
        if (addToScoreWorks) {
            expect(score(a) == 10 && score(b) == 0, "loseTurnScore() must leave banked scores alone.");
        }
    }

    // ---------------------------------------------------------------- Group 3

    private static void turns() throws Exception {
        Player a = new Player("A"), b = new Player("B");
        Game g = new Game(a, b);
        expect(g.getWinningScore() == 100, "getWinningScore() must return 100.");
        expect(g.getTurnNumber() == 1, "The first turn is turn 1.");
        expect(g.getCurrentPlayer() == a, "player1 takes the first turn.");
        expect(!g.isOver(), "A new game is not over.");

        set(g, "turnScore", 9);
        set(g, "turnOver", true);
        g.nextTurn();
        expect((Player) get(g, "currentPlayer") == b, "nextTurn() must switch to the other player.");
        expect((int) get(g, "turnNumber") == 2, "nextTurn() must add 1 to the turn number.");
        expect((int) get(g, "turnScore") == 0 && !(boolean) get(g, "turnOver"), "nextTurn() must reset the turn score to 0 and mark the turn not over.");
        g.nextTurn();
        expect((Player) get(g, "currentPlayer") == a && (int) get(g, "turnNumber") == 3, "Turns must alternate: turn 3 belongs to A.");

        if (playerReady()) {
            set(a, "score", 100);
            expect(g.isOver(), "100 banked points for player1 ends the game.");
            g.nextTurn();
            expect((int) get(g, "turnNumber") == 3 && (Player) get(g, "currentPlayer") == a, "nextTurn() must do nothing after the game is over.");

            Game h = new Game(new Player("C"), new Player("D"));
            set((Player) get(h, "player2"), "score", 99);
            expect(!h.isOver(), "99 points is not a win.");
            set((Player) get(h, "player2"), "score", 101);
            expect(h.isOver(), "player2 reaching the winning score also ends the game.");
        } else {
            waiting("winning by score");
        }

        Game k = new Game(new Player("E"), new Player("F"));
        set(k, "inputEnded", true);
        expect(k.isOver(), "The game is over when input has ended.");

        Game solo = new Game(new Player("Solo"));
        expect(!solo.isOver(), "A one-player game must not crash on the missing player2.");
        solo.nextTurn();
        expect((int) get(solo, "turnNumber") == 2 && (Player) get(solo, "currentPlayer") == (Player) get(solo, "player1"),
                "A one-player game keeps its only player and still advances the turn number.");
    }

    // ---------------------------------------------------------------- Group 4

    private static void display() throws Exception {
        Player a = new Player("Ada"), b = new Player("Bo");
        Game g = new Game(a, b);
        expect(g.getWinner() == null, "getWinner() must return null while nobody has won.");
        Game solo = new Game(new Player("Solo"));
        expect(solo.getWinner() == null, "getWinner() must not crash in a one-player game.");
        boolean ready = playerReady();
        set(a, "score", 40);
        set(b, "score", 103);
        if (ready) {
            set(a, "score", 100);
            expect(g.getWinner() == a, "getWinner() must return player1 when player1 has 100.");
            set(a, "score", 40);
            expect(g.getWinner() == b, "getWinner() must return player2 when player2 has reached the winning score.");
        } else {
            waiting("who getWinner() returns");
        }

        String welcome = capture(g::welcome);
        expect(!welcome.trim().isEmpty(), "welcome() must print something.");
        String rules = capture(g::rules);
        expect(rules.contains("100"), "rules() must mention the winning score (100).");

        Method displayScores = Game.class.getDeclaredMethod("displayScores");
        displayScores.setAccessible(true);
        String scores = capture(() -> {
            try { displayScores.invoke(g); } catch (Exception e) { throw new RuntimeException(e); }
        });
        if (ready) {
            expect(scores.contains("Ada") && scores.contains("40") && scores.contains("Bo") && scores.contains("103"),
                    "displayScores() must show both names and both banked scores.");
            set(g, "turnNumber", 12);
            String result = capture(g::displayResult);
            expect(result.contains("Bo") && result.contains("12"), "displayResult() must name the winner and the turn number.");
            expect(result.contains("Ada") && result.contains("40"), "displayResult() must also show the banked scores.");
        } else {
            expect(!scores.trim().isEmpty(), "displayScores() must print something.");
            waiting("the names, scores and winner in displayScores()/displayResult()");
        }

        Game unfinished = new Game(new Player("Cy"), new Player("Di"));
        String text = capture(unfinished::displayResult).toLowerCase();
        expect(text.contains("unfinished"), "With no winner, displayResult() must say the game is unfinished.");
        if (ready) {
            expect(text.contains("cy") && text.contains("di"), "An unfinished result still shows both players.");
        }
    }

    // ---------------------------------------------------------------- main

    public static void main(String[] args) {
        String group = args.length == 0 ? "all" : args[0].toLowerCase();
        String[] all = {"dieplayer", "scoring", "turns", "display"};
        String[] run = group.equals("all") ? all : new String[]{group};
        int failures = 0;
        for (String name : run) {
            try {
                switch (name) {
                    case "dieplayer": dieplayer(); break;
                    case "scoring": scoring(); break;
                    case "turns": turns(); break;
                    case "display": display(); break;
                    default:
                        System.out.println("Choose dieplayer, scoring, turns, display, or all.");
                        System.exit(2);
                }
                System.out.println("PASS: " + name);
            } catch (AssertionError e) {
                failures++;
                System.out.println("NOT YET: " + name + " -- " + e.getMessage());
            } catch (Exception | StackOverflowError e) {
                failures++;
                System.out.println("ERROR: " + name + " -- " + e);
            }
        }
        if (failures == 0 && group.equals("all")) {
            System.out.println("All four groups pass. Run: java Pig");
        }
        System.exit(failures == 0 ? 0 : 1);
    }
}
