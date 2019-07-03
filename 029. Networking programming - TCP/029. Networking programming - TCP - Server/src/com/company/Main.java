//Networking Programming - Transmission Control Protocol - Server

package com.company;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(7500)) {
            while (true) {
                new Response(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
