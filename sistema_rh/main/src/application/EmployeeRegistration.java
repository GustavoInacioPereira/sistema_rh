package application;

import java.util.List;
import java.util.Scanner;

import entities.Cargos;
import entities.Funcionario;

public class EmployeeRegistration {
    public static void cadastroFuncionario(Scanner sc, List<Funcionario> funcionarios) {         
            sc.nextLine();
            System.out.printf("Digite seu nome: %n");
            String name = sc.nextLine();
            System.out.printf("Digite o codigo do seu cargo: %n");
            for(int j = 0; j < Cargos.tab_cod.length; j++) {
                System.out.printf("%d - %s%n", j, Cargos.tab_cod[j].getNameCargo());
            }
            int codCargo = sc.nextInt();
           
            do {
                if (codCargo < 0 || codCargo > Cargos.tab_cod.length) {
                    System.out.println("Codigo Invalido ");
                    System.out.println("Digite outro codigo");
                    codCargo = sc.nextInt();
                }  
            } while (codCargo < 0 || codCargo > Cargos.tab_cod.length);
            funcionarios.add(new Funcionario(name, Cargos.tab_cod[codCargo]));
            
        
        IO.print("Funcionarios Cadastrados com Sucesso! ");
    }
}
