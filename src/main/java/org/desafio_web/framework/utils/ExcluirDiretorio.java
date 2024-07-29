package org.desafio_web.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ExcluirDiretorio {

    public static void excluirTodosArquivoDiretorio(String caminho) {
        String CREATE_FOLDER_CSV = System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + "CSV" + File.separator;

        Path directory = Paths.get(CREATE_FOLDER_CSV);

        if (Files.exists(directory)) {

            try {
                Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });

                System.out.println("Diretoria deletada com sucesso.");

            } catch (IOException e) {
                System.err.println("Erro ao deletar a diretoria: " + e.getMessage());
            }

        } else {
            System.out.println("Diretoria não encontrada: " + directory.toString());
        }

    }
}