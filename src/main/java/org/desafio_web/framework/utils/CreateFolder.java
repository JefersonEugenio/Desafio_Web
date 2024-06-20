package org.desafio_web.framework.utils;

import java.io.File;

public class CreateFolder {

    public static void createDirectory(String path){
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
        File file = new File(directory + File.separator + "dados.properties");
        System.out.println(">>> " + file);
    }

}
