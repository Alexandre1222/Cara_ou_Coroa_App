package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class detalhe extends AppCompatActivity {
   private ImageView imagem, voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        View DecorView = getWindow().getDecorView();
        DecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE|
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_FULLSCREEN
        );

        imagem = (ImageView) findViewById(R.id.moedaId);
        voltar = (ImageView) findViewById(R.id.btnVoltar);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String moeda = bundle.getString("moeda");

            if (moeda.equals("cara")) {
                Toast.makeText(this, "PARABENS VC TIROU CARA", Toast.LENGTH_LONG).show();
                imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara));
            } else if (moeda.equals("coroa")) {
                Toast.makeText(this, "PARABENS VC TIROU COROA", Toast.LENGTH_LONG).show();
                imagem.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_coroa));
            }
        }

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detalhe.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}