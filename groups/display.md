# Group 4 · Results & display

Branch `group/display`. File `Game.java`, section marked **Group 4**. Check: `java GroupChecks display`.

| Method | Contract (from CLASSES.md) | What it needs |
|---|---|---|
| `getWinner()` | Returns the player who reached the winning score, or `null` if nobody has. | Compare `player1.getScore()` with `winningScore`; then, only if `player2` is not `null`, `player2`; otherwise return `null`. |
| `welcome()` | Displays the welcome message. | One `println`. |
| `rules()` | Displays the rules and the winning score. | A few `println`s; build the last one with `winningScore`, not the number 100. |
| `displayScores()` | Shows each player's name and banked score on one line. | `print` player1's name and score; if there is a `player2`, `print` theirs too; then `println()`. |
| `displayResult()` | Displays the winner and the number of turns, or says the game is unfinished, then shows the banked scores. | Call `getWinner()` and keep the result in a `Player` variable. If it is not `null`, print `<name> wins in <turnNumber> turns!`; otherwise print that the game is unfinished. Then call `displayScores()`. |

The fields you read: `player1`, `player2`, `turnNumber`, `winningScore`.

Before you run the check, write down the exact line your `displayResult()`
prints when Bo has 103 points on turn 12, and the line when nobody has won.
