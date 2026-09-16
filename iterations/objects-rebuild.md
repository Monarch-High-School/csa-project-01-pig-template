# Objects rebuild

## Structure

- `main` reads the player name before constructing the player.
- `Player` stores the name and banked score. `getChoice()` collects and returns a validated roll/bank choice.
- `Die` generates rolls from 1 through 6.
- `Game` tracks turns, applies scoring rules, and reports the result.
- One `Scanner` is shared between name entry and player choices.

[CLASSES.md](../CLASSES.md) documents the API. The single-player entry point
uses `new Game(player)` and calls `playTurn()` until `isOver()`, then
`displayResult()`. `playTurn()` handles turn advancement.

## Acceptance checks

- Scores start at 0 and the turn number starts at 1.
- Rolling 1 discards only the turn score.
- Banking credits the player once and clears the turn score.
- New turns start at 0.
- A banked score of at least 100 wins.
- The result includes the final score and turn count.
- End of input stops play without declaring a winner.

## Version

Entry point: `Pig.java`.

Completion commit: `finish: rebuild Pig with objects`.
