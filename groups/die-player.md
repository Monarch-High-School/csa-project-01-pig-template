# Group 1 · Die & Player

Branch `group/die-player`. Files `Die.java` and `Player.java`. Check: `java GroupChecks dieplayer`.

| Method | Contract (from CLASSES.md) | What it needs |
|---|---|---|
| `Die.roll()` | Rolls the die and returns the new number, from 1 through 6. `getValue()` afterwards reports the same number. | `Math.random()` gives a `double` in [0, 1). Scale it, cast to `int`, shift the range. Store it in `value` before returning it. |
| `Die.getValue()` | Returns the number showing now, without rolling. 0 before the first roll. | Return the field. |
| `Player.getName()` | Returns this player's name. | Return the field. |
| `Player.getScore()` | Returns this player's overall (banked) score. | Return the field. |
| `Player.addToScore(int points)` | Adds points to the overall score. `Game.bank()` calls this. | Increase `score` by `points`. Nothing is returned. |

Your part is the smallest and the other three groups' checks use your `Player`
methods, so aim to open your pull request first.

Before you run the check, predict: what does `new Die().getValue()` print?
What does a player's score show after `addToScore(5)`, `addToScore(2)`,
`addToScore(0)`?
