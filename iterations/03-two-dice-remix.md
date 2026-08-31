# Iteration 3: Two-dice remix (optional stretch goal)

## Goal

Remix your completed two-player game so that every roll uses two six-sided dice.
Design new outcomes for special rolls or combinations, document the rules, and
then implement and playtest your version.

## Design before coding

Complete [TWO-DICE-RULES.md](../TWO-DICE-RULES.md) before changing `Pig.java`.
Your rules must explain what happens for every possible roll so that a player
never has to guess how the game works.

You decide the rules. Possible triggers include:

- Rolling doubles
- Rolling a particular total
- Rolling two odd or two even numbers
- Rolling consecutive numbers
- Rolling one 1 or two 1s

Possible effects include adding or multiplying points, losing the turn score,
banking automatically, earning a bonus, or getting another decision. These are
possibilities, not assigned rules.

## Requirements

Your remixed program must:

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

## Test before finishing

- Verify that both dice always produce values from 1 through 6.
- Intentionally play until each special rule occurs at least once.
- Confirm that every possible roll has an outcome.
- Confirm that scores and turns change exactly as the written rules say.
- Play at least two complete games and record useful observations in
  `TWO-DICE-RULES.md`.
- Revise any rule that is confusing, unfair, or makes the game stop being fun.

## Iteration 3 is complete when

The written rules are complete, the program matches them, and the playtest notes
describe at least one design decision or revision.
