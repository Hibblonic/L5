package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class GerarCSV {
    
    Funcionario funcionario;

    public static void gerar (Path arquivo) throws IOException{

        List<String> linhas = Files.readAllLines(arquivo);

        Path resultado = Paths.get("func_filtrado.csv");

        linhas.forEach(l->{

            if(!(l.contentEquals("Identificador,Est.civil,Inst,Filhos,Salario")))
            {
                String linhaSplit[] = l.split(",");
                Funcionario fun = new Funcionario();
                fun.setId(Integer.parseInt(linhaSplit[0]));
                fun.setFilho(Integer.parseInt(linhaSplit[3]));
                fun.setSalario(Float.parseFloat(linhaSplit[4]));;
                
                if(fun.getFilho()>0)
                {
                    try {
                        Files.writeString(resultado,fun.getId()+","+fun.getFilho()+","+fun.getSalario()+"\n",
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                try {
                    Files.writeString(resultado,"Identificador,Filhos,Salario\n",
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
                } catch (IOException e) {
                   
                    e.printStackTrace();
            }
            

        };
    });

}
}
