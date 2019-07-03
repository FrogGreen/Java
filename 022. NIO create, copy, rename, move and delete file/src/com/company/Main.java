//Java NIO create, copy, rename, move and delete file

package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {

        //Path
        Path path = Paths.get("C:\\Example\\Example.txt");
        System.out.println(path.toAbsolutePath());

        path = Paths.get(".");
        System.out.println(path.toAbsolutePath());

        path = FileSystems.getDefault().getPath("Example.txt");
        System.out.println(path.toAbsolutePath());

        path = FileSystems.getDefault().getPath("Example", "Example.txt");
        System.out.println(path.toAbsolutePath());

        path = Paths.get(".", "Example", "Example.txt");
        System.out.println(path.toAbsolutePath());

        path = Paths.get(".", "Example", "Example.txt");
        System.out.println(path.normalize().toAbsolutePath() + "\n");

        //Separator
        System.out.println(File.separator);
        System.out.println(FileSystems.getDefault().getSeparator() + "\n");

        //Create source file
        try (FileOutputStream sourceFile = new FileOutputStream("sourceFile.dat")) {
            FileChannel sourceFileChannel = sourceFile.getChannel();

            ByteBuffer sourceFileBuffer = ByteBuffer.allocate(150);

            byte[] sourceFileBytes1 = "This is sourceFile first message.".getBytes();
            byte[] sourceFileBytes2 = "This is sourceFile second message.".getBytes();
            sourceFileBuffer.put(sourceFileBytes1);
            long sourceFileNum1Pos = sourceFileBytes1.length;
            sourceFileBuffer.putInt(76);
            long sourceFileNum2Pos = sourceFileNum1Pos + Integer.BYTES;
            sourceFileBuffer.putInt(77);
            long sourceFileNum3Pos = sourceFileNum2Pos + Integer.BYTES;
            sourceFileBuffer.putInt(78);
            long sourceFileNum4Pos = sourceFileNum3Pos + Integer.BYTES;
            sourceFileBuffer.putInt(79);
            sourceFileBuffer.put(sourceFileBytes2);
            long sourceFileNum5Pos = sourceFileNum4Pos + Integer.BYTES + sourceFileBytes2.length;
            sourceFileBuffer.putInt(88);
            sourceFileBuffer.flip();
            sourceFileChannel.write(sourceFileBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished create sourceFile\n");
        }

        //First method to copy file
        try {
            RandomAccessFile sourceFileRandomAccess = new RandomAccessFile("sourceFile.dat", "rwd");
            FileChannel sourceFileChannelRead = sourceFileRandomAccess.getChannel();

            RandomAccessFile sourceFileCopy1 = new RandomAccessFile("sourceFileCopy1.dat", "rwd");
            FileChannel sourceFileCopy1Channel = sourceFileCopy1.getChannel();
            sourceFileChannelRead.position(0);
            long localFile1NumberTransferred = sourceFileCopy1Channel.transferFrom(sourceFileChannelRead, 0, sourceFileChannelRead.size());

            sourceFileCopy1.close();
            sourceFileRandomAccess.close();
            sourceFileCopy1Channel.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished copy sourceFile to sourceFileCopy1");
        }

        //Second method to copy file
        try {
            RandomAccessFile sourceFileRandomAccess = new RandomAccessFile("sourceFile.dat", "rwd");
            FileChannel sourceFileChannelRead = sourceFileRandomAccess.getChannel();

            RandomAccessFile sourceFileCopy2 = new RandomAccessFile("sourceFileCopy2.dat", "rwd");
            FileChannel sourceFileCopy2Channel = sourceFileCopy2.getChannel();
            long localFile2NumberTransferred = sourceFileChannelRead.transferTo(0, sourceFileChannelRead.size(), sourceFileCopy2Channel);

            sourceFileCopy2.close();
            sourceFileRandomAccess.close();
            sourceFileCopy2Channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished copy sourceFile to sourceFileCopy2");
        }

        //Third method to copy file
        try {
            RandomAccessFile sourceFileRandomAccess = new RandomAccessFile("sourceFile.dat", "rwd");
            FileChannel sourceFileChannelRead = sourceFileRandomAccess.getChannel();
            long sourceFileSize = sourceFileChannelRead.size();

            ByteBuffer sourceFileBuffer = ByteBuffer.allocate((int) sourceFileSize);
            sourceFileChannelRead.read(sourceFileBuffer);
            sourceFileBuffer.flip();

            Pipe sourceFilePipe = Pipe.open();

            Pipe.SinkChannel sinkChannel = sourceFilePipe.sink();
            while (sourceFileBuffer.hasRemaining()) {
                sinkChannel.write(sourceFileBuffer);
            }

            RandomAccessFile sourceFileCopy3 = new RandomAccessFile("sourceFileCopy3.dat", "rwd");
            FileChannel sourceFileCopy3Channel = sourceFileCopy3.getChannel();

            ByteBuffer sourceFileCopyBuffer = ByteBuffer.allocate((int) sourceFileSize);

            Pipe.SourceChannel sourceChannel = sourceFilePipe.source();
            sourceChannel.read(sourceFileCopyBuffer);
            sourceFileCopyBuffer.flip();
            sourceFileCopy3Channel.write(sourceFileCopyBuffer);

            sourceFileCopy3.close();
            sourceFileRandomAccess.close();
            sourceFileChannelRead.close();
            sourceFileCopy3Channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished copy sourceFile to sourceFileCopy3");
        }

        //Fourth method to copy file
        try {
            Path sourceFilePath = Paths.get("sourceFile.dat");
            Path sourceFileCopyPath = Paths.get("sourceFileCopy4.dat");

            if (!Files.exists(sourceFileCopyPath)) {
                Files.copy(sourceFilePath, sourceFileCopyPath);
            } else {
                System.out.println("File sourceFileCopy4 already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished copy sourceFile to sourceFileCopy4");
        }

        //Fifth method to copy file
        try {
            Path sourceFilePath = Paths.get("sourceFile.dat");
            Path sourceFileCopyPath = Paths.get("sourceFileCopy5.dat");

            Files.copy(sourceFilePath, sourceFileCopyPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished copy sourceFile to sourceFileCopy5\n");
        }

        //Create directory
        try {
            Path sourceFileToCreateDirectory = Paths.get("Create", "fileToCreate.dat");

            if (!Files.exists(sourceFileToCreateDirectory.getParent())) {
                Files.createDirectory(sourceFileToCreateDirectory.getParent());
                System.out.println("Finished create file directory");
            } else {
                System.out.println("File directory already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished create Create directory\n");
        }

        //Create directories
        try {
            Path sourceFileToMove = Paths.get("Move", "Move", "Move", "Move", "fileToMove.dat");

            if (!Files.exists(sourceFileToMove.getParent())) {
                Files.createDirectories(sourceFileToMove.getParent());
                System.out.println("Finished create file directory");
            } else {
                System.out.println("File directory already exists");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished create Create directory\nFinished create Move directory\n");
        }

        //Create file
        try {
            Path sourceFileToCreateDirectory = Paths.get("Create", "fileToCreate.dat");

            if (!Files.exists(sourceFileToCreateDirectory)) {
                Files.createFile(sourceFileToCreateDirectory);
                System.out.println("Finished create file");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished create fileToCreate\n");
        }

        //Move
        try {
            Path sourceFilePath = Paths.get("sourceFile.dat");
            Path sourceFileCopyPath = Paths.get("fileToMove.dat");

            Files.copy(sourceFilePath, sourceFileCopyPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished create fileToMove");
        }

        try {
            Path sourceFileCopyPath = Paths.get("fileToMove.dat");
            Path sourceFileToMove = Paths.get("Move", "Move", "Move", "fileToMove.dat");

            Files.move(sourceFileCopyPath, sourceFileToMove, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished move fileToMove\n");
        }

        //Rename
        try {
            Path sourceFilePath = Paths.get("sourceFile.dat");
            Path sourceFileCopyPath = Paths.get("fileToRename.dat");

            Files.copy(sourceFilePath, sourceFileCopyPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished create fileToRename");
        }

        try {
            Path sourceFileCopyPath = Paths.get("fileToRename.dat");
            Path sourceFileToMove = Paths.get("sourceFileRename.dat");

            Files.move(sourceFileCopyPath, sourceFileToMove, StandardCopyOption.REPLACE_EXISTING);
        } catch (FileAlreadyExistsException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished rename sourceFileMove\n");
        }

        //Atributes
        try {
            Path sourceFilePath = Paths.get("sourceFile.dat");

            System.out.println("sourceFilePath size is: " + Files.size(sourceFilePath));
            System.out.println("sourceFilePath last modified time is: " + Files.getLastModifiedTime(sourceFilePath));
            System.out.println("sourceFilePath is readable: " + Files.isReadable(sourceFilePath));
            System.out.println("sourceFilePath is writable: " + Files.isWritable(sourceFilePath));

            BasicFileAttributes sourceFilePathAttributes = Files.readAttributes(sourceFilePath, BasicFileAttributes.class);
            System.out.println("sourceFilePath size is: " + sourceFilePathAttributes.size());
            System.out.println("sourceFilePath creation time is: " + sourceFilePathAttributes.creationTime());
            System.out.println("sourceFilePath last modified time is: " + sourceFilePathAttributes.lastModifiedTime());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished read file atributes\n");
        }

        //First method of read directory contents
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(Paths.get("Move", "Move", "Move"), "*ve.dat")) {
            for (Path directory : contents) {
                System.out.println(directory.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished read directory contents\n");
        }

        //Second method of read directory contents
        try {
            Path directoryPath = Paths.get("Move", "Move", "Move");

            DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
                @Override
                public boolean accept(Path entry) throws IOException {
                    return (Files.isRegularFile(entry));
                }
            };

            try (DirectoryStream<Path> contents = Files.newDirectoryStream(directoryPath, filter)) {
                {
                    for (Path directory : contents) {
                        System.out.println(directory.getFileName());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished read directory contents\n");
        }

        //First method to read file store directory
        try {
            Iterable<FileStore> directory = FileSystems.getDefault().getFileStores();
            for (FileStore fileStore : directory) {
                System.out.println("Drive name: " + fileStore.name());
                System.out.println("Drive: " + fileStore);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished read file store directory\n");
        }

        //Second method to read file store directory
        try {
            Iterable<Path> directory = FileSystems.getDefault().getRootDirectories();
            for (Path fileStore : directory) {
                System.out.println("Drive: " + fileStore);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished read file store directory\n");
        }

        //Temporary file
        try {
            Path tempFilePath = Files.createTempFile("temp", ".dat");

            System.out.println(tempFilePath.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished create temporary file\n");
        }

        //Walk file tree first method
        try {
            Path directoryPath = Paths.get("Move");

            Files.walkFileTree(directoryPath, new NamePrinter());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished walk file tree\n");
        }

        //Walk file tree second method
        try {
            Path directoryPath = Paths.get("Move");

            Files.walkFileTree(directoryPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.toAbsolutePath());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.out.println("Failed access to file: " + file.toAbsolutePath());
                    return super.visitFileFailed(file, exc);
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println(dir.toAbsolutePath());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished walk file tree\n");
        }

        //Copy directory
        try {
            Path directoryPath = Paths.get("Move");
            Path directoryPathToCopy = Paths.get("Move2");

            Files.walkFileTree(directoryPath, new DirectoryCopy(directoryPath, directoryPathToCopy));
        } catch (FileAlreadyExistsException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished copy directory\n");
        }

        //Delete
        try {
            Path sourceFilePath = Paths.get("sourceFile.dat");

            Files.delete(sourceFilePath);
            Files.delete(Paths.get("sourceFileCopy1.dat"));
            Files.delete(Paths.get("sourceFileCopy2.dat"));
            Files.delete(Paths.get("sourceFileCopy3.dat"));
            Files.delete(Paths.get("sourceFileCopy4.dat"));
            Files.delete(Paths.get("sourceFileCopy5.dat"));
            Files.delete(Paths.get("Create", "fileToCreate.dat"));
            Files.delete(Paths.get("Create"));
            Files.delete(Paths.get("Move", "Move", "Move", "fileToMove.dat"));
            Files.delete(Paths.get("Move", "Move", "Move", "Move"));
            Files.delete(Paths.get("Move", "Move", "Move"));
            Files.delete(Paths.get("Move", "Move"));
            Files.delete(Paths.get("Move"));
            Files.walk(Paths.get("Move2"))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
            Files.delete(Paths.get("sourceFileRename.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished delete sourceFilePath");
        }
    }
}
