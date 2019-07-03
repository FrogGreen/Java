//Read file

package com.company;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) {

        Scanner scanner = null;

        //First method to read file
        try {
            scanner = new Scanner(new FileReader("localFile1.txt"));
            scanner.useDelimiter(", ");
            while (scanner.hasNextLine()) {
                String firstPart = scanner.next();
                scanner.skip(scanner.delimiter());
                String secondPart = scanner.nextLine();
                System.out.println(firstPart + ": " + secondPart);
            }
            System.out.println("Finished reading localFile1\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        //Second method to read file
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("localFile2.txt")));
            scanner.useDelimiter(", ");
            while (scanner.hasNextLine()) {
                String firstPart = scanner.next();
                scanner.skip(scanner.delimiter());
                String secondPart = scanner.nextLine();
                System.out.println(firstPart + ": " + secondPart);
            }
            System.out.println("Finished reading localFile2\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        //Third method to read file
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("localFile3.txt")));
            scanner.useDelimiter(", ");
            while (scanner.hasNextLine()) {
                String fileRead = scanner.nextLine();
                String data[] = fileRead.split(", ");
                String firstPart = data[0];
                String secondPart = data[1];
                System.out.println(firstPart + ": " + secondPart);
            }
            System.out.println("Finished reading localFile3\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        //Fourth method to read file
        try (BufferedReader localfile4 = new BufferedReader(new FileReader("localFile4.txt"))) {
            String fileRead;
            while ((fileRead = localfile4.readLine()) != null) {
                String data[] = fileRead.split(", ");
                String firstPart = data[0];
                String secondPart = data[1];
                System.out.println(firstPart + ": " + secondPart);
            }
            System.out.println("Finished reading localFile4\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Fifth method to read file
        try (DataInputStream localFile5 = new DataInputStream(new BufferedInputStream(new FileInputStream("localFile5.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    String data[] = localFile5.readUTF().split(", ");
                    String firstPart = data[0];
                    String secondPart = data[1];
                    System.out.println(firstPart + ": " + secondPart);
                } catch (EOFException e) {
                    eof = true;
                }
            }
            System.out.println("Finished reading localFile5\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Sixth method to read file
        long serialVersionUID = 1L;
        try (ObjectInputStream localFile6 = new ObjectInputStream(new BufferedInputStream(new FileInputStream("localFile6.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    String data[] = ((String) (localFile6.readObject())).split(", ");
                    String firstPart = data[0];
                    String secondPart = data[1];
                    System.out.println(firstPart + ": " + secondPart);
                } catch (EOFException e) {
                    eof = true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finished reading localFile6\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Seventh method to read file
        try (RandomAccessFile localFile7 = new RandomAccessFile("localFile7.dat", "rwd")) {
            localFile7.skipBytes(110);
            System.out.println(localFile7.readUTF());
            localFile7.seek(22);
            System.out.println(localFile7.readUTF());
            boolean eof = false;
            while (!eof) {
                try {
                    String data[] = ((localFile7.readUTF())).split(", ");
                    String firstPart = data[0];
                    String secondPart = data[1];
                    System.out.println(firstPart + ": " + secondPart);
                } catch (EOFException e) {
                    eof = true;
                }
            }
            System.out.println("Finished reading localFile7\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Eighth method to read file
        try {
            Path localPath = FileSystems.getDefault().getPath("localFile8.txt");
            String fileRead;
            BufferedReader localFile8 = Files.newBufferedReader(localPath);
            while ((fileRead = localFile8.readLine()) != null) {
                String data[] = (fileRead).split(", ");
                String firstPart = data[0];
                String secondPart = data[1];
                System.out.println(firstPart + ": " + secondPart);
            }
            System.out.println("Finished reading localFile8\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Ninth method to read file
        try {
            Path localPath = FileSystems.getDefault().getPath("localFile9.dat");
            try (ObjectInputStream localFile9 = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(localPath)))) {
                boolean eof = false;
                while (!eof) {
                    try {
                        String data[] = ((String) (localFile9.readObject())).split(", ");
                        String firstPart = data[0];
                        String secondPart = data[1];
                        System.out.println(firstPart + ": " + secondPart);
                    } catch (EOFException e) {
                        eof = true;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Finished reading localFile9\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
