
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell-Lucas
 */
public class RealizaConexao extends Thread{
    
    public RealizaConexao(){
        
    }
    
    public void run(){
        try {
            ServerSocket socketServidor = new ServerSocket(8080, 40);
            String mensagemRecebida;
            String mensagemEnviada;


            while (true) {
                System.out.println("Esperando conexão...");
                try (Socket conexao = socketServidor.accept()) {
                    System.out.println("Conexão recebida: Cliente com IP: " + conexao.getInetAddress());

                    InputStream streamEntrada = conexao.getInputStream();
                    OutputStream streamSaida = conexao.getOutputStream();

                    BufferedReader entrada = new BufferedReader(new InputStreamReader(streamEntrada));
                    DataOutputStream saida = new DataOutputStream(streamSaida);

                    do {
                        mensagemRecebida = entrada.readLine();
                        if (mensagemRecebida != null) {
                            String comando = mensagemRecebida;
                               System.out.println(comando);
                            }

                    } while (!mensagemRecebida.equals("/sair"));
                }
            }
        } catch (IOException ex) {
            System.out.println("Erro!");
        }
    }
}
