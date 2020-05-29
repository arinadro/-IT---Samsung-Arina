package com.example.guessthemelody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Results extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;

    public int countplayer1;
    public int countplayer2;
    TextView textView3;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);


        Bundle arguments = getIntent().getExtras();
        countplayer1 = arguments.getInt("countplayer1"); // результат 1 игрока
        countplayer2 = arguments.getInt("countplayer2");  // результат 2 игрока

        textView3 = (TextView) findViewById(R.id.textView3);

        if(countplayer1 > countplayer2){
            textView3.setText("Победил игрок №1");
        } else {
            textView3.setText("Победил игрок №2");
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnBack:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}