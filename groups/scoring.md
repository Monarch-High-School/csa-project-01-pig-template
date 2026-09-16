# Group 2 · Turn scoring

Branch `group/scoring`. File `Game.java`, section marked **Group 2**. Check: `java GroupChecks scoring`.

| Method | Contract (from CLASSES.md) | What it needs |
|---|---|---|
| `getTurnScore()` | Returns the points earned this turn and not yet banked. | Return the field. |
| `isTurnOver()` | Returns true once this turn has been banked or lost. | Return the field. |
| `addToTurnScore(int points)` | Adds points to the turn score. Adds nothing once the turn is over. | An `if` on `turnOver`, then arithmetic on `turnScore`. |
| `loseTurnScore()` | Sets the turn score to 0 and ends the turn. The overall score is untouched. | Two assignments. |
| `bank()` | Adds the turn score to the current player's overall score, resets the turn score to 0 and ends the turn. A turn can only be banked once. | An `if` on `turnOver`; then call a method on the `currentPlayer` object (which one?); then the two assignments from `loseTurnScore`. |

The fields you read and write: `turnScore`, `turnOver`, `currentPlayer`.

Before you run the check, trace on paper: turn score 0, `addToTurnScore(4)`,
`addToTurnScore(6)`, `bank()`, `bank()`, `addToTurnScore(8)`. What is the turn
score and the player's score after each call?
