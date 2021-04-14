# Yacht
Yacht is a public domain dice game that has inspired many other similar dice games like Yahtzee and Generala.  The game gets its name from being invented by a Canadian couple on a yacht.

**Important:  This program runs on [Java 8](https://www.oracle.com/java/technologies/javase-jre8-downloads.html).  If you do not have the correct JRE, this program may not run on your computer.**

## Gameplay
Objective:  Score as high as you can!

The rules are similar to Yahtzee.  There are twelve possible slots to fill in (and as such, there are twelve rounds per game).  Each round consists of up to three rolls, and after three rolls, the player must fill a slot in, even if it means that a zero will be inputted.  The player can end their turn early by filling in a slot if they are satisfied with their combination.

There are twelve slots:
* Aces:  Score 1 point per One rolled.
* Twos:  Score 2 points per Two rolled.
* Threes:  Score 3 points per Three rolled.
* Fours:  Score 4 points per Four rolled.
* Fives:  Score 5 points per Five rolled.
* Sixes:  Score 6 points per Six rolled.
* Four of a Kind:  Score (4 * *n*) where *n* is the number where there is four instances of (e.g. 5-5-5-5-3 scores 20).
* Full House:  Score sum of dice if there are three of one number and two of another number (e.g. 4-4-4-3-3 is valid, scoring 18).
* Low Straight:  Score 30 for getting 1-2-3-4-5 in any order (anything else scores 0).
* High Straight:  Score 30 for getting 2-3-4-5-6 in any order (anything else scores 0).
* Yahtzee:  Score 50 for getting five of a kind (anything else scores 0).
* Chance:  The wild card.  Score the sum of dice.  Mainly used to avoid a 0 if the hand does not fit another category.

To roll, click the lime-green button on the centre of the screen.  To hold a die for the next roll, click on it.  You can click again to un-hold the die.  Held dice will have an extra outline and will not change on the next roll (unless the round has ended, in which case all dice are automatically unheld).  To input a score, click on the appropriate box.
