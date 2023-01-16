package com.example.dell_lucas.tcc;

import android.os.SystemClock;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RealizaConexao extends Thread{
    String ip;
    boolean StatusConexao;
    String strRecebedorMensagem = null;

    public RealizaConexao() {
    }

    public void run() {
        try (Socket conexao = new Socket(this.ip, 8080)){
            this.setStatusConexao(true);
            String mensagemRecebida, mensagemEnviada;

            while (true) {

                InputStream streamEntrada = conexao.getInputStream();
                OutputStream streamSaida = conexao.getOutputStream();

                BufferedReader entrada = new BufferedReader(new InputStreamReader(streamEntrada));
                DataOutputStream saida = new DataOutputStream(streamSaida);

                do {

                    while(strRecebedorMensagem!=null) {
                        mensagemEnviada = this.strRecebedorMensagem;
                        saida.writeBytes(mensagemEnviada);
                        Log.i("teste", ":"+mensagemEnviada);
                        while (!entrada.ready()) {
                            SystemClock.sleep(100);
                            //System.out.println("Dormindoo!!");
                            strRecebedorMensagem=null;
                        }
                        while (entrada.ready()) {
                            mensagemRecebida = entrada.readLine();
                            Log.i("Conexão:", "VariavelRecebeMensagem:"+mensagemRecebida);
                        }
                    }
                } while (true);
            }
        } catch (IOException e) {
            setStatusConexao(false);
            Log.w("ERRROR", e.getMessage());
        }
    }

    public String getRecebedorMensagens(){
        if(this.strRecebedorMensagem==null){
            return null;
        }else{
            return this.strRecebedorMensagem;
        }
    }

    public void setRecebedorMensagem(String rMensagem){
        this.strRecebedorMensagem=rMensagem;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setStatusConexao(boolean statusconexao){
        this.StatusConexao=statusconexao;
    }

    public boolean getStatusConexao(boolean equals){
        return StatusConexao;
    }
}
