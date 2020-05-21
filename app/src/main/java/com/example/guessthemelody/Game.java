package com.example.guessthemelody;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    Button play;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button buttonPlayer1;
    Button buttonPlayer2;

    String playerAnswe; //кто отвечает
    String playerAnswer; // ответ
    String correctAnswer; // правильный ответ

    ArrayList<Button> buttonsArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        //Разворот экрана на всю
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

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
        final MediaPlayer mediaPlayer = MediaPlayer.create(Game.this, R.raw.avgust);


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
        final ArrayList<Melody> melody = db.getData(1);

        // первый игрок
        buttonPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPlayer2.setEnabled(false); // отключаем кнопку другому игроку
                playerAnswe = "1";

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
                playerAnswe = "1";

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
                    Toast.makeText(getApplicationContext(), "Правильно", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Не правильно", Toast.LENGTH_LONG).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAnswer = button2.getText().toString();

                if(playerAnswer == correctAnswer){
                    Toast.makeText(getApplicationContext(), "Правильно", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Не правильно", Toast.LENGTH_LONG).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAnswer = button3.getText().toString();

                if(playerAnswer == correctAnswer){
                    Toast.makeText(getApplicationContext(), "Правильно", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Не правильно", Toast.LENGTH_LONG).show();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAnswer = button4.getText().toString();

                if(playerAnswer == correctAnswer){
                    Toast.makeText(getApplicationContext(), "Правильно", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Не правильно", Toast.LENGTH_LONG).show();
                }
            }
        });

        db.close();
    }
}
