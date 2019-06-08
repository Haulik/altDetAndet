package com.company.Person1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {


    Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run()  {
        try (Scanner scanner = new Scanner(socket.getInputStream())){
            while (true){
                System.out.println(scanner.nextLine()); // blokerer
                //updateServer();
            }
        } catch (Exception e) {

        }

    }

}

