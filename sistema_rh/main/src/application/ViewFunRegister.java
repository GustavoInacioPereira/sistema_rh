package application;

import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class ViewFunRegister {
    public static void verFunCadastrado (Scanner sc, List<Funcionario> funcionarios) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
                if (f.isAtivo()) {
                    System.out.printf("Codigo do Funcionario: %d%nNome: %s%nCargo: %s%nSalario: %.2f %nData Admissão: %s%nTotal de horas Extras: %.2f%nValor a receber de horas Extras: %.2f%nTotal a receber: %.2f %n%n", i, f.getName(), f.getCargo().getNameCargo(), f.getSalario(),f.getDataAdmissao() ,f.getHorasTrab(), f.getValorHoraExtra(), f.getTotalAReceber());
                }
                    
        }
    }
}   
