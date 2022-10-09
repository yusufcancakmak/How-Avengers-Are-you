package com.info.avengersuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class QuizActivity extends AppCompatActivity {
private TextView textViewDogru,textViewYanlıs,textViewSoruSayi;
private ImageView imageViewBayrak;
private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private ArrayList<Avengers> SorularListe;
    private ArrayList<Avengers> YanlısSeceneklerListe;
    private Avengers dogruSoru;
    private Veritabani vt;
    // Sayaç
    private int soruSayac=0;
    private int yanlısSayac=0;
    private int dogruSayac=0;
    //Seçenkleri
    private HashSet<Avengers> secenekleriKariştirmaListe = new HashSet<>();
    private ArrayList<Avengers> seceneklerListe = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewDogru=findViewById(R.id.textViewDogru);
        textViewYanlıs=findViewById(R.id.textViewYanlıs);
        textViewSoruSayi=findViewById(R.id.textViewSoruSayi);
        imageViewBayrak=findViewById(R.id.imageViewBayrak);
        buttonA=findViewById(R.id.buttonA);
        buttonB=findViewById(R.id.buttonB);
        buttonC=findViewById(R.id.buttonC);
        buttonD=findViewById(R.id.buttonD);

        vt= new Veritabani(this);
        SorularListe = new AvengersDao().rastgele5getir(vt);
        soruyukle();

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonA);
                sayacKontrol();
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonB);
                sayacKontrol();
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonC);
                sayacKontrol();
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonD);
                sayacKontrol();
            }
        });
    }
    public void soruyukle(){

        textViewSoruSayi.setText((soruSayac+1)+" . SORU");
        textViewDogru.setText("Doğru : " +(dogruSayac));
        textViewYanlıs.setText("Yanlış : "+(yanlısSayac));


        dogruSoru= SorularListe.get(soruSayac);
        YanlısSeceneklerListe = new AvengersDao().rastgele3YanlısSecenekGetir(vt,dogruSoru.getAvengers_id());
        imageViewBayrak.setImageResource(getResources().getIdentifier(dogruSoru.getAvengers_resim(),"drawable",getPackageName()));

        secenekleriKariştirmaListe.clear();
        secenekleriKariştirmaListe.add(dogruSoru);
        secenekleriKariştirmaListe.add(YanlısSeceneklerListe.get(0));
        secenekleriKariştirmaListe.add(YanlısSeceneklerListe.get(1));
        secenekleriKariştirmaListe.add(YanlısSeceneklerListe.get(2));

        seceneklerListe.clear();
        for (Avengers a :secenekleriKariştirmaListe){
            seceneklerListe.add(a);

        }
        buttonA.setText(seceneklerListe.get(0).getAvengers_ad());
        buttonB.setText(seceneklerListe.get(1).getAvengers_ad());
        buttonC.setText(seceneklerListe.get(2).getAvengers_ad());
        buttonD.setText(seceneklerListe.get(3).getAvengers_ad());



    }
    public  void dogruKontrol(Button button){
        String buttonYazi = button.getText().toString();
        String dogruCevap = dogruSoru.getAvengers_ad();
        if (buttonYazi.equals(dogruCevap)){
            dogruSayac++;

        }else {
            yanlısSayac++;

        }

        textViewDogru.setText("Doğru : " +(dogruSayac));
        textViewYanlıs.setText("Yanlış : "+(yanlısSayac));

    }
    public void sayacKontrol(){

        soruSayac++;
        if (soruSayac != 10){
            soruyukle();

        }else{
            Intent ıntent = new Intent(QuizActivity.this,SonucActivity.class);
            ıntent.putExtra("dogruSayac", dogruSayac);
            startActivity(ıntent);
            finish();
        }
    }
}