package com.example.guessthemelody;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStart,btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);


        btnExit = (Button)findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    finish();
                }catch (Exception e){

                }
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DBHelper db = new DBHelper(this);

        ArrayList<Melody> melodies = new ArrayList<>();
        melodies.add(new Melody("Август", 1, 1));
        melodies.add(new Melody("Апрель", 0, 1));
        melodies.add(new Melody("Июнь", 0, 1));
        melodies.add(new Melody("Июль", 0, 1));
        melodies.add(new Melody("Ракета", 0, 2));
        melodies.add(new Melody("Монета", 0, 2));
        melodies.add(new Melody("Ко мне так", 0, 2));
        melodies.add(new Melody("Комета", 1, 2));
        melodies.add(new Melody("Worth It", 0, 3));
        melodies.add(new Melody("Havana", 0, 3));
        melodies.add(new Melody("Senorita", 1, 3));
        melodies.add(new Melody("Liar", 0, 3));

        db.insertData(melodies);
        //db.clear(); // Для очистки таблиц
        db.close();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnStart:
                intent = new Intent(this, Game.class);
                startActivity(intent);
                break;
        }
    }
}

