package com.company.Person2;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient {
    public static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        new ChatClient().runClient();

    }

    public void runClient() {

        try {
            Socket socket = new Socket("localhost", 1337);
            System.out.println("Er forbundet til server1");

            //Thread thread = new Thread(new ChatServer());
           // thread.start();

            Scanner scanner = new Scanner(System.in);
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String line = scanner.nextLine();
                String line2 = null;
                //boolean run = true;
                if(line.startsWith("/")){

                        try {
                            if (line.toLowerCase().contains("/color ")) {
                                try {
                                    if (line.toLowerCase().contains("red ")) {
                                        line2 = ANSI_RED + line;
                                    }
                                    if (line.toLowerCase().contains("blue ")) {
                                        line2 = ANSI_BLUE + line;
                                    }
                                   // line = ANSI_RESET + line;
                                }catch (Exception e){
                                    System.out.println("Please type: color or quit after /");
                                }
                            }

                            if (line.toLowerCase().contains("/quit")) {
                                System.out.println("Goodbye");
                                dOut.writeBytes("client has left the server" + "\n");
                                dOut.writeBytes(line.replaceAll("/color "+"red ","").replaceAll("/color "+"blue ","").replaceAll("/quit","") + "\n");
                                dOut.flush();

                                System.exit(0);
                            }

                            dOut.writeBytes(line2.replaceAll("/color "+"red ","").replaceAll("/color "+"blue ","").replaceAll("/quit","") + "\n");
                            dOut.flush();



                        }catch (Exception e){
                            System.out.println("You can either type: Quit or Color [red or blue] after /");
                        }

                }else {
                    dOut.writeBytes(ANSI_RESET + line + "\n");

                    dOut.flush();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}