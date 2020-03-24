package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {
    private int playerID;
    private int player0Score;
    private int player1Score;
    private int player0RunningTotal;
    private int player1RunningTotal;
    private int diceVal;

    public int getPlayerID() { return playerID;}
    public int getPlayer0Score() {return player0Score;}
    public int getPlayer1Score() {return player1Score;}
    public int getPlayer0RunningTotal(){return player0RunningTotal;}
    public int getPlayer1RunningTotal() {return player1RunningTotal;}
    public int getDiceVal(){return diceVal;}

    public void setPlayerID(int x) {playerID=x;}
    public void setPlayer0Score(int x) {player0Score = x;}
    public void setPlayer1Score(int x) {player1Score = x;}
    public void setPlayer0RunningTotal(int x){player0RunningTotal = x;}
    public void setPlayer1RunningTotal(int x) {player1RunningTotal = x;}
    public void setDiceVal(int x){diceVal = x;}

    public PigGameState() {
        player0Score = 0;
        player1Score = 0;
        player0RunningTotal = 0;
        player1RunningTotal = 0;
        diceVal = 1;
    }

    public PigGameState(PigGameState orig) {
        player0Score = orig.player0Score;
        player1Score = orig.player1Score;
        player0RunningTotal = orig.player0RunningTotal;
        player1RunningTotal = orig.player1RunningTotal;
        diceVal = orig.diceVal;
    }


}

