package views;

import java.util.List;
import java.util.Scanner;
import entities.Funcionario;
import services.EmployeeRegistration;
import services.Promotion;
import services.SalaryIcrease;
import utilities.VerifyCod;
import utilities.VerifyCodFun;

public class ViewOption {
    static int escolhaOpcao;

    public static void mostraOpcao(Scanner sc, List<Funcionario> funcionarios) {
        int codFun = 0;

        System.out.printf("Digite a Opção %n1 - Acessar Painel Administrativo %n2 - Ver Informações Publicas %n3 - Sair%n");
        escolhaOpcao = sc.nextInt();
        sc.nextLine();
        escolhaOpcao = VerifyCod.verificaCod(escolhaOpcao, 1, 3, sc);

        switch (escolhaOpcao) {
            case 1:
                System.out.printf("Digite o Login: %n");
                String loginDigitado = sc.nextLine();
                System.out.printf("Digite a Senha: %n");
                String senhaDigitada = sc.nextLine();
                for (int i = 0; i < funcionarios.size(); i++) {
                    if (funcionarios.get(i).getAccount() != null && funcionarios.get(i).getAccount().validar(loginDigitado, senhaDigitada)) {
                        do {

                            System.out.printf(
                                    "Digite a opção desejada: %n1 - Ver todos os funcionarios cadastrados %n2 - Aumento para um Funcionario %n3 - Excluir um Funcionario cadastrado %n4 - Dar Horas Extras %n5 - Cadastrar Novo Funcionario %n6 - Promoção %n7 - Sair %n");
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
                                    funcionarios.get(codFun).setAtivo(false);
                                    ;
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
                                    Promotion.promocao(codFun, funcionarios, sc);
                                    ViewOption.mostraOpcao(sc, funcionarios);
                                    break;
                                case 7:
                                    ViewOption.mostraOpcao(sc, funcionarios);
                                    break;

                                default:
                                    break;
                            }
                        } while (escolhaOpcao != 6);
                    }
                }

                break;

            case 2:
                ViewFunRegister.verFunCadastrado(sc, funcionarios);
                ViewOption.mostraOpcao(sc, funcionarios);
            case 3:
                break;
            default:
                break;
        }

    }

}
