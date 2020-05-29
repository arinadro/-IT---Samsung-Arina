package com.example.guessthemelody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Level3 extends AppCompatActivity {

    TextView textView1;
    TextView textView2;

    TextView textViewscore1;
    TextView textViewscore2;
    Button play;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button buttonPlayer1;
    Button buttonPlayer2;

    int whoAnswe; //кто отвечает
    String playerAnswer; // ответ
    String correctAnswer; // правильный ответ
    public int countplayer1;
    public int countplayer2;



    ArrayList<Button> buttonsArr = new ArrayList<>();


    // метод для простановки баллов и перехода к следующему экрану
    public void setBal(int countplayer1, int countplayer2){
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("countplayer1", countplayer1);
        intent.putExtra("countplayer2", countplayer2);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2);
        //Разворот экрана на всю
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Bundle arguments = getIntent().getExtras();
        countplayer1 = arguments.getInt("countplayer1");
        countplayer2 = arguments.getInt("countplayer2");

        textViewscore1 = (TextView) findViewById(R.id.score1);
        textViewscore2 = (TextView) findViewById(R.id.score2);

        textViewscore1.setText(String.valueOf(countplayer1));
        textViewscore2.setText(String.valueOf(countplayer2));


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        buttonsArr.add(button1);
        buttonsArr.add(button2);
        buttonsArr.add(button3);
        buttonsArr.add(button4);

        for(int i = 0; i < buttonsArr.size(); i++){
            buttonsArr.get(i).setEnabled(false);
        }

        buttonPlayer1 = (Button) findViewById(R.id.buttonPlayer1);
        buttonPlayer2 = (Button) findViewById(R.id.buttonPlayer2);

        play = (Button) findViewById(R.id.play);
        final MediaPlayer mediaPlayer = MediaPlayer.create(Level3.this, R.raw.senorita);


        play.setOnClickListener(new View.OnClickListener() {
            int playCountClick = 1;
            @Override
            public void onClick(View v) {
                if(playCountClick % 2 == 0){
                    mediaPlayer.stop();
                } else {
                    mediaPlayer.start();
                }
                playCountClick++;
            }
        });

        DBHelper db = new DBHelper(this);

        // загрузка из бд для 2 уровня
        final ArrayList<Melody> melody = db.getData(3);

        // первый игрок
        buttonPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPlayer2.setEnabled(false); // отключаем кнопку другому игроку
                whoAnswe = 1;

                for(int i = 0; i < buttonsArr.size(); i++){
                    buttonsArr.get(i).setEnabled(true);
                }

                for(int i = 0; i < melody.size(); i++){
                    buttonsArr.get(i).setText(melody.get(i).getName());
                    if(melody.get(i).getAnswe() == 1){
                        correctAnswer = melody.get(i).getName();
                    }
                }
            }
        });

        // второй игрок
        buttonPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPlayer1.setEnabled(false); // отключаем кнопку другому игроку
                whoAnswe = 2;

                for(int i = 0; i < buttonsArr.size(); i++){
                    buttonsArr.get(i).setEnabled(true);
                }

                for(int i = 0; i < melody.size(); i++){
                    buttonsArr.get(i).setText(melody.get(i).getName());
                    if(melody.get(i).getAnswe() == 1){
                        correctAnswer = melody.get(i).getName();
                    }
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAnswer = button1.getText().toString();

                if(playerAnswer == correctAnswer){
                    if(whoAnswe == 1){
                        countplayer1 = countplayer1 + 5;
                    } else {
                        countplayer2 = countplayer2 + 5;
                    }
                } else {
                    if(whoAnswe == 1){
                        countplayer1 = countplayer1 - 5;
                    } else {
                        countplayer2 = countplayer2 - 5;
                    }
                }
                // простановка баллов и переход к следующему экрану
                setBal(countplayer1, countplayer2);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAnswer = button2.getText().toString();

                if(playerAnswer == correctAnswer){
                    if(whoAnswe == 1){
                        countplayer1 = countplayer1 + 5;
                    } else {
                        countplayer2 = countplayer2 + 5;
                    }
                } else {
                    if(whoAnswe == 1){
                        countplayer1 = countplayer1 - 5;
                    } else {
                        countplayer2 = countplayer2 - 5;
                    }
                }
                // простановка баллов и переход к следующему экрану
                setBal(countplayer1, countplayer2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAnswer = button3.getText().toString();

                if(playerAnswer == correctAnswer){
                    if(whoAnswe == 1){
                        countplayer1 = countplayer1 + 5;
                    } else {
                        countplayer2 = countplayer2 + 5;
                    }
                } else {
                    if(whoAnswe == 1){
                        countplayer1 = countplayer1 - 5;
                    } else {
                        countplayer2 = countplayer2 - 5;
                    }
                }
                // простановка баллов и переход к следующему экрану
                setBal(countplayer1, countplayer2);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAnswer = button4.getText().toString();

                if(playerAnswer == correctAnswer){
                    if(whoAnswe == 1){
                        countplayer1 = countplayer1 + 5;
                    } else {
                        countplayer2 = countplayer2 + 5;
                    }
                } else {
                    if(whoAnswe == 1){
                        countplayer1 = countplayer1 - 5;
                    } else {
                        countplayer2 = countplayer2 - 5;
                    }
                }
                // простановка баллов и переход к следующему экрану
                setBal(countplayer1, countplayer2);
            }
        });

        db.close();
    }
}