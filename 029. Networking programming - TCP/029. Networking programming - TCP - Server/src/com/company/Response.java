package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Response extends Thread {
    private Socket socket;

    public Response(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String string = bufferedReader.readLine();
                System.out.println("Received from " + currentThread().getName() + " client the following message: " + string);

                if (string.equals("exit")) {
                    break;
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
                printWriter.println(string);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong with server: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Something went wrong with server when closing: " + e.getMessage());
            }
        }
    }
}
