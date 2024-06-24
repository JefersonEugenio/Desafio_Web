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
            System.out.println("Arquivo criado com sucesso!");
        } else {
            System.out.println("Arquivo já existe!");
        }
    }

    public static void deleteFile(String path) throws IOException {
        Path directoryDelete = Paths.get(path);
        boolean isDelete = Files.deleteIfExists(directoryDelete);

        if (isDelete) {
            System.out.println("Arquivo apagado com sucesso");
        } else {
            System.out.println("Arquivo não encontrado");
        }

    }

    public static void deleteDirectoryRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            // Se for um diretório, apagar o conteúdo recursivamente
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursively(entry);
                }
            }
        }
        // Finalmente, apagar o próprio arquivo ou diretório
        Files.delete(file.toPath());
    }

    public static void createDirectory(String path){
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

}