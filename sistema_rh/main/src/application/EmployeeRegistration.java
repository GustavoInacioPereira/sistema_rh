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
            for(int j = 0; j < Cargos.values().length; j++) {
                System.out.printf("%d - %s%n", j, Cargos.values()[j].getNameCargo());
            }
            int codCargo = sc.nextInt();
            VerifyCod.verificaCod(codCargo, 0, 2, sc);

            System.out.printf("Digite a opção abaixo: %n1 - Admitido na data de Hoje %n2 - Admitido em outra data %n");
            int option = sc.nextInt();
            VerifyCod.verificaCod(option, 0, 2, sc);

            
            switch (option) {
                case 1:
                    boolean isAdmittedToday = true;
                    funcionarios.add(new Funcionario(name, Cargos.values()[codCargo], isAdmittedToday));
                    break;
                case 2:
                    isAdmittedToday = false;
                    System.out.printf("Digite a data de admissão: (dd/MM/yyyy) %n");
                    sc.nextLine();
                    String date = sc.nextLine();
                    funcionarios.add(new Funcionario(name, Cargos.values()[codCargo], date));
                    break;
            
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
           
            
        
        System.out.printf("Funcionarios Cadastrados com Sucesso! %n");
    }
}
