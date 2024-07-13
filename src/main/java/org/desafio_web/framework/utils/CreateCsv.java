package org.desafio_web.framework.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import org.desafio_web.framework.data.EncapsulationData;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CreateCsv {

    public static String PATH_CSV = System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "main" + File.separator
            + "resources" + File.separator + "CSV" + File.separator;

    public static void inserirDados(String conta, String email, String nome, String senha) throws IOException {
        String[] cabecalho = {"Conta", "Email", "Nome", "Senha", "Transferir"};

        List<String[]> linhas = new ArrayList<>();
        linhas.add(new String[]{conta, email, nome, senha});

        Writer writer = Files.newBufferedWriter(Paths.get( PATH_CSV + nome + ".csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        csvWriter.flush();
        writer.close();
    }

    public static void inserirValorTransfer(String transfer) throws IOException {
        String[] cabecalho = {"Valor_transfer"};

        List<String[]> linhas = new ArrayList<>();
        linhas.add(new String[]{transfer});

        Writer writer = Files.newBufferedWriter(Paths.get( PATH_CSV  + "transfer.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        csvWriter.flush();
        writer.close();
    }

    public static String leituraDados(EncapsulationData user) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(PATH_CSV + user.getName() + ".csv"));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> pessoas = csvReader.readAll();
        for (String[] pessoa : pessoas)
            return pessoa[0];
        return null;
    }

}