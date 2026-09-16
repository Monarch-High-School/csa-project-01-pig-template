# Group 3 · Turns & game end

Branch `group/turns`. File `Game.java`, section marked **Group 3**. Check: `java GroupChecks turns`.

| Method | Contract (from CLASSES.md) | What it needs |
|---|---|---|
| `getCurrentPlayer()` | Returns the player whose turn it is. | Return the field. |
| `getTurnNumber()` | Returns the number of the turn being played. The first turn is turn 1. | Return the field. |
| `getWinningScore()` | Returns the score needed to win, which is 100. | Return the field, not the literal. |
| `isOver()` | Returns true once a player has reached the winning score or input has ended. | Three conditions: `inputEnded`; `player1.getScore() >= winningScore`; and, only if `player2` is not `null`, the same for `player2`. |
| `nextTurn()` | The other player takes over in a two-player game, the turn number goes up by one, and the turn score starts at 0. Once the game is over this does nothing. | `if (!isOver())` around everything. Inside: if there is a `player2`, set `currentPlayer` to whichever player it is not (compare references with `==`); then update `turnNumber`, `turnScore`, `turnOver`. |

The fields you read and write: `currentPlayer`, `player1`, `player2`,
`turnNumber`, `turnScore`, `turnOver`, `inputEnded`, `winningScore`.

Before you run the check, trace on paper: two players, `nextTurn()` twice.
Who is current and what is the turn number after each call? What happens to
`nextTurn()` in a one-player game?
