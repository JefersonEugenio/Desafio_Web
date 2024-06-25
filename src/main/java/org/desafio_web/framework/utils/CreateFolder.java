package org.desafio_web.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFolder {

    public static void createFolderFile(String path) throws IOException {

        Path createFile = Paths.get(path);
        if (!Files.exists(createFile)) {
            Files.createFile(createFile);
        } else {
            System.out.println("Arquivo já existe!");
        }
    }

    public static void deleteFile(String path) throws IOException {
        Path directoryDelete = Paths.get(path);
        boolean isDelete = Files.deleteIfExists(directoryDelete);

        if (isDelete) {

        } else {
            System.out.println("Arquivo não encontrado");
        }

    }

    public static void createDirectory(String path){
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

}