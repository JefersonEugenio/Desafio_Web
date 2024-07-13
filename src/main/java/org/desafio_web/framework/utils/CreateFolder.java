package org.desafio_web.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CreateFolder {

    public static void createDirectory(String path){
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("A pasta foi criada!");
        }
    }

    public static void deleteDirectoryRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursively(entry);
                }
            }
        }
        Files.delete(file.toPath());
    }

}