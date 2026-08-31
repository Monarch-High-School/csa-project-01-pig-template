# Iteration 2: Two-player game

## Goal

Extend your working single-player game into the complete two-player Game of
Pig. Both players use the same turn rules, keep separate overall scores, and
alternate turns until one player wins.

## Build from Iteration 1

Continue editing the same `Pig.java` file. Reuse the rolling, turn-score, and
banking logic that already works. Do not create `Pig2.java` or start over in a
new repository.

## Requirements

Your program must:

1. Ask for and store a name for each of the two players.
2. Start each player's overall score at 0.
3. Clearly display whose turn it is and both players' overall scores.
4. Give the active player the same choices and turn rules used in Iteration 1.
5. Keep the two players' overall scores separate.
6. End the active player's turn after banking or rolling a 1.
7. Switch to the other player after each completed turn.
8. Check for a winner after points are banked.
9. End the game as soon as a player's overall score reaches 100 or more.
10. Announce the winner and display both final scores.

## Test before submitting

Play enough games to confirm that:

- Player 1 and Player 2 alternate correctly.
- Rolling 1 changes only the active player's turn score.
- Banking changes only the active player's overall score.
- Scores remain correct after many changes of turn.
- A player who reaches 100 by banking wins immediately.
- The program announces the correct player and final scores.

## Iteration 2 is complete when

The program meets every requirement above and passes each test in the checklist.
