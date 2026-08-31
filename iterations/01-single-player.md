# Iteration 1: Single-player game

## Goal

Build the complete turn and scoring logic by letting one player play until
their overall score reaches 100 points.

## Requirements

Your program must:

1. Start the overall score at 0 and the turn number at 1.
2. Display the turn number and overall score at the beginning of each turn.
3. Start each turn with a turn score of 0.
4. Ask the player to choose `roll` or `bank` while the turn is active.
5. Generate and display a random integer from 1 through 6 when the player rolls.
6. Add rolls from 2 through 6 to the turn score.
7. End the turn and discard its points when the player rolls a 1.
8. Add the turn score to the overall score and end the turn when the player
   banks.
9. Continue taking turns until the overall score is at least 100.
10. Display a winning message and the number of turns used.

Use `Scanner`, variables, `Math.random()`, Boolean expressions, `if` statements,
and `while` loops.

## Test before submitting

Play enough games to confirm that:

- Every die result is between 1 and 6.
- A roll of 1 loses only the current turn's points.
- Banking adds the current turn score exactly once.
- The turn score resets after rolling 1 or banking.
- The game does not end before the overall score reaches 100.
- The program reports the correct number of turns.

## Iteration 1 is complete when

The program meets every requirement above and passes each test in the checklist.
