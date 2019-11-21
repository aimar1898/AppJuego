package com.example.appjuego;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LevelActivity extends AppCompatActivity {

    private int lives;
    private String name, answer1, answer2;
    private TextView txtUser;
    private ImageView ivLives;
    private ImageView ivImage;
    private TextView txtAnswer;
    private Button btAnswer;
    private MediaPlayer mp;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        mp = MediaPlayer.create(this, R.raw.kraftwerk);
        mp.start();
        mp.setLooping(true);

        ivLives = findViewById(R.id.ivLives);
        ivImage = findViewById(R.id.ivImage);
        txtAnswer = findViewById(R.id.txtAnswer);
        btAnswer = findViewById(R.id.btAnswer);
        txtUser = findViewById(R.id.txtUser);
        ivLives.setImageResource(R.drawable.tresvidas);
        name = getIntent().getStringExtra("player");
        txtUser.setText("Player: "+name);
        //Inicializamos el nivel 1
        level = 1;
        lives = 3;
        //Cargamos nivel
        chargeLevel();

    }

    public void answer(View view) {

        if (!answer1.equals("")) {
            if (answer1.equals(txtAnswer.getText().toString()) || answer2.equals(txtAnswer.getText().toString())) {
                Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show();
                mp = MediaPlayer.create(this, R.raw.yay);
                mp.start();
                level++;
                chargeLevel();
            }
            else {
                mp = MediaPlayer.create(this , R.raw.no);
                mp.start();
                switch (lives) {
                    case 3: {
                        lives --;
                        ivLives.setImageResource(R.drawable.dosvidas);
                        break;
                    }
                    case 2: {
                        lives --;
                        ivLives.setImageResource(R.drawable.unavida);
                        break;
                    }
                    case 1: {
                        lives --;
                        Toast.makeText(this, "Eres muy malo", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
        else {
            Toast.makeText(this, "Escribe tu respuesta...", Toast.LENGTH_LONG).show();

        }

    }

    public void chargeLevel() {
        switch (level) {
            case 1: {
                ivImage.setImageResource(R.drawable.lillard);
                answer1 = "Damian Lillard";
                answer2 = "Lillard";
                break;
            }
            case 2: {
                ivImage.setImageResource(R.drawable.curry);
                answer1 = "Stephen Curry";
                answer2 = "Curry";
                break;
            }
            case 3: {
                ivImage.setImageResource(R.drawable.harden);
                answer1 = "James Harden";
                answer2 = "Harden";
                break;
            }
            case 4: {
                ivImage.setImageResource(R.drawable.nash);
                answer1 = "Steve Nash";
                answer2 = "Nash";
                break;
            }
            case 5: {
                ivImage.setImageResource(R.drawable.james);
                answer1 = "Lebron James";
                answer2 = "James";
                break;
            }
            case 6: {
                ivImage.setImageResource(R.drawable.durant);
                answer1 = "Kevin Durant";
                answer2 = "Durant";
                break;
            }
            case 7: {
                ivImage.setImageResource(R.drawable.kobe);
                answer1 = "Kobe Bryant";
                answer2 = "Bryant";
                break;
            }
            case 8: {
                ivImage.setImageResource(R.drawable.mike);
                answer1 = "Michael Jordan";
                answer2 = "Jordan";
                break;
            }
            case 9: {
                ivImage.setImageResource(R.drawable.irving);
                answer1 = "Kirye Irving";
                answer2 = "Irving";
                break;
            }
            case 10: {
                ivImage.setImageResource(R.drawable.george);
                answer1 = "Paul George";
                answer2 = "George";
                break;
            }
        }
    }
}
