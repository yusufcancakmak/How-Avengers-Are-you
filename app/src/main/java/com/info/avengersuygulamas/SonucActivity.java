package com.info.avengersuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class SonucActivity extends AppCompatActivity {
private TextView textViewSonuc;
private TextView textViewYuzdeSonuc;
private Button buttonTekrar;
private int dogrusayac;
private Animation updowninfinte;
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        imageView=findViewById(R.id.imageView);
        textViewSonuc=findViewById(R.id.textViewSonuc);
        textViewYuzdeSonuc=findViewById(R.id.textViewYuzdeSonuc);
        buttonTekrar=findViewById(R.id.buttonTekrar);
        updowninfinte= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.updowninfinte);
        imageView.setAnimation(updowninfinte);

dogrusayac =getIntent().getIntExtra("dogruSayac",0);

textViewSonuc.setText(dogrusayac+ " Doğru "+(10-dogrusayac)+" Yanlış");
textViewYuzdeSonuc.setText("% "+(dogrusayac*100)/10+ " Başarı ");
        Snackbar.make(textViewYuzdeSonuc,"You are Great Avenger!",Snackbar.LENGTH_SHORT).show();
        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SonucActivity.this,QuizActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}