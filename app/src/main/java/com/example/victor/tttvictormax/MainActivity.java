package com.example.victor.tttvictormax;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
//import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*In this special version of Tic-Tac-Toe, the X's are represented by a picture
    * of LeBron James and the O's are represented by a picture of Stephen Curry.
    * When the user faces the droid, the user has to get 3 LeBrons in a row before
    * the droid gets 3 Currys in a row, either horizontally, vertically, or diagonally.
     */

    /*This will keep track of turns.*/
    private int turnNumber = 1;

    /*Initial assumption is that the human is facing the droid. The human controls LeBron
     * James while the droid controls Steph Curry.
     */
    private boolean vsDroid = true;
    private boolean vsHuman = false;

    /*These booleans are to see who won each game.*/
    private boolean droidWins = false;
    private boolean humanWins = false;
    private boolean player2Wins = false;

    /*Counters*/
    private int humanWinCounter = 0;
    private int droidWinCounter = 0;
    private int player2WinCounter = 0;
    private int tieCounter = 0;

    //TODO Check for tie games
    //TODO When game ends
    //TODO Buttons at the bottom: what are they responsible for?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Image Button Event Handlers
    public void onClickSq1(View view)
    {
        //Player 1 vs Droid
        if(turnNumber % 2 == 1 && vsDroid)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square1);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
                droidPick();
            }
        }
        //Two players, player one's turn, check to see if player 1 won, else continue
        else if(turnNumber % 2 == 1 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square1);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron) && !player2Wins)
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
        //Two players, player two's turn, check to see if player 2 won, else continue
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square1);
            ib.setImageResource(R.drawable.curry);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.curry
                    && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.curry) && !humanWins)
            {
                player2Wins = true;
                player2WinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq2(View view)
    {
        if(turnNumber % 2 == 1 && vsDroid)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square2);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
                droidPick();
            }
        }
        else if(turnNumber % 2 == 1 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square2);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square2);
            ib.setImageResource(R.drawable.curry);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.curry
                    && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.curry))
            {
                player2Wins = true;
                player2WinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq3(View view)
    {
        if(turnNumber % 2 == 1 && vsDroid)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square3);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
                droidPick();
            }
        }
        else if(turnNumber % 2 == 1 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square3);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square3);
            ib.setImageResource(R.drawable.curry);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.curry
                    && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.curry))
            {
                player2Wins = true;
                player2WinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq4(View view)
    {
        if(turnNumber % 2 == 1 && vsDroid)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square4);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
                droidPick();
            }
        }
        else if(turnNumber % 2 == 1 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square4);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square4);
            ib.setImageResource(R.drawable.curry);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.curry
                    && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.curry))
            {
                player2Wins = true;
                player2WinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq5(View view)
    {
        if(turnNumber % 2 == 1 && vsDroid)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square5);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
                droidPick();
            }
        }
        else if(turnNumber % 2 == 1 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square5);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square5);
            ib.setImageResource(R.drawable.curry);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.curry
                    && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.curry))
            {
                player2Wins = true;
                player2WinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq6(View view)
    {
        if(turnNumber % 2 == 1 && vsDroid)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square6);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
                droidPick();
            }
        }
        else if(turnNumber % 2 == 1 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square6);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square6);
            ib.setImageResource(R.drawable.curry);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.curry
                    && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.curry))
            {
                player2Wins = true;
                player2WinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq7(View view)
    {
        if(turnNumber % 2 == 1 && vsDroid)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square7);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
                droidPick();
            }
        }
        else if(turnNumber % 2 == 1 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square7);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square7);
            ib.setImageResource(R.drawable.curry);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.curry
                    && ((ImageButton)findViewById(R.id.square4)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.curry))
            {
                player2Wins = true;
                player2WinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq8(View view)
    {
        if(turnNumber % 2 == 1 && vsDroid)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square8);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
                droidPick();
            }
        }
        else if(turnNumber % 2 == 1 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square8);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square8);
            ib.setImageResource(R.drawable.curry);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.curry
                    && ((ImageButton)findViewById(R.id.square9)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square2)).getTag() == R.drawable.curry))
            {
                player2Wins = true;
                player2WinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq9(View view)
    {
        if(turnNumber % 2 == 1 && vsDroid)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square9);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            //Check Tic-Tac-Toe from user's side
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
                droidPick();
            }
        }
        else if(turnNumber % 2 == 1 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square9);
            ib.setImageResource(R.drawable.lebron);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.lebron
                    && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.lebron) ||
                    (ib.getTag() == R.drawable.lebron && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.lebron
                            && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.lebron))
            {
                humanWins = true;
                humanWinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square9);
            ib.setImageResource(R.drawable.curry);
            ib.setClickable(false);
            if((ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square8)).getTag() == R.drawable.curry
                    && ((ImageButton)findViewById(R.id.square7)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square6)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square3)).getTag() == R.drawable.curry) ||
                    (ib.getTag() == R.drawable.curry && ((ImageButton)findViewById(R.id.square5)).getTag() == R.drawable.curry
                            && ((ImageButton)findViewById(R.id.square1)).getTag() == R.drawable.curry))
            {
                player2Wins = true;
                player2WinCounter++;
            }
            else
            {
                turnNumber++;
            }
        }
    }

    //Droid's turn
    public void droidPick()
    {

    }

    //Event Handlers
    public void onResetClick(View view)
    {

    }

    //Event Handlers
    public void onAboutClick(View view)
    {

    }

    //Event Handlers
    public void onZeroClick(View view)
    {

    }

    //Event Handlers
    public void onScoresClick(View view)
    {

    }

    //Event Handlers
    public void onPlayClick(View view)
    {
        TextView t = (TextView)findViewById(R.id.playerOpponentIs);
        if(t.getText().equals("You are playing against the droid"))
        {
            //TODO: Clear the board
            t.setText("You are playing against a human");
            vsHuman = true;
            vsDroid = false;
            humanWins = false;
            droidWins = false;
            player2Wins = false;
            turnNumber = 1; //Reset the turn number
        }
        else
        {
            //TODO: Clear the board
            t.setText("You are playing against the droid");
            vsDroid = true;
            vsHuman = false;
            humanWins = false;
            droidWins = false;
            player2Wins = false;
            turnNumber = 1; //Reset the turn number
        }
    }
}
