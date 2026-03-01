package utilities;

import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class VerifyCodFun {
    public static int verificaCodFun(Scanner sc, int codFun, List<Funcionario> funcionarios) {
        System.out.println("Digite o codigo de funcionario: ");
                    codFun = sc.nextInt();
                    do {
                         if (codFun < 0 || codFun >= funcionarios.size()) {
                            System.out.printf("Codigo Invalido %n Digite o codigo: %n");
                            codFun = sc.nextInt();         
                        }
                    } while (codFun < 0 || codFun >= funcionarios.size());
                    return codFun;
                }
    
}
