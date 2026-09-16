# Pig API

`Die` holds a die value. `Player` holds a name and banked score and collects
roll/bank choices. `Game` manages turns, rolls, scoring, and results.

[TwoPlayerPig.java](TwoPlayerPig.java) collects both names before constructing
the players, shares one `Scanner` between them, and runs the game.

## Die

One six-sided die. A new die has not been rolled yet.

| Constructor | Description |
|---|---|
| `Die()` | Makes a new die. It shows 0 until it is rolled. |

| Returns | Method | Description |
|---|---|---|
| `int` | `roll()` | Rolls the die and returns the new number, from 1 through 6. |
| `int` | `getValue()` | Returns the number showing now, without rolling. 0 before the first roll. |

```java
Die die = new Die();
int roll = die.roll();
System.out.println("You rolled a " + roll + ".");
```

`getValue()` does not roll. Calling it twice gives the same number twice.

## Player

One player. A player knows a name and an overall score. The overall score holds
banked points only, so it never goes down when a turn is lost.

| Constructor | Description |
|---|---|
| `Player(String name)` | Creates a player with score 0 using a shared console reader. |
| `Player(String name, Scanner input)` | Creates a player with score 0 using the supplied reader. Share the reader used to collect names. |

| Returns | Method | Description |
|---|---|---|
| `int` | `getChoice()` | Prompts and validates input; returns 1 for roll, 2 for bank, or 0 when input ends. |
| `String` | `getName()` | Returns this player's name. |
| `int` | `getScore()` | Returns this player's overall score. |
| `void` | `addToScore(int points)` | Adds points to the overall score. `Game.bank()` calls this method. |

```java
Player player = new Player("Player 1");
System.out.println(player.getName() + " has " + player.getScore() + " points.");
```

## Game

One game in progress. A `Game` keeps the turn score, whose turn it is, the turn
number, and the score needed to win.

| Constructor | Description |
|---|---|
| `Game(Player player)` | Starts a one-player game. Turn 1 begins right away. |
| `Game(Player player1, Player player2)` | Starts a two-player game. `player1` takes turn 1. |

| Returns | Method | Description |
|---|---|---|
| `void` | `welcome()` | Displays the welcome message. |
| `void` | `rules()` | Displays the rules and winning score. |
| `void` | `playTurn()` | Runs one complete turn, getting choices from the current player and rolling the die, then advances to the next player. Does nothing after the game ends. |
| `void` | `displayResult()` | Displays the winner and banked scores, or says the game is unfinished. |
| `Player` | `getCurrentPlayer()` | Returns the player whose turn it is. |
| `int` | `getTurnNumber()` | Returns the number of the turn being played. The first turn is turn 1. |
| `int` | `getTurnScore()` | Returns the points earned this turn and not yet banked. |
| `int` | `getWinningScore()` | Returns the score needed to win, which is 100. |
| `boolean` | `isTurnOver()` | Returns true once this turn has been banked or lost. |
| `boolean` | `isOver()` | Returns true once a player has reached the winning score or input has ended. |
| `Player` | `getWinner()` | Returns the player who reached the winning score, or `null` if nobody has. |
| `void` | `addToTurnScore(int points)` | Adds points to the turn score. Adds nothing once the turn is over. |
| `void` | `loseTurnScore()` | Sets the turn score to 0 and ends the turn. The overall score is untouched. |
| `void` | `bank()` | Adds the turn score to the current player's overall score, resets the turn score to 0 and ends the turn. A turn can only be banked once. |
| `void` | `nextTurn()` | Starts the next turn: the other player takes over in a two-player game, the turn number goes up by one, and the turn score starts at 0. Once the game is over this does nothing. |

```java
Player player = new Player("Player 1");
Game game = new Game(player);

game.addToTurnScore(5);                 // the player rolled a 5
System.out.println(game.getTurnScore()); // 5
game.bank();                            // 5 points move to the player
System.out.println(player.getScore());   // 5
System.out.println(game.isTurnOver());   // true
game.nextTurn();                        // turn 2 begins at 0
```

## Input and turn lifecycle

`Player.getChoice()` retries invalid input and leaves the reader open.
If input ends, `Game.playTurn()` stops the game without declaring a winner;
`displayResult()` reports that the game is unfinished.

`playTurn()` advances to the next player automatically. `nextTurn()` is
available for callers that manage turns directly. `bank()` credits the current
player once, clears the turn score, and ends the turn.
