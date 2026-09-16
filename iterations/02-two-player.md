# Iteration 2: Two-player game

## Behavior

Two players keep separate banked scores and alternate turns until one wins.

## Requirements

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

## Acceptance checks

- Player 1 and Player 2 alternate correctly.
- Rolling 1 changes only the active player's turn score.
- Banking changes only the active player's overall score.
- Scores remain correct after many changes of turn.
- A player who reaches 100 by banking wins immediately.
- The program announces the correct player and final scores.

## Version

Entry point: `Pig.java`.

Completion commit: `finish: complete Pig iteration 2`.
