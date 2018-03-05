package com.java.michael.pazzak_devo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.BreakIterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int playerscore, opponentscore;

    //String int1,int2,int3,int4;
    int t1val, t2val, t3val,t4val;
    int o1,o2,o3,o4;
    int pwins, owins, alert, tokencount=0;
    int winner =3;
    //boolean opp, play =true;

    //Dialog Context View
    final Context context = this;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //runplayer();
        final TextView pscore;
        final TextView oscore;
        //TextView
        pscore = (TextView) findViewById(R.id.pscore);
        oscore = (TextView) findViewById(R.id.oscore);
        final TextView pwin;
        final TextView owin;
        pwin = (TextView) findViewById(R.id.pwins);
        owin = (TextView) findViewById(R.id.owins);
        //user selects tokens

        //input string
    /*    final EditText t1Edit,t2Edit,t3Edit,t4Edit;
        t1Edit   = (EditText)findViewById(R.id.toggleButton1);
        t2Edit   = (EditText)findViewById(R.id.toggleButton2);
        t3Edit   = (EditText)findViewById(R.id.toggleButton3);
        t4Edit   = (EditText)findViewById(R.id.toggleButton4);
       final TextView t1Text,t2Text,t3Text,t4Text;
        t1Text   = (TextView)findViewById(R.id.toggleButton1);
        t2Text   = (TextView)findViewById(R.id.toggleButton2);
        t3Text   = (TextView)findViewById(R.id.toggleButton3);
        t4Text   = (TextView)findViewById(R.id.toggleButton4);
*/
        //Button
        final Button endturn;
        final Button stand;
        endturn = (Button) findViewById(R.id.endturn);
        stand = (Button) findViewById(R.id.stand);

        final Button t1,t2,t3,t4;
        t1 = (Button) findViewById(R.id.toggleButton1);
        t2 = (Button) findViewById(R.id.toggleButton2);
        t3 = (Button) findViewById(R.id.toggleButton3);
        t4 = (Button) findViewById(R.id.toggleButton4);

        //The Game VVVVVVVVVVV
        //get and add token to player score
       if(pwins<=3 && owins<=3){ //manage rounds
            endturn.setText("Start");//initiate round
            stand.setText("Do not click");//initiate round
           pscore.setText("Player score: " + playerscore);
           oscore.setText("Opponent score: " + opponentscore);
           //comp set tokens
           if((pwins==0) && (owins==0)){
               t1val = getToken();
               t2val = getToken();
               t3val = getToken();
               t4val = getToken();
               o1= getToken();
               o2= getToken();
               o3= getToken();
               o4= getToken();
               t1.setText(""+t1val);
               t2.setText(""+t2val);
               t3.setText(""+t3val);
               t4.setText(""+t4val);
           }
            //User set tokens 1-10: t1, t2, t3, t4 :only for three rounds
          /* if(tokencount<4){
               int1 = t1Edit.getText().toString();
               tokencheck(int1);
               int2 = t2Edit.getText().toString();
               tokencheck(int2);
               int3 = t3Edit.getText().toString();
               tokencheck(int3);
               int4 = t4Edit.getText().toString();
               tokencheck(int4);
               t1Text.setText(t1Edit.getText().toString());
               t2Text.setText(t2Edit.getText().toString());
               t3Text.setText(t3Edit.getText().toString());
               t4Text.setText(t4Edit.getText().toString());
           }
           Button mButton;
           EditText mEdit;
           TextView mText;

           mEdit   = (EditText)findViewById(R.id.editText1);
           mEdit.getText().toString();
           And then, the instance of Textview is created to show the welcome message. This will be done by the following code.

           mText = (TextView)findViewById(R.id.textView1);
           mText.setText("Welcome "+mEdit.getText().toString()+"!");
*/         t1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //send value to score
                 playerscore+= t1val;
                 //toggle off
                 t1.setText("");
                 t1val = 0;
                 pscore.setText("Player score: " + playerscore);
             }
           });
           t2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   //send value to score
                   playerscore+= t2val;
                   //toggle off
                   t2.setText("");
                   t2val = 0;
                   pscore.setText("Player score: " + playerscore);
               }
           });
           t3.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   //send value to score
                   playerscore+= t3val;
                   //toggle off
                   t3.setText("");
                   t3val = 0;
                   pscore.setText("Player score: " + playerscore);
               }
           });
           t4.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   //send value to score
                   playerscore+= t4val;
                   //toggle off
                   t4.setText("");
                   t4val = 0;
                   pscore.setText("Player score: " + playerscore);
               }
           });

           endturn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   stand.setText("Stand");
                   endturn.setText("GetToken");
                   if (alert == 0) {//start of first round alert w/ rules
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
                   //deal player
                   playerscore = playerscore + getToken();
                   pscore.setText("Player score: " + playerscore);

                   //run opponent after endturn
                   if ((opponentscore <= 17) || ((opponentscore < playerscore) && (playerscore <= 20))) {
                       opponentscore = opponentscore + getToken();
                       //opponent may choose a card
                       if(opponentscore+o1==20){opponentscore+=o1;o1=0;}
                       if(opponentscore+o2==20){opponentscore+=o2;o2=0;}
                       if(opponentscore+o3==20){opponentscore+=o3;o3=0;}
                       if(opponentscore+o4==20){opponentscore+=o4;o4=0;}
                       if(opponentscore+o1==19){opponentscore+=o1;o1=0;}
                       if(opponentscore+o2==19){opponentscore+=o2;o2=0;}
                       if(opponentscore+o3==19){opponentscore+=o3;o3=0;}
                       if(opponentscore+o4==19){opponentscore+=o4;o4=0;}
                       oscore.setText("Opponent score: " + opponentscore);
                   }
                   //opponent wins after end turn
                   if ((opponentscore <= 20 && playerscore > 20)) {
                       endturn.setText("Start Round");
                       stand.setText("You lost");
                       owins++;
                       owin.setText("Opponent Wins: " + owins);
                       opponentscore = 0;
                       playerscore = 0;
                       pscore.setText("Player score: " + playerscore);
                       oscore.setText("Opponent score: " + opponentscore);
                   }
                   //Both lose
                   if ((opponentscore > 20 && playerscore > 20)||(opponentscore == 20 && playerscore == 20)) {
                       endturn.setText("Start Round");
                       stand.setText("Tie");
                       opponentscore = 0;
                       playerscore = 0;
                       pscore.setText("Player score: " + playerscore);
                       oscore.setText("Opponent score: " + opponentscore);
                   }
                   //activate round
                   //endturn.setText("EndTurn");
                   //stand.setText("Stand");
                   //reset
                   if (pwins == winner) {
                       owin.setText("Player Wins!!!!!!");
                       owins = 0;
                       pwins = 0;
                       opponentscore = 0;
                       playerscore = 0;
                       pwin.setText("Player Wins: " + pwins);
                       owin.setText("Opponent Wins: " + owins);
                       endturn.setText("Start Round");
                       stand.setText("You won");
                       alert = 0;
                   }
                   if (owins == winner) {
                       pwin.setText("Opponent Wins!!!!!!");
                       stand.setText("You lost");
                       owins = 0;
                       pwins = 0;
                       opponentscore = 0;
                       playerscore = 0;
                       pwin.setText("Player Wins: " + pwins);
                       owin.setText("Opponent Wins: " + owins);
                       endturn.setText("Start Round");
                       stand.setText("You lost");
                       alert = 0;
                   }
               }
           });

           stand.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    //Once player stands run the opponent
                    if((opponentscore<=17) || ((opponentscore < playerscore) && (opponentscore < 20)))
                    {   //opponent wins after player stands
                        if(opponentscore<=20 &&playerscore<opponentscore ){
                            endturn.setText("Start5");
                            owins++;
                            owin.setText("Opponent Wins: "+ owins);
                            opponentscore=0;
                            playerscore=0;
                            pscore.setText("Player score: " + playerscore);
                            oscore.setText("Opponent score: " + opponentscore);
                        }
                        opponentscore = opponentscore + getToken();
                        oscore.setText("Opponent score: " + opponentscore);
                        pscore.setText("Player score: " + playerscore);
                    }
                    //player wins
                    if((playerscore<=20 && opponentscore>20)||
                            (playerscore>opponentscore && playerscore<=20)){
                        endturn.setText("Start6");
                        pwins++;
                        pwin.setText("Player Wins: "+ pwins);
                        opponentscore=0;
                        playerscore=0;
                        pscore.setText("Player score: " + playerscore);
                        oscore.setText("Opponent score: " + opponentscore);
                    }
                    //opponent wins
                    if(((playerscore<opponentscore) && (opponentscore<=20))){
                        endturn.setText("Start");
                        owins++;
                        owin.setText("Opponent Wins: "+ owins);
                        opponentscore=0;
                        playerscore=0;
                        pscore.setText("Player score: " + playerscore);
                        oscore.setText("Opponent score: " + opponentscore);
                    }
                    //tie
                    if(((playerscore==20&&opponentscore==20) ||
                            (playerscore==19&&opponentscore==19) ||
                            (playerscore==18&&opponentscore==18) ||
                            (opponentscore>20&&playerscore>20))){
                        endturn.setText("Start22");
                        stand.setText("Tie");
                        opponentscore = 0;
                        playerscore = 0;
                        pscore.setText("Player score: " + playerscore);
                        oscore.setText("Opponent score: " + opponentscore);
                    }
                    //reset
                    if(pwins==winner){
                        owin.setText("Player Wins!!!!!!");
                        owins=0;
                        pwins = 0;
                        opponentscore=0;
                        playerscore=0;
                        pscore.setText("Player score: " + playerscore);
                        oscore.setText("Opponent score: " + opponentscore);
                        pwin.setText("Player Wins: "+ pwins);
                        endturn.setText("Start Round");
                        alert=0;
                    }
                    if(owins==winner) {
                        pwin.setText("Opponent Wins!!!!!!");
                        owins = 0;
                        pwins = 0;
                        opponentscore = 0;
                        playerscore = 0;
                        pscore.setText("Player score: " + playerscore);
                        oscore.setText("Opponent score: " + opponentscore);
                        owin.setText("Opponent Wins: " + owins);
                        endturn.setText("Start Round");
                        alert = 0;
                    }
                }
            });
    }
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
    //compares string values and if 1-10 saves to integer and incriments the token count
    /*
    public void tokencheck(String stringedInt){
        if(tokencount==0){tokencount++;
            if(stringedInt=="1"){t1val =1;}
            if(stringedInt=="2"){t1val =2;}
            if(stringedInt=="3"){t1val =3;}
            if(stringedInt=="4"){t1val =4;}
            if(stringedInt=="5"){t1val =5;}
            if(stringedInt=="6"){t1val =6;}
            if(stringedInt=="7"){t1val =7;}
            if(stringedInt=="8"){ t1val =8;}
            if(stringedInt=="9"){t1val =9;}
            if(stringedInt=="10"){t1val =10;}
            else{tokencount--;}
        }
        if(tokencount==1){tokencount++;
            if(stringedInt=="1"){t2val =1;}
            if(stringedInt=="2"){t2val =2;}
            if(stringedInt=="3"){t2val =3;}
            if(stringedInt=="4"){t2val =4;}
            if(stringedInt=="5"){t2val =5;}
            if(stringedInt=="6"){t2val =6;}
            if(stringedInt=="7"){t2val =7;}
            if(stringedInt=="8"){t2val =8;}
            if(stringedInt=="9"){t2val =9;}
            if(stringedInt=="10"){t2val =10;}
            else{tokencount--;}}
        if(tokencount==2){tokencount++;
            if(stringedInt=="1"){t3val =1;}
            if(stringedInt=="2"){t3val =2;}
            if(stringedInt=="3"){t3val =3;}
            if(stringedInt=="4"){t3val =4;}
            if(stringedInt=="5"){ t3val =5;}
            if(stringedInt=="6"){t3val =6;}
            if(stringedInt=="7"){t3val =7;}
            if(stringedInt=="8"){t3val =8;}
            if(stringedInt=="9"){t3val =9;}
            if(stringedInt=="10"){t3val =10;}
            else{tokencount--;}}
        if(tokencount==3){ tokencount++;
            if(stringedInt=="1"){ t4val =1;}
            if(stringedInt=="2"){ t4val =2;}
            if(stringedInt=="3"){ t4val =3;}
            if(stringedInt=="4"){ t4val =4;}
            if(stringedInt=="5"){t4val =5;}
            if(stringedInt=="6"){t4val =6;}
            if(stringedInt=="7"){t4val =7;}
            if(stringedInt=="8"){t4val =8;}
            if(stringedInt=="9"){t4val =9;}
            if(stringedInt=="10"){t4val =10;}
            else{tokencount--;}}
    }*/
}
