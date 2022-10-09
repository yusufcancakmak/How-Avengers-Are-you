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

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
private Button buttonBasla;
private Animation animationgiris;
private Animation animationikinci;
private TextView textviewgirisekrani;
private ImageView avengersresim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBasla=findViewById(R.id.buttonBasla);
        avengersresim=findViewById(R.id.avengersresim);
        textviewgirisekrani=findViewById(R.id.textviewgirisekrani);

        veritabaniKopyala();
animationikinci=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.updowntoscrenn);
animationgiris= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animgirisscreen);
buttonBasla.setAnimation(animationgiris);
avengersresim.setAnimation(animationikinci);
textviewgirisekrani.setAnimation(animationikinci);


        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yeniIntent = new Intent(MainActivity.this,QuizActivity.class);
                startActivity(yeniIntent);
            }
        });
    }
    public void veritabaniKopyala(){
        DatabaseCopyHelper helper=new DatabaseCopyHelper(this);


        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
helper.openDataBase();

    }
}