package services;

import java.util.List;
import java.util.Scanner;
import entities.Funcionario;
import utilities.VerifyCodFun;

public class SalaryIcrease {
    public static void aumentoSalario(Scanner sc, List<Funcionario> funcionarios, int codFun) {
        double aumento;
                    
                    codFun = VerifyCodFun.verificaCodFun(sc, codFun, funcionarios);
                    if (!funcionarios.get(codFun).isAtivo()) {
                        System.out.println("Não é possível realizar operações em funcionários excluídos!");
                    } else {
                        System.out.printf("Digite a opção: %n1 - Aumento com valor Bruto %n2 - Aumento em Porcentagem acima do salario base");
                    int escolhaOpcaoAumento = sc.nextInt();
                    
                    do {
                         if (escolhaOpcaoAumento < 0 || escolhaOpcaoAumento > 2) {
                            System.out.printf("Opção Invalida %n Digite a opção: %n");
                            escolhaOpcaoAumento = sc.nextInt();         
                        }
                    } while (escolhaOpcaoAumento < 0 || escolhaOpcaoAumento > 2);

                    switch (escolhaOpcaoAumento) {
                        case 1:
                            System.out.printf("Digite o valor dado de aumento: %n");  
                            aumento = sc.nextDouble();
                            funcionarios.get(codFun).setSalarioBruto(aumento);
                            break;
                    
                        case 2: 
                            System.out.print("Digite será a % dado de aumento:  (Não é necessario colocar %)"); 
                            aumento = sc.nextDouble();
                            funcionarios.get(codFun).setSalarioPorcentagem(aumento);
                        default:
                            break;
                    }
                    }   

                    
    }
}
