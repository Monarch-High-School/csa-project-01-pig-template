# Two-dice remix (optional)

Two six-sided dice, custom combination rules, and alternating players.
Rules are specified in [TWO-DICE-RULES.md](../TWO-DICE-RULES.md).

A custom turn loop uses two `Die` objects and the state methods in
[CLASSES.md](../CLASSES.md). `Game.playTurn()` implements standard one-die Pig.

## Requirements

1. Begin from a working version of Iteration 2.
2. Generate and display two random integers from 1 through 6 whenever the active
   player chooses to roll.
3. Include a clear ordinary-scoring rule and at least three distinct special
   outcomes based on rolls or combinations of rolls.
4. Apply the same rules to both players.
5. Keep the choice to roll or bank meaningful.
6. Preserve separate overall scores, alternating turns, and a clear win
   condition.
7. Display enough information for players to understand which rule was applied.
8. Match the written rules in `TWO-DICE-RULES.md`.

## Acceptance checks

- Both dice produce values from 1 through 6.
- Every possible roll has an outcome, with explicit priority for overlapping rules.
- Scores and turns follow the written rules.
- Each special outcome is exercised.
- Two complete games and resulting design decisions are recorded in `TWO-DICE-RULES.md`.
