package com.example.dell_lucas.tcc;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ActivityMain extends AppCompatActivity {
    private boolean statusConexão = false;
    private ProgressBar progressBarMain;
    private String ip = null;
    private ConstraintLayout LayoutDeck;
    private Button bt1, bt2, bt3, bt4, bt5,
            bt6, bt7, bt8, bt9, bt10,
            bt11, bt12, bt13, bt14, bt15;
    RealizaConexao realizaConexao = new RealizaConexao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        LayoutDeck.setVisibility(View.GONE);

        Intent intent = getIntent();
        if((this.ip = intent.getStringExtra("ip")) != null) {
            Log.i("retorno", "sucesso: " + this.ip);
            conexao();
            new CountDownTimer(1000, 1) {
                @Override
                public void onTick(long millisUntilFinished) {
                }
                @Override
                public void onFinish() {
                    if(realizaConexao.getStatusConexao(equals(true))){
                        progressBarMain.setVisibility(View.GONE);
                        LayoutDeck.setVisibility(View.VISIBLE);
                    }else{
                        openActivityCD();
                    }
                }
            }.start();
        }else{
            openActivityCD();
        }
    }

    public void iniciarComponentes(){
        progressBarMain  = findViewById(R.id.progressBarMain);
        LayoutDeck = findViewById(R.id.LayoutDeck);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        bt3=findViewById(R.id.bt3);
        bt4=findViewById(R.id.bt4);
        bt5=findViewById(R.id.bt5);
        bt6=findViewById(R.id.bt6);
        bt7=findViewById(R.id.bt7);
        bt8=findViewById(R.id.bt8);
        bt9=findViewById(R.id.bt9);
        bt10=findViewById(R.id.bt10);
        bt11=findViewById(R.id.bt11);
        bt12=findViewById(R.id.bt12);
        bt13=findViewById(R.id.bt13);
        bt14=findViewById(R.id.bt14);
        bt15=findViewById(R.id.bt15);
    }

    public void openActivityCD(){
        finish();
    }

    public void teste(View view){
        Log.i("Teste", "Context:"+view.getId());
    }

    public void conexao(){
        realizaConexao.setIp(this.ip);
        realizaConexao.start();
    }

    public void funcBt1(View view){
        realizaConexao.setRecebedorMensagem("1");
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        Intent intent = getIntent();
//        if((this.ip = intent.getStringExtra("ip")) != null) {
//            Log.i("retorno", "sucesso: " + this.ip);
//            conexao();
//            new CountDownTimer(1000, 1) {
//                @Override
//                public void onTick(long millisUntilFinished) {
//                }
//                @Override
//                public void onFinish() {
//                    if(realizaConexao.getStatusConexao(equals(true))){
//                        progressBarMain.setVisibility(View.GONE);
//                        LayoutDeck.setVisibility(View.VISIBLE);
//                    }else{
//                        openActivityCD();
//                    }
//                }
//            }.start();
//        }else{
//            openActivityCD();
//        }
//    }
    ////
    public void funcBt2(View view){
        realizaConexao.setRecebedorMensagem("2");
    }
    public void funcBt3(View view){
        realizaConexao.setRecebedorMensagem("3");
    }
    public void funcBt4(View view){
        realizaConexao.setRecebedorMensagem("4");
    }
    public void funcBt5(View view){
        realizaConexao.setRecebedorMensagem("5");
    }
    public void funcBt6(View view){
        realizaConexao.setRecebedorMensagem("6");
    }
    public void funcBt7(View view){
        realizaConexao.setRecebedorMensagem("7");
    }
    public void funcBt8(View view){
        realizaConexao.setRecebedorMensagem("8");
    }
    public void funcBt9(View view){
        realizaConexao.setRecebedorMensagem("9");
    }
    public void funcBt10(View view){
        realizaConexao.setRecebedorMensagem("10");
    }
    public void funcBt11(View view){
        realizaConexao.setRecebedorMensagem("11");
    }
    public void funcBt12(View view){
        realizaConexao.setRecebedorMensagem("12");
    }
    public void funcBt13(View view){
        realizaConexao.setRecebedorMensagem("13");
    }
    public void funcBt14(View view){
        realizaConexao.setRecebedorMensagem("14");
    }
    public void funcBt15(View view){
        realizaConexao.setRecebedorMensagem("15");
    }
}
