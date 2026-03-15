package views;

import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class ViewFunRegister {
    public static void verFunCadastrado(Scanner sc, List<Funcionario> funcionarios) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);

            if (f.isAtivo()) {
                if (!f.getContracts().isPermiteHoraExtra()) {
                    System.out.printf(
                            """
                            Codigo do Funcionario: %d
                            Nome: %s
                            Cargo: %s
                            Salario: %.2f
                            Regime de Trabalho: %s
                            Direito à Ferias: %s
                            Direito a FGTS: %s
                            Data Admissão: %s
                            Descontos Contratuais: %.2f
                            Total a receber: %.2f

                                """, 
                            f.getId(),
                            f.getName(),
                            f.getCargo().getNameCargo(),
                            f.getSalario(),
                            f.getContracts().getNameContract(),
                            f.getContracts().getDireitoFerias() ? "Sim" : "Não",
                            f.getContracts().getFGTS() ? "Sim" : "Não",
                            f.getDataAdmissao(),
                            f.getDescontoContratual(),
                            f.getTotalAReceber());

                } else {
                        System.out.printf(
                            """
                            Codigo do Funcionario: %d
                            Nome: %s
                            Cargo: %s
                            Salario: %.2f
                            Regime de Trabalho: %s
                            Carga Semanal: %d
                            Direito à Ferias: %s
                            Direito a FGTS: %s
                            Data Admissão: %s
                            Total de Horas Extras: %.2f
                            Valor a receber de horas Extras: %.2f
                            Descontos Contratuais: %.2f
                            Total a receber: %.2f

                                """, 
                            f.getId(),
                            f.getName(),
                            f.getCargo().getNameCargo(),
                            f.getSalario(),
                            f.getContracts().getNameContract(),
                            f.getContracts().getCargaSemanal(),
                            f.getContracts().getDireitoFerias() ? "Sim" : "Não",
                            f.getContracts().getFGTS() ? "Sim" : "Não",
                            f.getDataAdmissao(),
                            f.getHorasTrab(),
                            f.getValorHoraExtra(),
                            f.getDescontoContratual(),
                            f.getTotalAReceber()
                        );
 
                }

            }

        }
    }
}
