package com.example.pedrapapeletesouro;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // ADIÇÃO: apenas para loop
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.veichines));
        videoView.setOnPreparedListener(mp -> mp.setLooping(true));
        videoView.start();
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResult = findViewById(R.id.textResult);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];
        System.out.println(opcaoApp);

        switch (opcaoApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
        }

        if((opcaoApp == "pedra" && opcaoSelecionada =="tesoura" )||
                (opcaoApp == "tesoura" && opcaoSelecionada =="papel")||
                (opcaoApp == "papel" && opcaoSelecionada =="pedra"))
        {
            textoResult.setText("O SITEMA GANHOU");

        }
        else if ((opcaoApp == "pedra" && opcaoSelecionada =="pedra" )||
                (opcaoApp == "tesoura" && opcaoSelecionada =="tesoura")||
                (opcaoApp == "papel" && opcaoSelecionada =="papel")){

            textoResult.setText("EMPATOU");
        }
        else{
            textoResult.setText("VOCÊ GANHOU");
        }
    }
}
