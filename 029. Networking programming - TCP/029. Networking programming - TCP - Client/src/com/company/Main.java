//Networking Programming - Transmission Control Protocol - Client

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.0.1", 7500)) {
            socket.setSoTimeout(5000);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String string;
            String reply;

            do {
                System.out.println("Enter string to return: ");
                string = scanner.nextLine();
                printWriter.println(string);
                if (!string.equals("exit")) {
                    reply = bufferedReader.readLine();
                    System.out.println(reply);
                }
            } while (!string.equals("exit"));
        } catch (SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Something went wrong with client: " + e.getMessage());
        }
    }
}
