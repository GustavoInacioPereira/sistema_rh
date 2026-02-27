package application;

import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class ViewFunRegister {
    public static void verFunCadastrado (Scanner sc, List<Funcionario> funcionarios) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
                if (f.isAtivo()) {
                    System.out.printf("Codigo do Funcionario: %d%nNome: %s%nCargo: %s%nSalario: %.2f %nRegime de Trabalho: %s%nCarga Semanal: %d%nDireito à Ferias: %s%nDireito a FGTS: %s%nData Admissão: %s%nTotal de horas Extras: %.2f%nValor a receber de horas Extras: %.2f%nDescontos Contratuais: %.2f%nTotal a receber: %.2f %n%n", i, f.getName(), f.getCargo().getNameCargo(), f.getSalario(),f.getContracts().getNameContract(),f.getContracts().getCargaSemanal(),f.getContracts().getDireitoFerias() ? "Sim" : "Não",f.getContracts().getFGTS() ? "Sim" : "Não",f.getDataAdmissao() ,f.getHorasTrab(), f.getValorHoraExtra(),f.getDescontoContratual() ,f.getTotalAReceber());
                }
                    
        }
    }
}   
