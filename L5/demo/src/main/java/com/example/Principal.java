package com.example;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {
    
    public static void main(String[] args) throws IOException {
        
        Path arquivo = Paths.get("funcionarios.csv");

        GerarCSV.gerar(arquivo);
    }

}
