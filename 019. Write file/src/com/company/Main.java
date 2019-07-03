//Write file

package com.company;

import java.io.*;
import java.nio.file.*;

public class Main implements Serializable {

    public static void main(String[] args) throws IOException {

        //First method to write file
        FileWriter localFile1 = null;
        try {
            localFile1 = new FileWriter("localFile1.txt");
            for (int i = 0; i < 10; i++) {
                localFile1.write("localFile1, message" + i + "\r");
//          throw new IOException("Some IOException Sign");
            }
        } catch (IOException e) {
            System.out.println("FileWriter block exception.\n");
            e.printStackTrace();
        } finally {
            try {
                if (localFile1 != null) {
                    localFile1.close();
                    System.out.println("Closing file.");
                }
            } catch (IOException e) {
                System.out.println("Error during closing file!");
            }
            System.out.println("Writing localFile1 finished!\n");
        }

        //Second method to write file
        try (FileWriter localFile2 = new FileWriter("localFile2.txt")) {
            for (int i = 0; i < 10; i++) {
                localFile2.write("localFile2, message" + i + "\n");
            }
        } finally {
            System.out.println("Writing localFile2 finished!\n");
        }

        //Third method to write file
        try (BufferedWriter localFile3 = new BufferedWriter(new FileWriter("localFile3.txt"));
             BufferedWriter localFile4 = new BufferedWriter(new FileWriter("localFile4.txt"))) {
            for (int i = 0; i < 10; i++) {
                localFile3.write("localFile3, message" + i + "\n");
                localFile4.write("localFile4, message" + i + "\n");
            }
        } finally {
            System.out.println("Writing localFile3 finished!");
            System.out.println("Writing localFile4 finished!\n");
        }

        //Fourth method to write file
        try (DataOutputStream localFile5 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("localFile5.dat")))) {
            for (int i = 0; i < 10; i++) {
                localFile5.writeUTF("localFile5, message" + i);
            }
        } finally {
            System.out.println("Writing localFile5 finished!\n");
        }

        //Fifth method to write file
        long serialVersionUID = 1L;
        try (ObjectOutputStream localFile6 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("localFile6.dat")))) {
            for (int i = 0; i < 10; i++) {
                localFile6.writeObject("localFile6, message" + i);
            }
        } finally {
            System.out.println("Writing localFile6 finished!\n");
        }

        //Sixth method to write file
        try (RandomAccessFile localFile7 = new RandomAccessFile("localFile7.dat", "rwd")) {
            for (int i = 0; i < 10; i++) {
                localFile7.writeUTF("localFile7, message" + i);
            }
//            System.out.println("End file pointer is: " + localFile7.getFilePointer());
        } finally {
            System.out.println("Writing localFile7 finished!\n");
        }

        //Seventh method to write file
        try {
            Path localPath = FileSystems.getDefault().getPath("localFile8.txt");
            try (BufferedWriter localFile8 = Files.newBufferedWriter(localPath)) {
                for (int i = 0; i < 10; i++) {
                    localFile8.write("localFile8, message" + i + "\n");
                }
            }
        } finally {
            System.out.println("Writing localFile8 finished!\n");
        }

        //Eighth method to write file
        try {
            Path localPath = FileSystems.getDefault().getPath("localFile9.dat");
            try (ObjectOutputStream localFile9 = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(localPath)))) {
                for (int i = 0; i < 10; i++) {
                    localFile9.writeObject("localFile9, message" + i);
                }
            }
        } finally {
            System.out.println("Writing localFile9 finished!\n");
        }
    }
}
