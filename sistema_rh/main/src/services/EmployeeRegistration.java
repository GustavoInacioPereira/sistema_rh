package services;

import java.util.List;
import java.util.Scanner;
import entities.Cargos;
import entities.Funcionario;
import utilities.VerifyCod;
import entities.Contracts;

public class EmployeeRegistration {
    public static void cadastroFuncionario(Scanner sc, List<Funcionario> funcionarios, int quanFun) {
        for (int indice = 0; indice < quanFun; indice++) {
            System.out.printf("Digite seu nome: %n");
            String name = sc.nextLine();
            System.out.printf("Digite o codigo do seu cargo: %n");
            for (int j = 0; j < Cargos.values().length; j++) {
                System.out.printf("%d - %s%n", j, Cargos.values()[j].getNameCargo());
            }

            int codCargo = VerifyCod.verificaCod(0, (Cargos.values().length - 1), sc);

            System.out.printf("Digite o Regime de Trabalho: %n");
            for (int i = 0; i < Contracts.values().length; i++) {
                System.out.printf("%d - %s%n", i + 1, Contracts.values()[i]);
            }
            int optionRegime = VerifyCod.verificaCod(1, Contracts.values().length, sc);
            Contracts escolhaRegimeContrato = Contracts.CLT;
            switch (optionRegime) {
                case 1:
                    escolhaRegimeContrato = Contracts.CLT;
                    break;
                case 2:
                    escolhaRegimeContrato = Contracts.PJ;
                    break;
                case 3:
                    escolhaRegimeContrato = Contracts.ESTAGIO;
                    break;
                case 4:
                    escolhaRegimeContrato = Contracts.TEMPORARIO;
                    break;
                default:
                    break;
            }

            System.out.printf("Digite a opção abaixo: %n1 - Admitido na data de Hoje %n2 - Admitido em outra data %n");
            int optionAdmissao = VerifyCod.verificaCod(1, 2, sc);

            Funcionario funcionario = null;
            switch (optionAdmissao) {
                case 1:
                    boolean isAdmittedToday = true;
                    funcionario = new Funcionario(name, Cargos.values()[codCargo], isAdmittedToday,
                            escolhaRegimeContrato);
                    break;
                case 2:
                    isAdmittedToday = false;
                    System.out.printf("Digite a data de admissão: (dd/MM/yyyy) %n");
                    sc.nextLine();
                    String date = sc.nextLine();
                    funcionario = new Funcionario(name, Cargos.values()[codCargo], date, escolhaRegimeContrato);
                    break;

                default:
                    System.out.println("Opção Invalida");
                    break;
            }

            if (funcionario.getCargo().getIsLideranca()) {
                System.out.printf(
                        "Cargo de Liderança Detectado %nRealize cadastro para acessar o Painel Administrativo %n");
                System.out.printf("Digite o Login: %n");
                String loginDigitado = sc.nextLine();
                System.out.printf("Digite a Senha: %n");
                String senhaDigitada = sc.nextLine();
                funcionario.setAccount(loginDigitado, senhaDigitada);
            }
            funcionarios.add(funcionario);
            System.out.printf("Funcionario Cadastrado com Sucesso! %n");

        }

    }

}
