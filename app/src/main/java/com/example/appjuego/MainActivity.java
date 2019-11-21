package com.example.appjuego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView mainImage;
    private Button btConfirm;
    private EditText txtUsername;
    private MediaPlayer mp;
    private int num_aleatorio = (int) (Math.random() * 10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainImage = findViewById(R.id.ivMainImage);
        btConfirm = findViewById(R.id.btConfirm);
        txtUsername = findViewById(R.id.txtUsername);

        mp = MediaPlayer.create(this, R.raw.movie);
        mp.start();
        mp.setLooping(true);

        //Establecemos el icono de la aplicación
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.icon);

        //Decidimos que foto vamos a usar
        if (num_aleatorio == 0) {
            mainImage.setImageResource(R.drawable.error);
        }
        if (num_aleatorio == 1) {
            mainImage.setImageResource(R.drawable.fallout4);
        }
        if (num_aleatorio == 2) {
            mainImage.setImageResource(R.drawable.skyrim);
        }
        if (num_aleatorio == 3) {
            mainImage.setImageResource(R.drawable.skyrim2);
        }
        if (num_aleatorio == 4) {
            mainImage.setImageResource(R.drawable.controller1);
        }
        if (num_aleatorio == 5) {
            mainImage.setImageResource(R.drawable.computer1);
        }
        if (num_aleatorio == 6) {
            mainImage.setImageResource(R.drawable.mobile);
        }
        if (num_aleatorio == 7) {
            mainImage.setImageResource(R.drawable.guitar1);
        }
        if (num_aleatorio == 8) {
            mainImage.setImageResource(R.drawable.error);
        }
        if (num_aleatorio == 9) {
            mainImage.setImageResource(R.drawable.error);
        }
    }

    public void play(View view) {
        String name = txtUsername.getText().toString();

        if (!name.equals("")) {
            mp.stop();
            mp.release();
            Intent intent = new Intent(this , LevelActivity.class);
            intent.putExtra("player" , name);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this , "Escribe tu nombre para comenzar...", Toast.LENGTH_LONG).show();
            txtUsername.requestFocus();
        }
    }
}
