package net.sky.yacht.objects;

import java.awt.*;
import java.util.ArrayList;

public class ScoreSheet extends GameObject {
    private int aces = -1;
    private int twos = -1;
    private int threes = -1;
    private int fours = -1;
    private int fives = -1;
    private int sixes = -1;
    private int fourOfAKind = -1;
    private int fullHouse = -1;
    private int lowStraight = -1;
    private int highStraight = -1;
    private int yacht = -1;
    private int chance = -1;
    private int upperScore = 0;
    private int lowerScore = 0;
    private int total = 0;
  
    public boolean clickable;

    public ScoreSheet(int x, int y) {
        super(x, y);
        this.clickable = false;
    }

    @Override
    public void tick() {

        int[] upperSection = new int[]{this.aces, this.twos, this.threes, this.fours, this.fives, this.sixes};
        int[] lowerSection = new int[]{this.fourOfAKind, this.fullHouse, this.lowStraight, this.highStraight, this.yacht, this.chance};

        int upperScore = 0;
        for(int score : upperSection) {
            if(score >= 0) {
                upperScore += score;
            }
        }
        this.upperScore = upperScore;

        int lowerScore = 0;
        for(int score : lowerSection) {
            if(score >= 0) {
                lowerScore += score;
            }
        }
        this.lowerScore = lowerScore;

        this.total = this.upperScore + this.lowerScore;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(this.x, this.y, 241, 187);
        g.fillRect(this.x + 300, this.y, 241, 187);
        g.fillRect(this.x + 202, this.y + 195, 141, 37);
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, 121, 25);
        g.drawRect(this.x + 121, this.y, 121, 25);
        g.drawRect(this.x, this.y + 25, 121, 25);
        g.drawRect(this.x + 121, this.y + 25, 121, 25);
        g.drawRect(this.x, this.y + 50, 121, 25);
        g.drawRect(this.x + 121, this.y + 50, 121, 25);
        g.drawRect(this.x, this.y + 75, 121, 25);
        g.drawRect(this.x + 121, this.y + 75, 121, 25);
        g.drawRect(this.x, this.y + 100, 121, 25);
        g.drawRect(this.x + 121, this.y + 100, 121, 25);
        g.drawRect(this.x, this.y + 125, 121, 25);
        g.drawRect(this.x + 121, this.y + 125, 121, 25);
        g.drawRect(this.x, this.y + 150, 121, 37);
        g.drawRect(this.x + 121, this.y + 150, 121, 37);
        g.drawRect(this.x + 300, this.y, 121, 25);
        g.drawRect(this.x + 421, this.y, 121, 25);
        g.drawRect(this.x + 300, this.y + 25, 121, 25);
        g.drawRect(this.x + 421, this.y + 25, 121, 25);
        g.drawRect(this.x + 300, this.y + 50, 121, 25);
        g.drawRect(this.x + 421, this.y + 50, 121, 25);
        g.drawRect(this.x + 300, this.y + 75, 121, 25);
        g.drawRect(this.x + 421, this.y + 75, 121, 25);
        g.drawRect(this.x + 300, this.y + 100, 121, 25);
        g.drawRect(this.x + 421, this.y + 100, 121, 25);
        g.drawRect(this.x + 300, this.y + 125, 121, 25);
        g.drawRect(this.x + 421, this.y + 125, 121, 25);
        g.drawRect(this.x + 300, this.y + 150, 121, 37);
        g.drawRect(this.x + 421, this.y + 150, 121, 37);
        g.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        g.drawString("Aces", this.x + 4, this.y + 20);
        g.drawString("Twos", this.x + 4, this.y + 45);
        g.drawString("Threes", this.x + 4, this.y + 70);
        g.drawString("Fours", this.x + 4, this.y + 95);
        g.drawString("Fives", this.x + 4, this.y + 120);
        g.drawString("Sixes", this.x + 4, this.y + 145);
        g.drawString("Upper Section", this.x + 4, this.y + 175);
        g.drawString("Four of a Kind", this.x + 304, this.y + 20);
        g.drawString("Full House", this.x + 304, this.y + 45);
        g.drawString("Low Straight", this.x + 304, this.y + 70);
        g.drawString("High Straight", this.x + 304, this.y + 95);
        g.drawString("Yacht", this.x + 304, this.y + 120);
        g.drawString("Chance", this.x + 304, this.y + 145);
        g.drawString("Lower Section", this.x + 304, this.y + 175);
        if(this.aces >= 0) g.drawString(String.valueOf(this.aces), this.x + 125, this.y + 20);
        if(this.twos >= 0) g.drawString(String.valueOf(this.twos), this.x + 125, this.y + 45);
        if(this.threes >= 0) g.drawString(String.valueOf(this.threes), this.x + 125, this.y + 70);
        if(this.fours >= 0) g.drawString(String.valueOf(this.fours), this.x + 125, this.y + 95);
        if(this.fives >= 0) g.drawString(String.valueOf(this.fives), this.x + 125, this.y + 120);
        if(this.sixes >= 0) g.drawString(String.valueOf(this.sixes), this.x + 125, this.y + 145);
        g.drawString(String.valueOf(this.upperScore), this.x + 125, this.y + 175);
        if(this.fourOfAKind >= 0) g.drawString(String.valueOf(this.fourOfAKind), this.x + 425, this.y + 20);
        if(this.fullHouse >= 0) g.drawString(String.valueOf(this.fullHouse), this.x + 425, this.y + 45);
        if(this.lowStraight >= 0) g.drawString(String.valueOf(this.lowStraight), this.x + 425, this.y + 70);
        if(this.highStraight >= 0) g.drawString(String.valueOf(this.highStraight), this.x + 425, this.y + 95);
        if(this.yacht >= 0) g.drawString(String.valueOf(this.yacht), this.x + 425, this.y + 120);
        if(this.chance >= 0) g.drawString(String.valueOf(this.chance), this.x + 425, this.y + 145);
        g.drawString(String.valueOf(this.lowerScore), this.x + 425, this.y + 175);
        g.drawRect(this.x + 202, this.y + 195, 141, 37);
        g.drawString("Total: ".concat(String.valueOf(this.total)), this.x + 210, this.y + 220);
    }

    @Override
    public void click(int x, int y) {
        if(!this.clickable) {
            return;
        }

        ArrayList<Integer> diceValues = new ArrayList<>();
        for(GameObject object : this.handler.getObjects()) {
            if(object instanceof Die) {
                diceValues.add(((Die) object).getValue());
            }
        }

        if((x >= this.x + 121) && (x < this.x + 242) && (y >= this.y) && (y < this.y + 25) && this.aces == -1) {
            this.aces = 0;
            for(int value : diceValues) {
                if(value == 1) {
                    this.aces += 1;
                }
            }
            this.revalidateDice();
        }

        if((x >= this.x + 121) && (x < this.x + 242) && (y >= this.y + 25) && (y < this.y + 50) && this.twos == -1) {
            this.twos = 0;
            for(int value : diceValues) {
                if(value == 2) {
                    this.twos += 2;
                }
            }
            this.revalidateDice();
        }

        if((x >= this.x + 121) && (x < this.x + 242) && (y >= this.y + 50) && (y < this.y + 75) && this.threes == -1) {
            this.threes = 0;
            for(int value : diceValues) {
                if(value == 3) {
                    this.threes += 3;
                }
            }
            this.revalidateDice();
        }

        if((x >= this.x + 121) && (x < this.x + 242) && (y >= this.y + 75) && (y < this.y + 100) && this.fours == -1) {
            this.fours = 0;
            for(int value : diceValues) {
                if(value == 4) {
                    this.fours += 4;
                }
            }
            this.revalidateDice();
        }

        if((x >= this.x + 121) && (x < this.x + 242) && (y >= this.y + 100) && (y < this.y + 125) && this.fives == -1) {
            this.fives = 0;
            for(int value : diceValues) {
                if(value == 5) {
                    this.fives += 5;
                }
            }
            this.revalidateDice();
        }

        if((x >= this.x + 121) && (x < this.x + 242) && (y >= this.y + 125) && (y < this.y + 150) && this.sixes == -1) {
            this.sixes = 0;
            for(int value : diceValues) {
                if(value == 6) {
                    this.sixes += 6;
                }
            }
            this.revalidateDice();
        }

        if((x >= this.x + 421) && (x < this.x + 542) && (y >= this.y) && (y < this.y + 25) && this.fourOfAKind == -1) {
            for(int t = 1; t <= 6; t++) {
                int instances = 0;
                for(int value : diceValues) {
                    if(value == t) {
                        instances++;
                    }
                }
                if(instances >= 4) {
                    this.fourOfAKind = 4 * t;
                    break;
                }
            }
            if(this.fourOfAKind == -1) {
                this.fourOfAKind = 0;
            }
            this.revalidateDice();
        }

        if((x >= this.x + 421) && (x < this.x + 542) && (y >= this.y + 25) && (y < this.y + 50) && this.fullHouse == -1) {
            int triple = 0;
            int dub = 0;

            for(int t = 1; t <= 6; t++) {
                int instances = 0;
                for(int value : diceValues) {
                    if (value == t) {
                        instances++;
                    }
                }
                if(instances == 3) {
                    triple = t;
                    break;
                }
            }

            if(triple != 0) {
                for(int t = 1; t <= 6; t++) {
                    if(t != triple) {
                        int instances = 0;
                        for(int value : diceValues) {
                            if(value == t) {
                                instances++;
                            }
                        }
                        if(instances == 2) {
                            dub = t;
                            break;
                        }
                    }
                }
            }

            this.fullHouse = ((triple != 0) && (dub != 0)) ? ((triple * 3) + (dub * 2)) : 0;
            this.revalidateDice();
        }

        if((x >= this.x + 421) && (x < this.x + 542) && (y >= this.y + 50) && (y < this.y + 75) && this.lowStraight == -1) {
            this.lowStraight = (diceValues.contains(1) && diceValues.contains(2) && diceValues.contains(3) && diceValues.contains(4) && diceValues.contains(5)) ? 30 : 0;
            this.revalidateDice();
        }

        if((x >= this.x + 421) && (x < this.x + 542) && (y >= this.y + 75) && (y < this.y + 100) && this.highStraight == -1) {
            this.highStraight = (diceValues.contains(2) && diceValues.contains(3) && diceValues.contains(4) && diceValues.contains(5) && diceValues.contains(6)) ? 30 : 0;
            this.revalidateDice();
        }

        if((x >= this.x + 421) && (x < this.x + 542) && (y >= this.y + 100) && (y < this.y + 125) && this.yacht == -1) {
            for(int t = 1; t <= 6; t++) {
                int instances = 0;
                for(int value : diceValues) {
                    if(value == t) {
                        instances++;
                    }
                }
                if(instances == 5) {
                    this.yacht = 50;
                    break;
                }
            }
            if(this.yacht == -1) {
                this.yacht = 0;
            }
            this.revalidateDice();
        }

        if((x >= this.x + 421) && (x < this.x + 542) && (y >= this.y + 125) && (y < this.y + 150) && this.chance == -1) {
            this.chance = 0;
            for(int value : diceValues) {
                this.chance += value;
            }
            this.revalidateDice();
        }
    }

    private void revalidateDice() {
        for(GameObject object : this.handler.getObjects()) {
            if(object instanceof RollButton) {
                ((RollButton) object).reset();
            }
        }
        this.clickable = false;
    }

    public void reset() {
        this.aces = -1;
        this.twos = -1;
        this.threes = -1;
        this.fours = -1;
        this.fives = -1;
        this.sixes = -1;
        this.fourOfAKind = -1;
        this.fullHouse = -1;
        this.lowStraight = -1;
        this.highStraight = -1;
        this.yacht = -1;
        this.chance = -1;
    }
}
