package com.example.guessthemelody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStart,btnParams,btnExit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnParams = (Button)findViewById(R.id.btnParams);
        btnExit = (Button)findViewById(R.id.btnExit);
    }

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
            public void onClick (View v){
              try {
                Intent intent = new Intent(MainActivity.this, Game.class);
                startActivity(intent);
                finish();
              } catch (Exception e) {

            }
        }
    };
}

