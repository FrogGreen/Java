//Networking Programming - User Datagram Protocol - Server

package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import static java.lang.Thread.currentThread;

public class Main {

    public static void main(String[] args) {

        try {
            DatagramSocket datagramSocket = new DatagramSocket(7500);

            while (true) {
                byte[] byteBufferIn = new byte[50];
                DatagramPacket datagramPacket = new DatagramPacket(byteBufferIn, byteBufferIn.length);
                datagramSocket.receive(datagramPacket);
                System.out.println("Received from " + currentThread().getName() + " client the following message: " + new String(byteBufferIn, 0, datagramPacket.getLength()));

                String string = new String(byteBufferIn, 0, datagramPacket.getLength());
                byte[] byteBufferOut = string.getBytes();

                InetAddress inetAddress = datagramPacket.getAddress();
                int port = datagramPacket.getPort();
                datagramPacket = new DatagramPacket(byteBufferOut, byteBufferOut.length, inetAddress, port);
                datagramSocket.send(datagramPacket);
            }
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Something went wrong with server: " + e.getMessage());
        }
    }
}
