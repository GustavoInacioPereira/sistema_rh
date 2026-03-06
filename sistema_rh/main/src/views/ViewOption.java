package views;

import java.util.List;
import java.util.Scanner;
import entities.Funcionario;
import services.EmployeeRegistration;
import services.Promotion;
import services.SalaryIncrease;
import utilities.VerifyCod;
import utilities.VerifyCodFun;
import utilities.VerifyType;

public class ViewOption {

    public static void mostraOpcao(Scanner sc, List<Funcionario> funcionarios) {
        int codFun = 0;
        int escolhaOpcao;

        do {
            System.out.printf("%n=== MENU PRINCIPAL ===%n");
            System.out.printf("1 - Acessar Painel Administrativo %n2 - Ver Informações Publicas %n3 - Sair%n");

            escolhaOpcao = VerifyCod.verificaCod(1, 3, sc);

            switch (escolhaOpcao) {
                case 1:
                    System.out.printf("Digite o Login: %n");
                    String loginDigitado = sc.nextLine();
                    System.out.printf("Digite a Senha: %n");
                    String senhaDigitada = sc.nextLine();

                    boolean logado = false;

                    for (int i = 0; i < funcionarios.size(); i++) {
                        if (funcionarios.get(i).getAccount() != null && funcionarios.get(i).getAccount().validar(loginDigitado, senhaDigitada)) {
                            logado = true;
                            int escolhaAdmin;

                            do {
                                System.out.printf("%n=== PAINEL ADMINISTRATIVO ===%n");
                                System.out.printf(
                                        "1 - Ver todos os funcionarios cadastrados %n2 - Aumento para um Funcionario %n3 - Excluir um Funcionario cadastrado %n4 - Dar Horas Extras %n5 - Cadastrar Novo Funcionario %n6 - Promoção %n7 - Voltar ao Menu Principal %n");
                                escolhaAdmin = VerifyCod.verificaCod(1, 7, sc);

                                switch (escolhaAdmin) {
                                    case 1:
                                        ViewFunRegister.verFunCadastrado(sc, funcionarios);
                                        break;
                                    case 2:
                                        SalaryIncrease.aumentoSalario(sc, funcionarios, codFun);
                                        break;
                                    case 3:
                                        codFun = VerifyCodFun.verificaCodFun(sc, codFun, funcionarios);
                                        funcionarios.get(codFun).setAtivo(false);
                                        System.out.println("Funcionário excluído!");
                                        break;
                                    case 4:
                                        codFun = VerifyCodFun.verificaCodFun(sc, codFun, funcionarios);
                                        System.out.println("Digite a Quantidade de Horas extras: ");
                                        double horasExtras = VerifyType.lerDouble(sc, "Valor Inválido");
                                        funcionarios.get(codFun).setHorasTrab(horasExtras);
                                        break;
                                    case 5:
                                        EmployeeRegistration.cadastroFuncionario(sc, funcionarios, 1);
                                        break;
                                    case 6:
                                        Promotion.promocao(codFun, funcionarios, sc);
                                        break;
                                    case 7:
                                        System.out.println("Saindo do painel admin...");
                                        break;
                                }
                            } while (escolhaAdmin != 7);

                            break;
                        }
                    }

                    if (!logado) {
                        System.out.println("Login/Senha incorretos ou usuário sem privilégios.");
                    }
                    break;

                case 2:
                    ViewFunRegister.verFunCadastrado(sc, funcionarios);
                    break;

                case 3:
                    System.out.println("Encerrando o sistema...");
                    break;
            }
        } while (escolhaOpcao != 3); 
    }
}