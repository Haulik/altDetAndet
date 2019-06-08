package com.company.Person1;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ChatServer {
    Map<Socket, DataOutputStream> map = new HashMap<>();


    public static void main(String[] args) {
/*       if(args.length > 0) {
       }
       }
           if(args[0].equals("server")){

           }else

    {
    }*/
        new ChatServer().runServer();
    }


    private synchronized void broadcastToClients(String message) {
        for (Map.Entry<Socket, DataOutputStream> entry : map.entrySet()) {
            try {
                entry.getValue().writeBytes(message);
                entry.getValue().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void runServer() {
        try(ServerSocket serverSocket = new ServerSocket(1337)) {
            while (true) {
                Socket socket = serverSocket.accept(); //blokere
                map.put(socket, new DataOutputStream(socket.getOutputStream()));
                // socket skal lægges i en tråd
                System.out.println("Forbundet til Klient");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
                //map.put(socket, DataOutputStream);
                //lyt til Klient:
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public class ClientHandler implements Runnable {
        Socket socket;

        public ClientHandler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try (Scanner scanner = new Scanner(socket.getInputStream())) {
                while (true) {
                    String line = scanner.nextLine();

                    System.out.println(line); // blokerer

                    //broadcastToClients(line);
                }
            } catch (Exception e) {

            }
        }
    }
}








