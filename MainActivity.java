package com.java.michael.pazzak_iteration3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView PS, OS, PW, OW;
    int t1val, t2val, t3val, t4val;
    ImageView O1, O2, O3, O4;
    int o1, o2, o3, o4;
    int pscore, oscore, pwins, owins;
    int alert = 0;
    int winner =3;
    //boolean opp, play =true;
    ImageButton i, j, k,l;
    Button endturn, stand;
    //Dialog Context View
    final Context context = this;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        PS = (TextView) findViewById(R.id.pscore);
        OS = (TextView) findViewById(R.id.oscore);
        PW = (TextView) findViewById(R.id.pwins);
        OW = (TextView) findViewById(R.id.owins);

        //Token id & select & clear
        i = (ImageButton) findViewById(R.id.image1);
        j = (ImageButton) findViewById(R.id.image2);
        k = (ImageButton) findViewById(R.id.image3);
        l = (ImageButton) findViewById(R.id.image4);

        //Token hidden & cleared
        O1 = (ImageView) findViewById(R.id.imageo1);
        O2 = (ImageView) findViewById(R.id.imageo2);
        O3 = (ImageView) findViewById(R.id.imageo3);
        O4 = (ImageView) findViewById(R.id.imageo4);

        //player action buttons
        endturn = (Button) findViewById(R.id.endturn);
        stand = (Button) findViewById(R.id.stand);

        //The Game VVVVVVVVVVV
        if(pwins<3 && owins<3){ //manage rounds
            if (alert == 0) {//start of first round alert w/ rules
                getTokens();
                //Alert Dialog Box
                AlertDialog.Builder myDialogBuilder = new AlertDialog.Builder(context);
                myDialogBuilder.setTitle("Welcome to Pazzak");
                myDialogBuilder
                        .setMessage("Get Closer to 20 than your opponent. \nWin 3 rounds to be victorious!!" +
                                "\nGet Token gets you a new token.\nStand stops the dealer for the round")
                        .setCancelable(false)
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {

                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = myDialogBuilder.create();
                alertDialog.show();
                alert++;
            }
            endturn.setText("Start");//initiate round
            stand.setText("Do not click");//initiate round
            PS.setText("Player score: " + pscore);
            OS.setText("Opponent score: " + oscore);
            i.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    pscore+= t1val;
                    //toggle off
                    t1val = 0;
                    i.setImageResource(R.drawable.icon0);
                    //show score
                    PS.setText("Player score: " + pscore);
                }
            });
            j.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    pscore+= t2val;
                    //toggle off
                    t2val = 0;
                    j.setImageResource(R.drawable.icon0);
                    PS.setText("Player score: " + pscore);
                }
            });
            k.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    pscore+= t3val;
                    //toggle off
                    t3val = 0;
                    k.setImageResource(R.drawable.icon0);
                    PS.setText("Player score: " + pscore);
                }
            });
            l.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    //
                    pscore+= t4val;
                    //toggle off
                    t4val = 0;
                    l.setImageResource(R.drawable.icon0);
                    PS.setText("Player score: " + pscore);
                }
            });
            endturn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stand.setText("Stand");
                    endturn.setText("GetToken");
                    //deal player
                    pscore = pscore + getToken();
                    PS.setText("Player score: " + pscore);

                    //run opponent after endturn
                    if ((oscore <= 17) || ((oscore < pscore) && (pscore <= 20))) {
                        oscore = oscore + getToken();
                        //opponent may choose a card
                        if(oscore+o1==20){oscore+=o1;o1=0; O1.setImageResource(R.drawable.iconp);}
                        if(oscore+o2==20){oscore+=o2;o2=0;O2.setImageResource(R.drawable.iconp);}
                        if(oscore+o3==20){oscore+=o3;o3=0;O3.setImageResource(R.drawable.iconp);}
                        if(oscore+o4==20){oscore+=o4;o4=0;O4.setImageResource(R.drawable.iconp);}
                        if(oscore+o1==19){oscore+=o1;o1=0;O1.setImageResource(R.drawable.iconp);}
                        if(oscore+o2==19){oscore+=o2;o2=0;O2.setImageResource(R.drawable.iconp);}
                        if(oscore+o3==19){oscore+=o3;o3=0;O3.setImageResource(R.drawable.iconp);}
                        if(oscore+o4==19){oscore+=o4;o4=0;O4.setImageResource(R.drawable.iconp);}
                        OS.setText("Opponent score: " + oscore);
                        //setImages();
                    }
                    //opponent wins after end turn
                    if ((oscore <= 20 && pscore > 20)) {
                        endturn.setText("Start Round");
                        stand.setText("You lost");
                        owins++;
                        OW.setText("Opponent Wins: " + owins);
                        oscore = 0;
                        pscore = 0;
                        PS.setText("Player score: " + pscore);
                        OS.setText("Opponent score: " + oscore);
                    }
                    //Both lose
                    if ((oscore > 20 && pscore > 20)||(oscore == 20 && pscore == 20)) {
                        endturn.setText("Start Round");
                        stand.setText("Tie");
                        oscore = 0;
                        pscore = 0;
                        PS.setText("Player score: " + pscore);
                        OS.setText("Opponent score: " + oscore);
                    }
                    //reset
                    if (pwins == winner) {
                        OW.setText("Player Wins!!!!!!");
                        owins = 0;
                        pwins = 0;
                        oscore = 0;
                        pscore = 0;
                        PW.setText("Opponent Wins: " + owins);
                        endturn.setText("Start Round");
                        stand.setText("You won");
                        alert = 0;
                        getTokens();
                    }
                    if (owins == winner) {
                        stand.setText("You lost");
                        owins = 0;
                        pwins = 0;
                        oscore = 0;
                        pscore = 0;
                        PW.setText("Player Wins: " + pwins);
                        OW.setText("Opponent Wins: " + owins);
                        endturn.setText("Start Round");
                        stand.setText("You lost");
                        alert = 0;
                        getTokens();
                    }
                }
            });

            stand.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    //Once player stands run the opponent
                    if((oscore<=17) || ((oscore < pscore) && (oscore < 20)))
                    {   //opponent wins after player stands
                        if(oscore<=20 &&pscore<oscore ){
                            endturn.setText("Start Round");
                            owins++;
                            OW.setText("Opponent Wins: "+ owins);
                            oscore=0;
                            pscore=0;
                            PS.setText("Player score: " + pscore);
                            OS.setText("Opponent score: " + oscore);
                        }
                        oscore = oscore + getToken();
                        OS.setText("Opponent score: " + oscore);
                        PS.setText("Player score: " + pscore);
                    }
                    //player wins
                    if((pscore<=20 && oscore>20)||
                            (pscore>oscore && pscore<=20)){
                        endturn.setText("Start Round");
                        pwins++;
                        PW.setText("Player Wins: "+ pwins);
                        oscore=0;
                        pscore=0;
                        PS.setText("Player score: " + pscore);
                        OS.setText("Opponent score: " + oscore);
                    }
                    //opponent wins
                    if(((pscore<oscore) && (oscore<=20))){
                        endturn.setText("Start Round");
                        owins++;
                        OW.setText("Opponent Wins: "+ owins);
                        oscore=0;
                        pscore=0;
                        PS.setText("Player score: " + pscore);
                        OS.setText("Opponent score: " + oscore);
                    }
                    //tie
                    if(((pscore==20&&oscore==20) ||
                            (pscore==19&&oscore==19) ||
                            (pscore==18&&oscore==18) ||
                            (oscore>20&&pscore>20))){
                        endturn.setText("Start Round");
                        stand.setText("Tie");
                        oscore = 0;
                        pscore = 0;
                        PS.setText("Player score: " + pscore);
                        OS.setText("Opponent score: " + oscore);
                    }
                    //reset
                    if(pwins==winner){
                        OW.setText("Player Wins!!!!!!");
                        owins=0;
                        pwins = 0;
                        oscore=0;
                        pscore=0;
                        PS.setText("Player score: " + pscore);
                        OS.setText("Opponent score: " + oscore);
                        PW.setText("Player Wins: "+ pwins);
                        endturn.setText("Start Round");
                        alert=0;
                        getTokens();
                    }
                    if(owins==winner) {
                        PW.setText("Opponent Wins!!!!!!");
                        owins = 0;
                        pwins = 0;
                        oscore = 0;
                        pscore = 0;
                        PS.setText("Player score: " + pscore);
                        OS.setText("Opponent score: " + oscore);
                        OW.setText("Opponent Wins: " + owins);
                        endturn.setText("Start Round");
                        alert = 0;
                        getTokens();
                    }
                }
            });
        }
        //
    }
    public void setImages(){
        if(t1val == 0){i.setImageResource(R.drawable.icon0);}
        if(t1val == 1){i.setImageResource(R.drawable.icon1);}
        if(t1val == 2){i.setImageResource(R.drawable.icon2);}
        if(t1val == 3){i.setImageResource(R.drawable.icon3);}
        if(t1val == 4){i.setImageResource(R.drawable.icon4);}
        if(t1val == 5){i.setImageResource(R.drawable.icon5);}
        if(t1val == 6){i.setImageResource(R.drawable.icon6);}
        if(t1val == 7){i.setImageResource(R.drawable.icon7);}
        if(t1val == 8){i.setImageResource(R.drawable.icon8);}
        if(t1val == 9){i.setImageResource(R.drawable.icon9);}
        if(t1val == 10){i.setImageResource(R.drawable.icon10);}
        if(t2val == 0){j.setImageResource(R.drawable.icon0);}
        if(t2val == 1){j.setImageResource(R.drawable.icon1);}
        if(t2val == 2){j.setImageResource(R.drawable.icon2);}
        if(t2val == 3){j.setImageResource(R.drawable.icon3);}
        if(t2val == 4){j.setImageResource(R.drawable.icon4);}
        if(t2val == 5){j.setImageResource(R.drawable.icon5);}
        if(t2val == 6){j.setImageResource(R.drawable.icon6);}
        if(t2val == 7){j.setImageResource(R.drawable.icon7);}
        if(t2val == 8){j.setImageResource(R.drawable.icon8);}
        if(t2val == 9){j.setImageResource(R.drawable.icon9);}
        if(t2val == 10){j.setImageResource(R.drawable.icon10);}
        if(t3val == 0){k.setImageResource(R.drawable.icon0);}
        if(t3val == 1){k.setImageResource(R.drawable.icon1);}
        if(t3val == 2){k.setImageResource(R.drawable.icon2);}
        if(t3val == 3){k.setImageResource(R.drawable.icon3);}
        if(t3val == 4){k.setImageResource(R.drawable.icon4);}
        if(t3val == 5){k.setImageResource(R.drawable.icon5);}
        if(t3val == 6){k.setImageResource(R.drawable.icon6);}
        if(t3val == 7){k.setImageResource(R.drawable.icon7);}
        if(t3val == 8){k.setImageResource(R.drawable.icon8);}
        if(t3val == 9){k.setImageResource(R.drawable.icon9);}
        if(t3val == 10){k.setImageResource(R.drawable.icon10);}
        if(t4val == 0){l.setImageResource(R.drawable.icon0);}
        if(t4val == 1){l.setImageResource(R.drawable.icon1);}
        if(t4val == 2){l.setImageResource(R.drawable.icon2);}
        if(t4val == 3){l.setImageResource(R.drawable.icon3);}
        if(t4val == 4){l.setImageResource(R.drawable.icon4);}
        if(t4val == 5){l.setImageResource(R.drawable.icon5);}
        if(t4val == 6){l.setImageResource(R.drawable.icon6);}
        if(t4val == 7){l.setImageResource(R.drawable.icon7);}
        if(t4val == 8){l.setImageResource(R.drawable.icon8);}
        if(t4val == 9){l.setImageResource(R.drawable.icon9);}
        if(t4val == 10){l.setImageResource(R.drawable.icon10);}
        else{getTokens();}
      if(o1>0){O1.setImageResource(R.drawable.icon0);}
      if(o2>0){  O2.setImageResource(R.drawable.icon0);}
      if(o3>0){ O3.setImageResource(R.drawable.icon0);}
      if(o4>0){ O4.setImageResource(R.drawable.icon0);}
    }
    public void getTokens(){
        t1val = getToken();
        t2val = getToken();
        t3val = getToken();
        t4val = getToken();
        o1 = getToken();
        o2 = getToken();
        o3 = getToken();
        o4 = getToken();
        setImages();
    }
    //get random token
    public int getToken(){
        int i = randomNumberInRange(10, 1);
        return i;
    }
    private int randomNumberInRange(int max, int min) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
