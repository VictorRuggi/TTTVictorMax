package com.example.victor.tttvictormax;

import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
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
    private int humanLossCounter = 0;
    private int droidWinCounter = 0;
    private int droidLossCounter = 0;
    private int player2WinCounter = 0;
    private int player2LossCounter = 0;
    private int humanTieCounter = 0;
    private int droidTieCounter = 0;
    private int player2TieCounter = 0;

    /*ArrayList containing all the ImageButtons*/
    ArrayList<ImageButton> buttons = new ArrayList<ImageButton>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set buttons list to contain all clickable image buttons
        buttons.add((ImageButton) findViewById(R.id.square1));
        buttons.add((ImageButton) findViewById(R.id.square2));
        buttons.add((ImageButton) findViewById(R.id.square3));
        buttons.add((ImageButton) findViewById(R.id.square4));
        buttons.add((ImageButton) findViewById(R.id.square5));
        buttons.add((ImageButton) findViewById(R.id.square6));
        buttons.add((ImageButton) findViewById(R.id.square7));
        buttons.add((ImageButton) findViewById(R.id.square8));
        buttons.add((ImageButton) findViewById(R.id.square9));

        //All buttons will have the default basketball tag to start.
        for(int i=0; i<buttons.size(); i++)
        {
            buttons.get(i).setClickable(true);
            buttons.get(i).setImageResource(R.drawable.basketball);
            buttons.get(i).setTag(R.drawable.basketball);
        }


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side



            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) ||
                     ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) && !droidWins )
            {
                humanWins = true;
                humanWinCounter++;
                droidLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
                droidPick();
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                droidTieCounter++;
                gameOver();
            }
        }
        //Two players, player one's turn, check to see if player 1 won, else continue
        else if(turnNumber % 2 == 1 && vsHuman) {
            ImageButton ib = (ImageButton) findViewById(R.id.square1);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) && !player2Wins )
            {
                humanWins = true;
                humanWinCounter++;
                player2LossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
        //Two players, player two's turn, check to see if player 2 won, else continue
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square1);
            ib.setImageResource(R.drawable.curry);
            ib.setTag(R.drawable.curry);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.curry) ) && !humanWins )
            {
                player2Wins = true;
                player2WinCounter++;
                humanLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !player2Wins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq2(View view) {
        if (turnNumber % 2 == 1 && vsDroid) {
            ImageButton ib = (ImageButton) findViewById(R.id.square2);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.lebron) ) && !droidWins )
            {
                humanWins = true;
                humanWinCounter++;
                droidLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
                droidPick();
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                droidTieCounter++;
                gameOver();
            }
        } else if (turnNumber % 2 == 1 && vsHuman) {
            ImageButton ib = (ImageButton) findViewById(R.id.square2);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.lebron) ) && !player2Wins )
            {
                humanWins = true;
                humanWinCounter++;
                player2LossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square2);
            ib.setImageResource(R.drawable.curry);
            ib.setTag(R.drawable.curry);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.curry) ) && !humanWins )
            {
                player2Wins = true;
                player2WinCounter++;
                humanLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !player2Wins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq3(View view) {
        if (turnNumber % 2 == 1 && vsDroid) {
            ImageButton ib = (ImageButton) findViewById(R.id.square3);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) && !droidWins )
            {
                humanWins = true;
                humanWinCounter++;
                droidLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
                droidPick();
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                droidTieCounter++;
                gameOver();
            }
        } else if (turnNumber % 2 == 1 && vsHuman) {
            ImageButton ib = (ImageButton) findViewById(R.id.square3);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) && !player2Wins )
            {
                humanWins = true;
                humanWinCounter++;
                player2LossCounter++;
                gameOver();
            } else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square3);
            ib.setImageResource(R.drawable.curry);
            ib.setTag(R.drawable.curry);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.curry) ) && !humanWins )
            {
                player2Wins = true;
                player2WinCounter++;
                humanLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !player2Wins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq4(View view) {
        if (turnNumber % 2 == 1 && vsDroid) {
            ImageButton ib = (ImageButton) findViewById(R.id.square4);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) && !droidWins )
            {
                humanWins = true;
                humanWinCounter++;
                droidLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
                droidPick();
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                droidTieCounter++;
                gameOver();
            }
        } else if (turnNumber % 2 == 1 && vsHuman) {
            ImageButton ib = (ImageButton) findViewById(R.id.square4);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) && !player2Wins )
            {
                humanWins = true;
                humanWinCounter++;
                player2LossCounter++;
                gameOver();
            } else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square4);
            ib.setImageResource(R.drawable.curry);
            ib.setTag(R.drawable.curry);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.curry) ) && !humanWins )
            {
                player2Wins = true;
                player2WinCounter++;
                humanLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !player2Wins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq5(View view) {
        if (turnNumber % 2 == 1 && vsDroid) {
            ImageButton ib = (ImageButton) findViewById(R.id.square5);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) && !droidWins )
            {
                humanWins = true;
                humanWinCounter++;
                droidLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
                droidPick();
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                droidTieCounter++;
                gameOver();
            }
        } else if (turnNumber % 2 == 1 && vsHuman) {
            ImageButton ib = (ImageButton) findViewById(R.id.square5);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) && !player2Wins )
            {
                humanWins = true;
                humanWinCounter++;
                player2LossCounter++;
                gameOver();
            } else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square5);
            ib.setImageResource(R.drawable.curry);
            ib.setTag(R.drawable.curry);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.curry) ) && !humanWins )
            {
                player2Wins = true;
                player2WinCounter++;
                humanLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !player2Wins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq6(View view) {
        if (turnNumber % 2 == 1 && vsDroid) {
            ImageButton ib = (ImageButton) findViewById(R.id.square6);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) && !droidWins )
            {
                humanWins = true;
                humanWinCounter++;
                droidLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
                droidPick();
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                droidTieCounter++;
                gameOver();
            }
        } else if (turnNumber % 2 == 1 && vsHuman) {
            ImageButton ib = (ImageButton) findViewById(R.id.square6);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) && !player2Wins )
            {
                humanWins = true;
                humanWinCounter++;
                player2LossCounter++;
                gameOver();
            } else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square6);
            ib.setImageResource(R.drawable.curry);
            ib.setTag(R.drawable.curry);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.curry) ) && !humanWins )
            {
                player2Wins = true;
                player2WinCounter++;
                humanLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !player2Wins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq7(View view) {
        if (turnNumber % 2 == 1 && vsDroid) {
            ImageButton ib = (ImageButton) findViewById(R.id.square7);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) ) && !droidWins )
            {
                humanWins = true;
                humanWinCounter++;
                droidLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
                droidPick();
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                droidTieCounter++;
                gameOver();
            }
        } else if (turnNumber % 2 == 1 && vsHuman) {
            ImageButton ib = (ImageButton) findViewById(R.id.square7);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) ) && !player2Wins )
            {
                humanWins = true;
                humanWinCounter++;
                player2LossCounter++;
                gameOver();
            } else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square7);
            ib.setImageResource(R.drawable.curry);
            ib.setTag(R.drawable.curry);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.curry) ) && !humanWins )  {
                player2Wins = true;
                player2WinCounter++;
                humanLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !player2Wins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq8(View view) {
        if (turnNumber % 2 == 1 && vsDroid) {
            ImageButton ib = (ImageButton) findViewById(R.id.square8);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) ) && !droidWins )
            {
                humanWins = true;
                humanWinCounter++;
                droidLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
                droidPick();
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                droidTieCounter++;
                gameOver();
            }
        } else if (turnNumber % 2 == 1 && vsHuman) {
            ImageButton ib = (ImageButton) findViewById(R.id.square8);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) ) && !player2Wins )
            {
                humanWins = true;
                humanWinCounter++;
                player2LossCounter++;
                gameOver();
            } else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square8);
            ib.setImageResource(R.drawable.curry);
            ib.setTag(R.drawable.curry);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) ) && !humanWins )
            {
                player2Wins = true;
                player2WinCounter++;
                humanLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !player2Wins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
    }

    //Image Button Event Handlers
    public void onClickSq9(View view) {
        if (turnNumber % 2 == 1 && vsDroid) {
            ImageButton ib = (ImageButton) findViewById(R.id.square9);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);
            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            //Check Tic-Tac-Toe from user's side
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) ) && !droidWins )
            {
                humanWins = true;
                humanWinCounter++;
                droidLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
                droidPick();
            }
            else if (turnNumber == 9 && !humanWins && !droidWins)
            {
                humanTieCounter++;
                droidTieCounter++;
                gameOver();
            }
        } else if (turnNumber % 2 == 1 && vsHuman) {
            ImageButton ib = (ImageButton) findViewById(R.id.square9);
            ib.setImageResource(R.drawable.lebron);
            ib.setTag(R.drawable.lebron);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.lebron) ) ||
                    ( ib.getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.lebron) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.lebron) ) && !player2Wins )
            {
                humanWins = true;
                humanWinCounter++;
                player2LossCounter++;
                gameOver();
            } else if (turnNumber != 9 && !humanWins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
        else if(turnNumber % 2 == 0 && vsHuman)
        {
            ImageButton ib = (ImageButton)findViewById(R.id.square9);
            ib.setImageResource(R.drawable.curry);
            ib.setTag(R.drawable.curry);
            ib.setClickable(false);

            buttons.remove(ib); //Once a square is picked, it is removed from the list of possible playable squares.
            if( ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.curry) ) ||
                    ( ib.getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.curry) ) && !humanWins )
            {
                player2Wins = true;
                player2WinCounter++;
                humanLossCounter++;
                gameOver();
            }
            else if (turnNumber != 9 && !player2Wins)
            {
                turnNumber++;
            }
            else if (turnNumber == 9 && !humanWins && !player2Wins)
            {
                humanTieCounter++;
                player2TieCounter++;
                gameOver();
            }
        }
    }

    //Droid's turn
    //The droid plays as Stephen Curry
    public void droidPick() {
        int rnd = (int) (Math.random() * buttons.size());
        ImageButton ib = buttons.get(rnd);
        ib.setImageResource(R.drawable.curry);
        ib.setTag(R.drawable.curry);
        ib.setClickable(false);
        buttons.remove(ib);

        //Check for all possible Tic-Tac-Toe winning formulas
        if( ( ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.curry) ) && !humanWins)
          {
              droidWins = true;
              droidWinCounter++;
              humanLossCounter++;
              gameOver();
          }
        else if( ( ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.curry) ) && !humanWins)
        {
            droidWins = true;
            droidWinCounter++;
            humanLossCounter++;
            gameOver();
        }
        else if( ( ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.curry) ) && !humanWins)
        {
            droidWins = true;
            droidWinCounter++;
            humanLossCounter++;
            gameOver();
        }
        else if( ( ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square4))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.curry) ) && !humanWins)
        {
            droidWins = true;
            droidWinCounter++;
            humanLossCounter++;
            gameOver();
        }
        else if( ( ((ImageButton)(findViewById(R.id.square2))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square8))).getTag().equals(R.drawable.curry) ) && !humanWins)
        {
            droidWins = true;
            droidWinCounter++;
            humanLossCounter++;
            gameOver();
        }
        else if( ( ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square6))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.curry) ) && !humanWins)
        {
            droidWins = true;
            droidWinCounter++;
            humanLossCounter++;
            gameOver();
        }
        else if( ( ((ImageButton)(findViewById(R.id.square1))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square9))).getTag().equals(R.drawable.curry) ) && !humanWins)
        {
            droidWins = true;
            droidWinCounter++;
            humanLossCounter++;
            gameOver();
        }
        else if( ( ((ImageButton)(findViewById(R.id.square3))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square5))).getTag().equals(R.drawable.curry) && ((ImageButton)(findViewById(R.id.square7))).getTag().equals(R.drawable.curry) ) && !humanWins)
        {
            droidWins = true;
            droidWinCounter++;
            humanLossCounter++;
            gameOver();
        }
        else if (turnNumber == 9 && !humanWins && !droidWins)
        {
            humanTieCounter++;
            droidTieCounter++;
            gameOver();
        }

    }

    //When game is over
    public void gameOver() {
        Toast message;
        for (int i = 0; i < buttons.size(); i++) {
            //Disable the buttons
            buttons.get(i).setClickable(false);
        }

        // Checks to see if human player won, whether gameplay was against droid or another human.
        // When the user is playing another human, droidWins will always be false.
        if (humanWins && !droidWins && !player2Wins) {
            message = Toast.makeText(this, R.string.humanWins, Toast.LENGTH_SHORT);
            message.show();
        } else if (!humanWins && droidWins) {
            message = Toast.makeText(this, R.string.droidWins, Toast.LENGTH_SHORT);
            message.show();
        } else if (!humanWins && player2Wins) {
            message = Toast.makeText(this, R.string.player2Wins, Toast.LENGTH_SHORT);
            message.show();
        } else if (!humanWins && !droidWins && !player2Wins) //No winners. When the user is playing the droid, player2Wins is set to false.
        {
            message = Toast.makeText(this, R.string.tieGame, Toast.LENGTH_SHORT);
            message.show();
        }
    }

    //Event Handlers
    public void onResetClick(View view) {
        //Clear image buttons list, then put them back
        buttons.clear();
        buttons.add((ImageButton) findViewById(R.id.square1));
        buttons.add((ImageButton) findViewById(R.id.square2));
        buttons.add((ImageButton) findViewById(R.id.square3));
        buttons.add((ImageButton) findViewById(R.id.square4));
        buttons.add((ImageButton) findViewById(R.id.square5));
        buttons.add((ImageButton) findViewById(R.id.square6));
        buttons.add((ImageButton) findViewById(R.id.square7));
        buttons.add((ImageButton) findViewById(R.id.square8));
        buttons.add((ImageButton) findViewById(R.id.square9));

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setClickable(true);
            buttons.get(i).setImageResource(R.drawable.basketball);
            buttons.get(i).setTag(R.drawable.basketball);
        }

        turnNumber = 1; //Starts a new game
        /*
        * These three variables below must be set to false in order for gameplay to occur.
        */
        humanWins = false;
        droidWins = false;
        player2Wins = false;
    }

    //Event Handlers
    public void onAboutClick(View view) {
        Intent intent = new Intent(this, AboutMessageActivity.class);
        startActivity(intent);
        //TODO (for Max): Ensure state is saved
    }

    //Event Handlers
    public void onZeroClick(View view) {
        /*Reset the counters*/
        humanWinCounter = 0;
        droidWinCounter = 0;
        player2WinCounter = 0;
        humanTieCounter = 0;
        droidTieCounter = 0;
        player2TieCounter = 0;
        humanLossCounter = 0;
        droidLossCounter = 0;
        player2LossCounter = 0;

        //TODO (for Max): Save the counters in SharedPreferences
    }

    //Event Handlers
    public void onScoresClick(View view) {
        TextView t = (TextView)findViewById(R.id.scoresText);
        String text = String.format(t.getText().toString(), humanWinCounter, humanLossCounter, humanTieCounter, droidWinCounter, droidLossCounter, droidTieCounter, player2WinCounter, player2LossCounter, player2TieCounter);
        t.setText(text);
        Intent intent = new Intent(this, ScoresActivity.class);
        startActivity(intent);
        //TODO (for Max): Ensure state is saved
    }

    //Event Handlers
    public void onPlayClick(View view) {
        TextView t = (TextView) findViewById(R.id.playerOpponentIsDroid);
        TextView v = (TextView) findViewById(R.id.playerOpponentIsHuman);
        if (t.getVisibility() == View.VISIBLE) //This is one of two possible values that the TextView could have. It is the default
        {
            //Clear image buttons list, then put them back
            buttons.clear();
            buttons.add((ImageButton) findViewById(R.id.square1));
            buttons.add((ImageButton) findViewById(R.id.square2));
            buttons.add((ImageButton) findViewById(R.id.square3));
            buttons.add((ImageButton) findViewById(R.id.square4));
            buttons.add((ImageButton) findViewById(R.id.square5));
            buttons.add((ImageButton) findViewById(R.id.square6));
            buttons.add((ImageButton) findViewById(R.id.square7));
            buttons.add((ImageButton) findViewById(R.id.square8));
            buttons.add((ImageButton) findViewById(R.id.square9));

            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).setClickable(true);
                buttons.get(i).setImageResource(R.drawable.basketball);
                buttons.get(i).setTag(R.drawable.basketball);
            }

            //You are playing against a human
            t.setVisibility(View.INVISIBLE);
            v.setVisibility(View.VISIBLE);

            vsHuman = true;
            vsDroid = false;
            humanWins = false;
            droidWins = false;
            player2Wins = false;
            turnNumber = 1; //Reset the turn number
        } else {
            //Clear image buttons list, then put them back
            buttons.clear();
            buttons.add((ImageButton) findViewById(R.id.square1));
            buttons.add((ImageButton) findViewById(R.id.square2));
            buttons.add((ImageButton) findViewById(R.id.square3));
            buttons.add((ImageButton) findViewById(R.id.square4));
            buttons.add((ImageButton) findViewById(R.id.square5));
            buttons.add((ImageButton) findViewById(R.id.square6));
            buttons.add((ImageButton) findViewById(R.id.square7));
            buttons.add((ImageButton) findViewById(R.id.square8));
            buttons.add((ImageButton) findViewById(R.id.square9));

            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).setClickable(true);
                buttons.get(i).setImageResource(R.drawable.basketball);
                buttons.get(i).setTag(R.drawable.basketball);
            }

            //You are playing against the droid
            t.setVisibility(View.VISIBLE);
            v.setVisibility(View.INVISIBLE);

            vsDroid = true;
            vsHuman = false;
            humanWins = false;
            droidWins = false;
            player2Wins = false;
            turnNumber = 1; //Reset the turn number
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.victor.tttvictormax/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.victor.tttvictormax/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
