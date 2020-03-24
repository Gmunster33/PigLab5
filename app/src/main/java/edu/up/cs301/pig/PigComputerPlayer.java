package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    PigGameState savedState;

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
    if(info instanceof PigGameState) {
     savedState = (PigGameState)info; //consider making this a local variable.
    }
    else
        return;

    if(savedState.getPlayerID() != playerNum) {
        return;
    }

    Random ran = new Random();
    if (ran.nextBoolean()) {
        game.sendAction(new PigHoldAction(this));
    }
    else {
        game.sendAction(new PigRollAction(this));
    }
    return;
    }//receiveInfo

}
