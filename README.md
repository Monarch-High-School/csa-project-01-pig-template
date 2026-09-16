# Game of Pig

A Java console dice game for one or two players.

## Run

Requires Java 17 or later.

```text
javac TwoPlayerPig.java
java TwoPlayerPig
```

Enter both player names, then choose `1` to roll or `2` to bank on each turn.

## Rules

- Rolling 2 through 6 adds the roll to the turn score.
- Rolling 1 ends the turn and discards its points.
- Banking adds the turn score to the player's banked score and ends the turn.
- The first player to bank at least 100 points wins.

## Shared build (Wednesday)

On the `oop` branch the class bodies are stubbed and four groups implement them
on `group/*` branches. Each group uses its page in [groups/](groups/).

## Files

- [TwoPlayerPig.java](TwoPlayerPig.java): runnable two-player game; collects names and creates the players and game.
- [Player.java](Player.java): player names, banked scores, and roll/bank input.
- [Game.java](Game.java): turns, dice rolls, scoring, and results.
- [Die.java](Die.java): six-sided die.
- [CLASSES.md](CLASSES.md): API reference.
- [Pig.java](Pig.java): project entry point for the iteration implementations.

## Versions

1. [Single-player](iterations/01-single-player.md)
2. [Objects rebuild](iterations/objects-rebuild.md)
3. [Two-player](iterations/02-two-player.md)
4. [Two-dice remix](iterations/03-two-dice-remix.md) (optional)

Iteration implementations use `Pig.java`. Commit history identifies completed versions.
