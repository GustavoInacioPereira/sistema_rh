package services;

import java.util.List;
import java.util.Scanner;
import entities.Funcionario;
import utilities.VerifyCod;
import utilities.VerifyCodFun;
import utilities.VerifyType;

public class SalaryIncrease {
    public static void aumentoSalario(Scanner sc, List<Funcionario> funcionarios, int codFun) {
        double aumento;
                    
                    codFun = VerifyCodFun.verificaCodFun(sc, codFun, funcionarios);
                    if (!funcionarios.get(codFun).isAtivo()) {
                        System.out.println("Não é possível realizar operações em funcionários excluídos!");
                    } else {
                        System.out.printf("Digite a opção: %n1 - Aumento com valor Bruto %n2 - Aumento em Porcentagem acima do salario base");
                        int escolhaOpcaoAumento = VerifyCod.verificaCod(1, 2, sc);
                    switch (escolhaOpcaoAumento) {
                        case 1:
                            System.out.printf("Digite o valor dado de aumento: %n");  
                            aumento = VerifyType.lerDouble(sc, "Valor Inválido");
                            funcionarios.get(codFun).setSalarioBruto(aumento);
                            break;
                    
                        case 2: 
                            System.out.print("Digite será a % dado de aumento:  (Não é necessario colocar %)"); 
                            aumento = VerifyType.lerDouble(sc, "Valor Inválido");
                            funcionarios.get(codFun).setSalarioPorcentagem(aumento);
                        default:
                            break;
                    }
                    }   

                    
    }
}
