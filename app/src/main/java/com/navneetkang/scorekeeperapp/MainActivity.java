package com.navneetkang.scorekeeperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int countA=0;
    int countB=0;
    int scoreA=0;
    int scoreB=0;
    int score=0;
    TextView teamAScore;
    TextView teamBScore;
    RadioButton  wide,four,six;
    TextView result;
    TextView setRules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button activeTeamA=findViewById(R.id.active_teamA);
        final Button activeTeamB=findViewById(R.id.active_teamB);
        Button hitScore=findViewById(R.id.addSpecialScore);

        Button increaseScoreA=findViewById(R.id.team_a_increase);
        Button increaseScoreB=findViewById(R.id.team_b_increase);
        Button decreaseScoreA=findViewById(R.id.team_a_decrease);
        Button decreaseScoreB=findViewById(R.id.team_b_decrease);
        RadioGroup rg=findViewById(R.id.scoreChange);
        setRules=findViewById(R.id.setRules);
         wide=findViewById(R.id.score_1);
         four=findViewById(R.id.score_4);
        six=findViewById(R.id.score_6);

        teamAScore=findViewById(R.id.teamAScore);
        teamBScore=findViewById(R.id.teamBScore);
        result=findViewById(R.id.result);
        setRules.setText("CLICK + : FOR ADDING ONE SCORE\nCLICK - :FOR PENALTY OF 1 SCORE\n::::FOR SPECIAL HIT ::::\nACTIVATE THE TEAM FIRST\nTHEN CHOOSE THE HIT FOR SPECIAL SCORE");




        increaseScoreA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA+=1;
                update();

            }
        });
        increaseScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB+=1;
                update();
            }
        });

        decreaseScoreA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scoreA<=0)
                {
                    Toast.makeText(getApplicationContext(),"Score Cannot Be Below Zero!",Toast.LENGTH_LONG).show();
                    update();
                }
                else
                {
                    scoreA-=1;
                    update();
                }


            }
        });

        decreaseScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scoreB<=0)
                {
                    Toast.makeText(getApplicationContext(),"Score Cannot Be Below Zero!",Toast.LENGTH_LONG).show();
                    update();
                }
                else
                {
                    scoreB-=1;
                    update();
                }

            }
        });




        activeTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countA+=1;
                activeTeamA.setBackgroundColor(Color.parseColor("#ff7f50"));
                activeTeamA.setText("\uD83D\uDC49Team A Activated");

                activeTeamB.setBackgroundColor(Color.parseColor("#E8E8E8"));
                activeTeamB.setText("Activate Team B");
                result.setVisibility(View.VISIBLE);
                result.setText("Team A Got Activated For Special Score\nClick Activate Team B For Change");
                Toast.makeText(getApplicationContext(),"Team A Got Activated",Toast.LENGTH_LONG).show();
                countB=0;
            }
        });

        activeTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countB+=1;

                activeTeamB.setBackgroundColor(Color.parseColor("#ff7f50"));
                activeTeamB.setText("\uD83D\uDC49Team B Activated");

                activeTeamA.setBackgroundColor(Color.parseColor("#E8E8E8"));
                activeTeamA.setText("Activate Team A");

                result.setVisibility(View.VISIBLE);
                result.setText("Team B Got Activated For Special Score\nClick Activate Team  A For Change");
                Toast.makeText(getApplicationContext(),"Team B Got Activated",Toast.LENGTH_LONG).show();

                countA=0;
            }
        });




        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

                switch(id)
                {
                    case R.id.score_1:
                        score=1;
                        break;


                    case R.id.score_4:
                        score=4;
                        break;


                    case R.id.score_6:
                        score=6;
                        break;

                }
            }
        });





        hitScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(countA>0)
                {
                    if(score!=0)
                    {
                        scoreA+=score;
                        update();
                        score=0;
                    }
                    else
                    {
                       if(wide.isChecked())
                       {
                         scoreA+=1;
                         update();
                       }
                       else if(four.isChecked())
                       {
                           scoreA+=4;
                           update();

                       }
                       else if(six.isChecked())
                       {
                           scoreA+=6;
                           update();

                       }
                    }

                }
                else if(countB>0)
                {
                    if(score!=0)
                    {
                        scoreB+=score;
                        update();
                        score=0;
                    }
                    else
                    {
                        if(wide.isChecked())
                        {
                            scoreB+=1;
                            update();
                        }
                        else if(four.isChecked())
                        {
                            scoreB+=4;
                            update();

                        }
                        else if(six.isChecked())
                        {
                            scoreB+=6;
                            update();

                        }

                    }



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Activate The Team First For Special Score",Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    public void update()
    {

        teamAScore.setText(scoreA+"");
        teamBScore.setText(scoreB+"");

    }
}
