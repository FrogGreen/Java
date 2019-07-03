//Java NIO read and write file

package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //First method to read and write file with NIO
        try {
            Path localFile1 = FileSystems.getDefault().getPath("localFile1.txt");
            long lineCountLocalFile1 = Files.lines(localFile1).count();
            Files.write(localFile1, ("\nLine number " + (lineCountLocalFile1 + 1)).getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> eachLinesLocalFile1 = Files.readAllLines(localFile1);
            for (String lineLocalFile1 : eachLinesLocalFile1) {
                System.out.println(lineLocalFile1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished reading and writing localFile1\n");
        }

        //Second method to read and write file with NIO
        try (FileOutputStream localFile2Write = new FileOutputStream("localFile2.dat")) {
            FileChannel localFile2ChannelWrite = localFile2Write.getChannel();

            byte[] localFile2Bytes = "This is localFile2 message.".getBytes();
            ByteBuffer localFile2Buffer = ByteBuffer.wrap(localFile2Bytes);
            int localFile2BytesNumber = localFile2ChannelWrite.write(localFile2Buffer);
            System.out.println("Written bytes number was: " + localFile2BytesNumber);

            System.out.println("First method to return localFile2Buffer value: " + new String(localFile2Bytes));

            if (localFile2Buffer.hasArray()) {
                System.out.println("Second method to return localFile2Buffer value: " + new String(localFile2Buffer.array()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished reading and writing localFile2\n");
        }

        //Third method to read and write file with NIO
        try (FileOutputStream localFile3Write = new FileOutputStream("localFile3.dat")) {
            FileChannel localFile3ChannelWrite = localFile3Write.getChannel();

            ByteBuffer intLocalFile3Buffer = ByteBuffer.allocate(5 * Integer.BYTES);
            intLocalFile3Buffer.putInt(76);
            intLocalFile3Buffer.putInt(77);
            intLocalFile3Buffer.putInt(78);
            intLocalFile3Buffer.putInt(79);
            intLocalFile3Buffer.putInt(80);
            intLocalFile3Buffer.flip();
            int localFile3BytesNumber = localFile3ChannelWrite.write(intLocalFile3Buffer);
            System.out.println("Written bytes number was: " + localFile3BytesNumber);

            intLocalFile3Buffer.flip();
            intLocalFile3Buffer.putInt(81);
            intLocalFile3Buffer.putInt(82);
            intLocalFile3Buffer.putInt(83);
            intLocalFile3Buffer.putInt(84);
            intLocalFile3Buffer.putInt(85);
            intLocalFile3Buffer.flip();
            localFile3BytesNumber = localFile3ChannelWrite.write(intLocalFile3Buffer);
            System.out.println("Written bytes number was: " + localFile3BytesNumber);

            RandomAccessFile localFile3RandomAccess = new RandomAccessFile("localFile3.dat", "rwd");
            FileChannel localFile3ChannelRead = localFile3RandomAccess.getChannel();

            //Relative read
            System.out.println("First method to return intLocalFile3Buffer value:");
            intLocalFile3Buffer.flip();
            long localFile3BytesNumberRead = localFile3ChannelRead.read(intLocalFile3Buffer);
            intLocalFile3Buffer.flip();
            System.out.println(intLocalFile3Buffer.getInt());
            System.out.println(intLocalFile3Buffer.getInt());
            System.out.println(intLocalFile3Buffer.getInt());
            intLocalFile3Buffer.flip();

            //Absolute read
            System.out.println("Second method to return intLocalFile3Buffer value:");
            localFile3BytesNumberRead = localFile3ChannelRead.read(intLocalFile3Buffer);
            System.out.println(intLocalFile3Buffer.getInt(0));
            System.out.println(intLocalFile3Buffer.getInt(4));
            System.out.println(intLocalFile3Buffer.getInt(8));
            intLocalFile3Buffer.flip();
            localFile3BytesNumberRead = localFile3ChannelRead.read(intLocalFile3Buffer);
            System.out.println(intLocalFile3Buffer.getInt(0));

            localFile3ChannelRead.close();
            localFile3RandomAccess.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished reading and writing localFile3\n");
        }

        //Fourth method to read and write file with NIO
        try (FileOutputStream localFile4Write = new FileOutputStream("localFile4.dat")) {
            FileChannel localFile4ChannelWrite = localFile4Write.getChannel();

            ByteBuffer localFile4ChannelWriteBuffer = ByteBuffer.allocate(150);
            ByteBuffer localFile4ChannelReadBuffer = ByteBuffer.allocate(150);

            byte[] localFile4Bytes1 = "This is localFile4 first message.".getBytes();
            byte[] localFile4Bytes2 = "This is localFile4 second message.".getBytes();
            localFile4ChannelWriteBuffer.put(localFile4Bytes1);
            localFile4ChannelWriteBuffer.putInt(76);
            localFile4ChannelWriteBuffer.putInt(77);
            localFile4ChannelWriteBuffer.putInt(78).putInt(79).put(localFile4Bytes2);
            localFile4ChannelWriteBuffer.putInt(88);
            localFile4ChannelWriteBuffer.flip();
            localFile4ChannelWrite.write(localFile4ChannelWriteBuffer);

            RandomAccessFile localFile4RandomAccess = new RandomAccessFile("localFile4.dat", "rwd");
            FileChannel localFile4ChannelRead = localFile4RandomAccess.getChannel();

            localFile4ChannelRead.read(localFile4ChannelReadBuffer);
            localFile4ChannelReadBuffer.flip();

            byte[] inputLocalFile4Bytes1 = new byte[localFile4Bytes1.length];
            byte[] inputLocalFile4Bytes2 = new byte[localFile4Bytes2.length];

            localFile4ChannelReadBuffer.get(inputLocalFile4Bytes1);
            System.out.println(new String(inputLocalFile4Bytes1));
            System.out.println(localFile4ChannelReadBuffer.getInt());
            System.out.println(localFile4ChannelReadBuffer.getInt());
            System.out.println(localFile4ChannelReadBuffer.getInt());
            System.out.println(localFile4ChannelReadBuffer.getInt());
            localFile4ChannelReadBuffer.get(inputLocalFile4Bytes2);
            System.out.println(new String(inputLocalFile4Bytes2));
            System.out.println(localFile4ChannelReadBuffer.getInt());

            localFile4ChannelRead.close();
            localFile4RandomAccess.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished reading and writing localFile4\n");
        }

        //Fifth method to read and write file with NIO
        try (FileOutputStream localFile5Write = new FileOutputStream("localFile5.dat")) {
            FileChannel localFile5ChannelWrite = localFile5Write.getChannel();

            ByteBuffer localFile5ChannelWriteBuffer = ByteBuffer.allocate(150);
            ByteBuffer localFile5ChannelReadBuffer = ByteBuffer.allocate(Integer.BYTES);

            byte[] localFile5Bytes1 = "This is localFile5 first message.".getBytes();
            byte[] localFile5Bytes2 = "This is localFile5 second message.".getBytes();
            localFile5ChannelWriteBuffer.put(localFile5Bytes1);
            long localFile5Num1Pos = localFile5Bytes1.length;
            localFile5ChannelWriteBuffer.putInt(76);
            long localFile5Num2Pos = localFile5Num1Pos + Integer.BYTES;
            localFile5ChannelWriteBuffer.putInt(77);
            long localFile5Num3Pos = localFile5Num2Pos + Integer.BYTES;
            localFile5ChannelWriteBuffer.putInt(78);
            long localFile5Num4Pos = localFile5Num3Pos + Integer.BYTES;
            localFile5ChannelWriteBuffer.putInt(79);
            localFile5ChannelWriteBuffer.put(localFile5Bytes2);
            long localFile5Num5Pos = localFile5Num4Pos + Integer.BYTES + localFile5Bytes2.length;
            localFile5ChannelWriteBuffer.putInt(88);
            localFile5ChannelWriteBuffer.flip();
            localFile5ChannelWrite.write(localFile5ChannelWriteBuffer);

            RandomAccessFile localFile5RandomAccess = new RandomAccessFile("localFile5.dat", "rwd");
            FileChannel localFile5ChannelRead = localFile5RandomAccess.getChannel();

            localFile5ChannelRead.position(localFile5Num5Pos);
            localFile5ChannelRead.read(localFile5ChannelReadBuffer);
            localFile5ChannelReadBuffer.flip();
            System.out.println(localFile5ChannelReadBuffer.getInt());

            localFile5ChannelReadBuffer.flip();
            localFile5ChannelRead.position(localFile5Num4Pos);
            localFile5ChannelRead.read(localFile5ChannelReadBuffer);
            localFile5ChannelReadBuffer.flip();
            System.out.println(localFile5ChannelReadBuffer.getInt());

            localFile5ChannelReadBuffer.flip();
            localFile5ChannelRead.position(localFile5Num3Pos);
            localFile5ChannelRead.read(localFile5ChannelReadBuffer);
            localFile5ChannelReadBuffer.flip();
            System.out.println(localFile5ChannelReadBuffer.getInt());

            localFile5ChannelReadBuffer.flip();
            localFile5ChannelRead.position(localFile5Num2Pos);
            localFile5ChannelRead.read(localFile5ChannelReadBuffer);
            localFile5ChannelReadBuffer.flip();
            System.out.println(localFile5ChannelReadBuffer.getInt());

            localFile5ChannelReadBuffer.flip();
            localFile5ChannelRead.position(localFile5Num1Pos);
            localFile5ChannelRead.read(localFile5ChannelReadBuffer);
            localFile5ChannelReadBuffer.flip();
            System.out.println(localFile5ChannelReadBuffer.getInt());

            localFile5ChannelRead.close();
            localFile5RandomAccess.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished reading and writing localFile5\n");
        }

        //Sixth method to read and write file with NIO
        try (FileOutputStream localFile6Write = new FileOutputStream("localFile6.dat")) {
            FileChannel localFile6ChannelWrite = localFile6Write.getChannel();

            ByteBuffer localFile6Buffer = ByteBuffer.allocate(150);
            ByteBuffer localFile6IntBuffer = ByteBuffer.allocate(Integer.BYTES);

            byte[] localFile6Bytes1 = "This is localFile6 first message.".getBytes();
            long localFile6Bytes1Pos = 0;

            int localFile6Num1 = 76;
            long localFile6Num1Pos = localFile6Bytes1.length;

            int localFile6Num2 = 77;
            long localFile6Num2Pos = localFile6Num1Pos + Integer.BYTES;

            int localFile6Num3 = 78;
            long localFile6Num3Pos = localFile6Num2Pos + Integer.BYTES;

            int localFile6Num4 = 79;
            long localFile6Num4Pos = localFile6Num3Pos + Integer.BYTES;

            byte[] localFile6Bytes2 = "This is localFile6 second message.".getBytes();
            long localFile6Bytes2Pos = localFile6Num4Pos + Integer.BYTES;

            int localFile6Num5 = 88;
            long localFile6Num5Pos = localFile6Bytes2Pos + localFile6Bytes2.length;

            localFile6IntBuffer.putInt(localFile6Num1);
            localFile6IntBuffer.flip();
            localFile6ChannelWrite.position(localFile6Num1Pos);
            localFile6ChannelWrite.write(localFile6IntBuffer);

            localFile6IntBuffer.flip();
            localFile6IntBuffer.putInt(localFile6Num2);
            localFile6IntBuffer.flip();
            localFile6ChannelWrite.position(localFile6Num2Pos);
            localFile6ChannelWrite.write(localFile6IntBuffer);

            localFile6IntBuffer.flip();
            localFile6IntBuffer.putInt(localFile6Num3);
            localFile6IntBuffer.flip();
            localFile6ChannelWrite.position(localFile6Num3Pos);
            localFile6ChannelWrite.write(localFile6IntBuffer);

            localFile6IntBuffer.flip();
            localFile6IntBuffer.putInt(localFile6Num4);
            localFile6IntBuffer.flip();
            localFile6ChannelWrite.position(localFile6Num4Pos);
            localFile6ChannelWrite.write(localFile6IntBuffer);

            localFile6IntBuffer.flip();
            localFile6IntBuffer.putInt(localFile6Num5);
            localFile6IntBuffer.flip();
            localFile6ChannelWrite.position(localFile6Num5Pos);
            localFile6ChannelWrite.write(localFile6IntBuffer);

            localFile6ChannelWrite.position(localFile6Bytes1Pos);
            localFile6ChannelWrite.write(ByteBuffer.wrap(localFile6Bytes1));

            localFile6ChannelWrite.position(localFile6Bytes2Pos);
            localFile6ChannelWrite.write(ByteBuffer.wrap(localFile6Bytes2));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished reading and writing localFile6");
        }
    }
}
