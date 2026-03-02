package services;

import java.util.List;
import java.util.Scanner;

import entities.Cargos;
import entities.Funcionario;
import utilities.VerifyCod;
import utilities.VerifyCodFun;

public class Promotion {
    public static void promocao(int codFun, List<Funcionario> funcionarios, Scanner sc) {
        String loginDigitado = null, senhaDigitada = null;
        codFun = VerifyCodFun.verificaCodFun(sc, codFun, funcionarios);
        Funcionario f = funcionarios.get(codFun);
        System.out.printf("Digite o Codigo do Cargo: %n");
        for (int l = 0; l < Cargos.values().length; l++) {
            System.out.printf("%d - %s%n", l, Cargos.values()[l].getNameCargo());
        }
        int codCargo = VerifyCod.verificaCod(0, Cargos.values().length, sc);
        f.setCargo(Cargos.values()[codCargo]);
        if (f.getCargo().getIsLideranca()) {
            System.out.printf("Cargo de Liderança Detectado %nRealize cadastro para acessar o Painel Administrativo %n");
            System.out.printf("Digite o Login: %n");
            loginDigitado = sc.nextLine();
            System.out.printf("Digite a Senha: %n");
            senhaDigitada = sc.nextLine();
            f.setAccount(loginDigitado, senhaDigitada);
        } else {
            System.out.printf("Login e/ou senha Invalidos");
        }

    }
}
