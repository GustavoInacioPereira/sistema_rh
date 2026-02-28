package application;

import java.util.List;
import java.util.Scanner;

import entities.Funcionario;
import entities.FuncionarioLideranca;

public class AuthenticateFun {
    public static void autenticarFun(Scanner sc, List<Funcionario> funcionarios) {
        System.out.printf("Digite a Opção: %n1 - Acessar Painel Admnistrativo %n2 - Ver Informações Publicas %n");
        int opcao = sc.nextInt();
        sc.nextLine();
        boolean es = true, loginSuccess = false;
        opcao = VerifyCod.verificaCod(opcao, 1, 2, sc);

        switch (opcao) {
            case 1:
                System.out.printf("Digite o Login: %n");
                String loginDigitado = sc.nextLine();
                System.out.printf("Digite a Senha: %n");
                String senhaDigitada = sc.nextLine();


                for(int i = 0; i<funcionarios.size(); i++) {
                    if(funcionarios.get(i) instanceof FuncionarioLideranca) {
                        FuncionarioLideranca lider = (FuncionarioLideranca) funcionarios.get(i);
                        if (lider.autenticar(loginDigitado, senhaDigitada)) { 
                            loginSuccess = true;
                         }
                    }
                }

                if (loginSuccess) {
                    do {
                       ViewOption.mostraOpcao(sc, funcionarios);
                    } while (es == true);
                } else {
                    System.out.println("Login ou senha incorretos, ou usuário não é líder!");
                }
                autenticarFun(sc, funcionarios);
                break;

            case 2:
                ViewFunRegister.verFunCadastrado(sc, funcionarios);
                autenticarFun(sc, funcionarios);
            default:
                break;
        }

    }
}
