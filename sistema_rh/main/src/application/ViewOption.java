package application;

import java.util.List;
import java.util.Scanner;
import entities.Funcionario;
public class ViewOption { 
static int escolhaOpcao;
       
    public static void mostraOpcao (Scanner sc, List<Funcionario> funcionarios) {
        int codFun = 0;
       
            System.out.printf("Digite a opção desejada: %n1 - Ver todos os funcionarios cadastrados %n2 - Aumento para um Funcionario %n3 - Excluir um Funcionario cadastrado %n4 - Dar Horas Extras %n5 - Cadastrar Novo Funcionario %n6 - Sair%n");
            escolhaOpcao = sc.nextInt();
            switch (escolhaOpcao) {
                case 1:
                    ViewFunRegister.verFunCadastrado(sc, funcionarios);
                    break;

                case 2:
                    SalaryIcrease.aumentoSalario(sc, funcionarios, codFun);       
                    break;

                case 3:
                    codFun = VerifyCodFun.verificaCodFun(sc, codFun, funcionarios);
                    funcionarios.get(codFun).setAtivo(false);;
                    break;

                case 4:
                    codFun = VerifyCodFun.verificaCodFun(sc, codFun, funcionarios);
                    System.out.println("Digite a Quantidade de Horas extras: ");
                    double horasExtras = sc.nextDouble();
                    funcionarios.get(codFun).setHorasTrab(horasExtras);

                    break;

                case 5:
                    EmployeeRegistration.cadastroFuncionario(sc, funcionarios);
                    break;

                case 6:
                    AuthenticateFun.autenticarFun(sc, funcionarios);
                    break;

                default:
                    break;
        }
        
        
    }



}
 
 
 
