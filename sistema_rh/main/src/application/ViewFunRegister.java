package application;

import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class ViewFunRegister {
    public static void verFunCadastrado (Scanner sc, List<Funcionario> funcionarios) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
                if (f.isAtivo()) {
                    System.out.printf("Codigo do Funcionario: %d - Nome: %s - Cargo: %s - Salario: %.2f - Total de horas Extras: %.2f - Valor a receber de horas Extras: %.2f - Total a receber: %.2f %n", i, f.getName(), f.getCargo().getNameCargo(), f.getSalario(), f.getHorasTrab(), f.getValorHoraExtra(), f.getTotalAReceber());
                }
                    
        }
    }
}   
