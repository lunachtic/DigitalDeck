package com.example.dell_lucas.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class ActivityConectaDispositivo extends AppCompatActivity {
    private EditText lbIPServidor;
    private Button btEntrar;
    private ProgressBar progressBarConexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conecta_dispositivo);

        iniciarComponentes();
        progressBarConexao.setVisibility(View.GONE);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("ip", lbIPServidor.getText().toString());
                Intent i =  new Intent(ActivityConectaDispositivo.this, ActivityMain.class);
                i.putExtras(bundle);
                //i.putExtra("ip", lbIPServidor.getText().toString())
                startActivity(i);
                finish();
            }
        });

    }

    public String getIP(){
        return String.valueOf(lbIPServidor);
    }

    public void iniciarComponentes(){
        lbIPServidor        = findViewById(R.id.lbIPServidor);
        btEntrar            = findViewById(R.id.btEntrar);
        progressBarConexao  = findViewById(R.id.progressBarConexao);
    }

}
