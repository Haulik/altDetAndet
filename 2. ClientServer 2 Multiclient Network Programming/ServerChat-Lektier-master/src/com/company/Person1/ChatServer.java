package com.company.Person1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;


public class ChatServer {


    public static void main(String[] args) {
        new ChatServer().runServer();

    }


    public void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(1337);
            Socket socket = serverSocket.accept(); // blokerer
            System.out.println("Forbundet til Klient 2");


            //send til klient
            //lyt til server
            Thread thread = new Thread(new ChatServer1_1());
            thread.start();

            //lyt til klient;
            try (Scanner scanner = new Scanner(socket.getInputStream())){
                while (true){
                    System.out.println(scanner.nextLine()); // blokerer

                }
            } catch (Exception e) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
