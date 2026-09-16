# Pig with Objects — shared build

Yesterday you read the class library and wrote `main`. Today `main` is done and
the class bodies are missing. Four groups each fill in one part, on a branch of
this repository, and pull requests bring the parts together on the `oop` branch.

## Who owns what

| Group | Branch | Files | Methods | Page |
|---|---|---|---|---|
| 1 · Die & Player | `group/die-player` | `Die.java`, `Player.java` | `roll`, `getValue`, `getName`, `getScore`, `addToScore` | [groups/die-player.md](groups/die-player.md) |
| 2 · Turn scoring | `group/scoring` | `Game.java` | `getTurnScore`, `isTurnOver`, `addToTurnScore`, `loseTurnScore`, `bank` | [groups/scoring.md](groups/scoring.md) |
| 3 · Turns & game end | `group/turns` | `Game.java` | `getCurrentPlayer`, `getTurnNumber`, `getWinningScore`, `isOver`, `nextTurn` | [groups/turns.md](groups/turns.md) |
| 4 · Results & display | `group/display` | `Game.java` | `getWinner`, `welcome`, `rules`, `displayResult`, `displayScores` | [groups/display.md](groups/display.md) |

Edit only the bodies marked `TODO` for your group. Fields, constructors,
signatures, `Player.getChoice()`, `Game.playTurn()` and `Pig.main` are supplied.
The contract for every method is in [CLASSES.md](CLASSES.md) and in the comment
above the method.

## 1 · Get your branch

Open a Codespace on this repository (Code → Codespaces → Create), or clone it:

```text
git clone https://github.com/Monarch-High-School/csa-project-01-pig-template.git
cd csa-project-01-pig-template
```

Then switch to your group's branch. Your prompt should show the branch name.

```text
git switch group/scoring
git branch
```

## 2 · Implement and check

```text
javac *.java
java GroupChecks scoring
```

`PASS` means every contract in your part holds. `NOT YET` names the first
contract that does not hold yet. A line starting with `(waiting on Group 1 …)`
is not your bug: that part of the check needs Group 1's Player methods, which
arrive when their pull request is merged.

The whole game runs with `java Pig` once all four parts are on `oop`.

## 3 · Commit and push

Stage only your group's file(s). Say what behavior you implemented.

```text
git add Game.java
git commit -m "Implement turn scoring: addToTurnScore, loseTurnScore, bank"
git push
```

If `git push` is rejected because the branch has moved, a teammate pushed first:

```text
git pull
git push
```

## 4 · Open a pull request

On GitHub: **Pull requests → New pull request**. Set **base: `oop`** and
**compare: `group/scoring`** (your branch). Title it with your group name.
In the description, answer the three lines of the checklist:

1. Which methods did you implement?
2. Which contract did your check verify? Quote one pre/postcondition.
3. Which line are you least sure about, and why?

A member of a different group reads your diff and leaves one comment before
the teacher merges. Do not merge your own pull request.

## 5 · After the merges

Once `oop` has all four parts:

```text
git switch oop
git pull
javac *.java
java GroupChecks all
java Pig
```

## Rescue box

| Problem | Do this |
|---|---|
| You edited on the wrong branch | `git stash`, `git switch group/<yours>`, `git stash pop` |
| Compile error in a file you did not touch | `git restore <file>` (throws away your changes to that file only) |
| `git push` rejected | `git pull`, resolve, `git push` |
| Merge conflict markers `<<<<<<<` in `Game.java` | Keep both groups' method bodies; delete the marker lines; recompile |
| Everything is confused | `git status` first, then ask; do not delete the folder |

Never push to `main` or `oop` directly, and never use `--force`.
