package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState pigGame;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        pigGame = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if (playerIdx == pigGame.getPlayerID()) {
            return true;
        }
        else
            return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
         if (action instanceof PigHoldAction) {
             if (pigGame.getPlayerID() == 0) {
                 pigGame.setPlayer0Score(pigGame.getPlayer0Score() + pigGame.getPlayerRunningTotal());
                 return true;
             }
             else if (pigGame.getPlayerID() == 1) {
                 pigGame.setPlayer1Score(pigGame.getPlayer1Score() + pigGame.getPlayerRunningTotal());
                 return true;
             }
             else
                 return false; //illegal PlayerID
         }
         else if (action instanceof PigRollAction) {
             Random ran = new Random();
             pigGame.setDiceVal(ran.nextInt(6) + 1);
             if (pigGame.getDiceVal() == 1) {
                 pigGame.setPlayerRunningTotal(0); //bad luck...
                 return true; //TODO set turn
             }
             else if (pigGame.getDiceVal() <= 6) {
                 pigGame.setPlayerRunningTotal(pigGame.getPlayerRunningTotal() + pigGame.getDiceVal());
                 return true;
             }
         }
         return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        ///new PigGameState(pigGame);
        p.sendInfo(pigGame);
    }//sendUpdatedSate //TODO send a copy of the pigGame

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(pigGame.getPlayer0Score() >= 50){
            return "Player 0 has won! Their score is: " + pigGame.getPlayer0Score();
        }
        else if (pigGame.getPlayer1Score() >= 50) {
            return "Player 1 has won! Their score is: " + pigGame.getPlayer1Score();
        }
        return null;
    }

}// class PigLocalGame
