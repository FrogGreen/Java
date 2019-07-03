package com.company;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryCopy extends SimpleFileVisitor<Path> {

    private Path primaryDestination;
    private Path targetDestination;

    public DirectoryCopy(Path primaryDestination, Path targetDestination) {
        this.primaryDestination = primaryDestination;
        this.targetDestination = targetDestination;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativePath = primaryDestination.relativize(file);
        System.out.println("relativePath: " + relativePath);

        Path resolvePath = targetDestination.resolve(relativePath);
        System.out.println("resolvePath: " + resolvePath);

        try {
            Files.copy(file, resolvePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Failed access to file: " + file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativePath = primaryDestination.relativize(dir);
        System.out.println("relativePath: " + relativePath);

        Path resolvePath = targetDestination.resolve(relativePath);
        System.out.println("resolvePath: " + resolvePath);

        try {
            Files.copy(dir, resolvePath);
        } catch (IOException e) {
            e.printStackTrace();
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }
}
