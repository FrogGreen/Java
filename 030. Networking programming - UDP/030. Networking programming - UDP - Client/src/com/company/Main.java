//Networking Programming - User Datagram Protocol - Client

package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String string;

            do {
                System.out.println("Enter string to return: ");
                string = scanner.nextLine();

                byte[] byteBufferOut = string.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(byteBufferOut, byteBufferOut.length, inetAddress, 7500);
                datagramSocket.send(datagramPacket);

                byte[] byteBufferIn = new byte[50];
                datagramPacket = new DatagramPacket(byteBufferIn, byteBufferIn.length);
                datagramSocket.receive(datagramPacket);
                System.out.println(new String(byteBufferIn, 0, datagramPacket.getLength()));
            } while (!string.equals("exit"));
        } catch (SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Something went wrong with client: " + e.getMessage());
        }
    }
}
