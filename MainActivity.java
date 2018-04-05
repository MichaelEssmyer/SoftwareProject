package com.java.michael.pazzhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton tokBut1, tokBut2, tokBut3, tokBut4; //clickable player choices
    ImageButton opp1, opp2, opp3, opp4; //not clickable
    Button endturn, stand; //clickable player turns
    TextView pscoreview, oscoreview, pwinsview, owinsview;
    Token ptok1, ptok2, ptok3, ptok4, otok1, otok2, otok3, otok4;
    TokenSorter user, opponent;
    Token dealToken;
    int round, ppoints, opoints, pwin, owin =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Initiate GUI VVVVVVVVVVV
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Text View
        pscoreview = findViewById(R.id.pscore);
        oscoreview = findViewById(R.id.oscore);
        pwinsview = findViewById(R.id.pwins);
        owinsview = findViewById(R.id.owins);
        //Button Tokens
        tokBut1 = findViewById(R.id.tok1);
        tokBut2 = findViewById(R.id.tok2);
        tokBut3 = findViewById(R.id.tok3);
        tokBut4 = findViewById(R.id.tok4);
        opp1 = findViewById(R.id.opp1);
        opp2 = findViewById(R.id.opp2);
        opp3 = findViewById(R.id.opp3);
        opp4 = findViewById(R.id.opp4);
        //Button Players
        endturn = findViewById(R.id.endturn);
        stand = findViewById(R.id.stand);

        //Initiate game VVVVVVVVVVV
        if(pwin==0 && owin==0){newgame();//}
        if(pwin<3 && owin<3) {
        //setplayTokens();
        //setoppTokens();

            //Define Actions
            tokBut1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /////////////
                    //add the token to the score
                    ppoints += user.tok1.tokenvalue;
                    //ppoints += user.getval(1);
                    
                    //clear the token from the board
                    //user.tok1.setTokenvalue(0);
                    //user.setval(1,0);
                    /////////////
                    tokBut1.setImageResource(R.drawable.iconu); //works
                    //update the score/view
                    pscoreview.setText("Player score: " + ppoints); //works
                }
            });
            tokBut2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // ppoints += user.tok2.tokenvalue;
                   // user.tok2.tokenvalue = 0;
                    tokBut2.setImageResource(R.drawable.iconu);
                    pscoreview.setText("Player score: " + ppoints);
                }
            });
            tokBut3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //ppoints += user.tok3.tokenvalue;
                    //user.tok3.tokenvalue = 0;
                    tokBut3.setImageResource(R.drawable.iconu);
                    pscoreview.setText("Player score: " + ppoints);
                }
            });
            tokBut4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // ppoints += user.tok4.tokenvalue;
                   // user.tok4.tokenvalue = 0;
                    tokBut4.setImageResource(R.drawable.iconu);
                    pscoreview.setText("Player score: " + ppoints);
                }
            });
            endturn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updatescore();
                }
            });
            stand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    user.setBool(true);
                    updatescore();
                }
            });
        }
    }
    public void setplayTokens() {//depending on values set images
        //default and clear image cards
        if (user.tok1.tokenvalue == 0) {tokBut1.setImageResource(R.drawable.iconu);}
        if (user.tok2.tokenvalue == 0) {tokBut2.setImageResource(R.drawable.iconu);}
        if (user.tok3.tokenvalue == 0) {tokBut3.setImageResource(R.drawable.iconu);}
        if (user.tok4.tokenvalue == 0) {tokBut4.setImageResource(R.drawable.iconu);}

        //image of playable cards
        if (user.tok1.tokenvalue == 1) {tokBut1.setImageResource(R.drawable.icon1);}
        if (user.tok2.tokenvalue == 1) {tokBut2.setImageResource(R.drawable.icon1);}
        if (user.tok3.tokenvalue == 1) {tokBut3.setImageResource(R.drawable.icon1);}
        if (user.tok4.tokenvalue == 1) {tokBut4.setImageResource(R.drawable.icon1);}
        if (user.tok1.tokenvalue == 2) {tokBut1.setImageResource(R.drawable.icon2);}
        if (user.tok2.tokenvalue == 2) {tokBut2.setImageResource(R.drawable.icon2);}
        if (user.tok3.tokenvalue == 2) {tokBut3.setImageResource(R.drawable.icon2);}
        if (user.tok4.tokenvalue == 2) {tokBut4.setImageResource(R.drawable.icon2);}
        if (user.tok1.tokenvalue == 3) {tokBut1.setImageResource(R.drawable.icon3);}
        if (user.tok2.tokenvalue == 3) {tokBut2.setImageResource(R.drawable.icon3);}
        if (user.tok3.tokenvalue == 3) {tokBut3.setImageResource(R.drawable.icon3);}
        if (user.tok4.tokenvalue == 3) {tokBut4.setImageResource(R.drawable.icon3);}
        if (user.tok1.tokenvalue == 4) {tokBut1.setImageResource(R.drawable.icon4);}
        if (user.tok2.tokenvalue == 4) {tokBut2.setImageResource(R.drawable.icon4);}
        if (user.tok3.tokenvalue == 4) {tokBut3.setImageResource(R.drawable.icon4);}
        if (user.tok4.tokenvalue == 4) {tokBut4.setImageResource(R.drawable.icon4);}
        if (user.tok1.tokenvalue == 5) {tokBut1.setImageResource(R.drawable.icon5);}
        if (user.tok2.tokenvalue == 5) {tokBut2.setImageResource(R.drawable.icon5);}
        if (user.tok3.tokenvalue == 5) {tokBut3.setImageResource(R.drawable.icon5);}
        if (user.tok4.tokenvalue == 5) {tokBut4.setImageResource(R.drawable.icon5);}
        if (user.tok1.tokenvalue == 6) {tokBut1.setImageResource(R.drawable.icon6);}
        if (user.tok2.tokenvalue == 6) {tokBut2.setImageResource(R.drawable.icon6);}
        if (user.tok3.tokenvalue == 6) {tokBut3.setImageResource(R.drawable.icon6);}
        if (user.tok4.tokenvalue == 6) {tokBut4.setImageResource(R.drawable.icon6);}
        if (user.tok1.tokenvalue == 7) {tokBut1.setImageResource(R.drawable.icon7);}
        if (user.tok2.tokenvalue == 7) {tokBut2.setImageResource(R.drawable.icon7);}
        if (user.tok3.tokenvalue == 7) {tokBut3.setImageResource(R.drawable.icon7);}
        if (user.tok4.tokenvalue == 7) {tokBut4.setImageResource(R.drawable.icon7);}
        if (user.tok1.tokenvalue == 8) {tokBut1.setImageResource(R.drawable.icon8);}
        if (user.tok2.tokenvalue == 8) {tokBut2.setImageResource(R.drawable.icon8);}
        if (user.tok3.tokenvalue == 8) {tokBut3.setImageResource(R.drawable.icon8);}
        if (user.tok4.tokenvalue == 8) {tokBut4.setImageResource(R.drawable.icon8);}
        if (user.tok1.tokenvalue == 9) {tokBut1.setImageResource(R.drawable.icon9);}
        if (user.tok2.tokenvalue == 9) {tokBut2.setImageResource(R.drawable.icon9);}
        if (user.tok3.tokenvalue == 9) {tokBut3.setImageResource(R.drawable.icon9);}
        if (user.tok4.tokenvalue == 9) {tokBut4.setImageResource(R.drawable.icon9);}
        if (user.tok1.tokenvalue == 10) {tokBut1.setImageResource(R.drawable.icon10);}
        if (user.tok2.tokenvalue == 10) {tokBut2.setImageResource(R.drawable.icon10);}
        if (user.tok3.tokenvalue == 10) {tokBut3.setImageResource(R.drawable.icon10);}
        if (user.tok4.tokenvalue == 10) {tokBut4.setImageResource(R.drawable.icon10);}
    }
    public void setoppTokens() {
        if(opponent.tok1.tokenvalue > 0){opp1.setImageResource(R.drawable.icon0);}
        if(opponent.tok2.tokenvalue > 0){opp2.setImageResource(R.drawable.icon0);}
        if(opponent.tok3.tokenvalue > 0){opp3.setImageResource(R.drawable.icon0);}
        if(opponent.tok4.tokenvalue > 0){opp4.setImageResource(R.drawable.icon0);}
        if(opponent.tok1.tokenvalue == 0){opp1.setImageResource(R.drawable.iconu);}
        if(opponent.tok2.tokenvalue == 0){opp2.setImageResource(R.drawable.iconu);}
        if(opponent.tok3.tokenvalue == 0){opp3.setImageResource(R.drawable.iconu);}
        if(opponent.tok4.tokenvalue == 0){opp4.setImageResource(R.drawable.iconu);}
    }
    private void updatescore(){
        pscoreview.setText("Player score: " + ppoints);
        oscoreview.setText("Opponent score: " + opoints);
        //setplayTokens();
        //setoppTokens();
    }
    private void newgame(){
        user = new TokenSorter();
        opponent = new TokenSorter();
        /*pwin = 0;
        owin = 0;
        ppoints = 0;
        opoints = 0;
        round = 0;*/
        updatescore();
    }
    public int dealToken(){
        Token deal = new Token();
        return deal.tokenvalue;
    }
    /*
    private void newround(){
        ppoints = 0;
        opoints = 0;
    }

    private void trackwins(){
        if(ppoints > opoints && opponent.getBool() ==true&&ppoints<=20){pwin++;}
        if(opoints > ppoints && user.getBool() ==true&&opoints<=20){owin++;}
    }
    private void runopp(){
        if(user.getBool() == true && opoints > ppoints && opoints <= 20){

        }
        setoppTokens(opponent);
    }*/
}
    
